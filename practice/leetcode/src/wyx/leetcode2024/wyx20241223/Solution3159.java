package practice.leetcode.src.wyx.leetcode2024.wyx20241223;

import java.util.HashMap;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2024-12-26 22:20:32
 * @LastEditTime: 2024-12-27 22:40:34
 * @LastEditors: Tungbo
 * @Description: leecode: 3159. 查询数组中元素的出现位置
 */
public class Solution3159 {



    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if(nums[i] == x) {
                map.put(cnt++, i);
            }
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = map.getOrDefault(queries[i], -1);
        }
        return res;
    }
}
