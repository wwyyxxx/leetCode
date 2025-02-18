/*
 * @Author: Tungbo
 * @Date: 2025-02-18 21:16:47
 * @LastEditTime: 2025-02-18 21:47:11
 * @LastEditors: Tungbo
 * @Description: leecode: 2080. 区间内查询数字的频率
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RangeFreqQuery {

    HashMap<Integer, List<Integer>> dic = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            dic.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = dic.getOrDefault(value, new ArrayList<>());
        if (list == null) {
            return 0;
        }
        return lowrBound(list, right + 1) - lowrBound(list, left);
    }

    private int lowrBound(List<Integer> list, int target) {
        int left = -1;
        int right = list.size();
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
