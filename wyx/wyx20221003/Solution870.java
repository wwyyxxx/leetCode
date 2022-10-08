/*
 * @Author: Tungbo
 * @Date: 2022-10-08 11:04:24
 * @LastEditTime: 2022-10-08 11:31:35
 * @LastEditors: Tungbo
 * @Description: leecode: 870. 优势洗牌
 * 
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化
 * 
 */
package wyx.wyx20221003;

import java.util.Arrays;

public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Integer[] ids = new Integer[n];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a,b)->(nums2[a] - nums2[b]));
        int left = 0, right = n - 1;
        for (Integer num : nums1) {
            int i = num < nums2[ids[left]] ? right-- : left++;
            res[i] = num;
        }
        return res;
    }
}
