/*
 * @Author: Tungbo
 * @Date: 2025-01-30 13:35:30
 * @LastEditTime: 2025-01-30 13:59:41
 * @LastEditors: Tungbo
 * @Description: leecode: 350. 两个数组的交集 II
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20250128;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            dic.put(nums1[i], dic.getOrDefault(nums1[i], 0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (dic.containsKey(nums2[i]) && dic.get(nums2[i]) >= 1) {
                res.add(nums2[i]);
                dic.put(nums2[i],dic.get(nums2[i]) - 1);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
