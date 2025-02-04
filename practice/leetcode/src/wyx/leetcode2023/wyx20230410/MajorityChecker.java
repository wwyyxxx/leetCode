package practice.leetcode.src.wyx.leetcode2023.wyx20230410;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2023-04-16 11:59:04
 * @LastEditTime: 2023-04-16 13:03:13
 * @LastEditors: Tungbo
 * @Description: leecode: 1157. 子数组中占绝大多数的元素
 */
public class MajorityChecker {
    int[] cnt, val, arr;
    int n;
    List<Integer>[] rec = new List[20005];

    public MajorityChecker(int[] _arr) {
        n = _arr.length;
        cnt = new int[5 * n];
        val = new int[5 * n];
        Arrays.setAll(rec, value -> new ArrayList<>());
        arr = _arr;
        for (int i = 0; i < n; i++)
            rec[arr[i]].add(i);
        build(1, 0, n - 1);
        for (int i = 1; i <= 20000; i++)
            rec[i].add(n + 1);
    }

    void build(int id, int l, int r) {
        if (l == r) {
            cnt[id] = 1;
            val[id] = arr[r];
            return;
        }
        int mid = (l + r) >> 1;
        build(id << 1, l, mid);
        build((id << 1) | 1, mid + 1, r);
        if (val[id << 1] == val[(id << 1) | 1]) {
            val[id] = val[id << 1];
            cnt[id] = cnt[id << 1] + cnt[(id << 1) | 1];
        } else if (cnt[id << 1] >= cnt[(id << 1) | 1]) {
            cnt[id] = cnt[id << 1] - cnt[(id << 1) | 1];
            val[id] = val[id << 1];
        } else {
            cnt[id] = cnt[(id << 1) | 1] - cnt[id << 1];
            val[id] = val[(id << 1) | 1];
        }

    }

    int[] query(int id, int l, int r, int x, int y) {
        if (x <= l && r <= y)
            return new int[] { cnt[id], val[id] };
        int mid = (l + r) >> 1;
        if (y <= mid)
            return query(id << 1, l, mid, x, y);
        if (x > mid)
            return query((id << 1) | 1, mid + 1, r, x, y);
        int[] left = query(id << 1, l, mid, x, y), right = query((id << 1) | 1, mid + 1, r, x, y);
        if (left[1] == right[1]) {
            left[0] += right[0];
        } else if (left[0] >= right[0]) {
            left[0] -= right[0];
        } else {
            left[1] = right[1];
            left[0] = right[0] - left[0];
        }
        return left;
    }

    public int query(int left, int right, int threshold) {
        int ask = query(1, 0, n - 1, left, right)[1];
        if (search(rec[ask], right + 1) - search(rec[ask], left) < threshold)
            ask = -1;
        return ask;
    }

    int search(List<Integer> rec, int x) {
        int l = 0, r = rec.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (rec.get(mid) >= x)
                r = mid;
            else
                l = mid + 1;
        }
        return r;
    }
}
