/*
 * @Author: Tungbo
 * @Date: 2022-10-10 10:48:14
 * @LastEditTime: 2022-10-10 15:37:32
 * @LastEditors: Tungbo
 * @Description: leecode: 801. 使序列递增的最小交换次数
 * 
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 *   例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8]
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221010;

public class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        // f[i][0/1] 表示让 nums1 和 nums2 的前 i 个数严格递增所需操作的最小次数
        // 其中 f[i][0] 不交换 nums1[i] 和 nums2[i]，f[i][1] 交换 nums1[i] 和 nums2[i]
        var n = nums1.length;
        var f = new int[n][2];
        f[0][1] = 1;
        for (var i = 1; i < n; i++) {
            f[i][0] = n; // 答案不会超过 n，故初始化成 n 方便后面取 min
            f[i][1] = n;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }
}
