package practice.leetcode.src.wyx.leetcode2024.wyx20240722;

/*
 * @Author: Tungbo
 * @Date: 2024-07-27 23:35:51
 * @LastEditTime: 2024-07-27 23:36:54
 * @LastEditors: Tungbo
 * @Description: leecode: 4. 寻找两个正序数组的中位数
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for(int i = 0; i <= len/2; i++) {
            left = right;
            if(aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        return (len & 1) == 0 ? (left + right) / 2.0 : right;
    }
}