package practice.leetcode.src.wyx.leetcode2025.wyx20250210;

/*
 * @Author: Tungbo
 * @Date: 2025-02-14 22:54:45
 * @LastEditTime: 2025-02-14 22:54:50
 * @LastEditors: Tungbo
 * @Description: leecode: 1552. 两球之间的磁力
 */

import java.util.Arrays;

public class Solution1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
