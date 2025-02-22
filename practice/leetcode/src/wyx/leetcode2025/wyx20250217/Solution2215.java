/*
 * @Author: Tungbo
 * @Date: 2025-02-22 15:23:58
 * @LastEditTime: 2025-02-22 15:34:04
 * @LastEditors: Tungbo
 * @Description: leecode: 2215. 找出两数组的不同
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250217;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2215 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> dic = new HashSet<Integer>();
        Set<Integer> dic2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            dic.add(nums1[i]);
        }
        for (int num : nums2) {
            dic2.add(num);
        }
        Set<Integer> ans1 = new HashSet<>();
        Set<Integer> ans2 = new HashSet<>();
        for (int num : nums1) {
            if (!dic2.contains(num)) {
                ans1.add(num);
            }
        }
        for (int num : nums2) {
            if (!dic.contains(num)) {
                ans2.add(num);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(ans1));
        res.add(new ArrayList<>(ans2));
        return res;
    }
}
