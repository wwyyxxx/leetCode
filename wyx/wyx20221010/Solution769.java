/*
 * @Author: Tungbo
 * @Date: 2022-10-13 15:45:55
 * @LastEditTime: 2022-10-13 16:14:20
 * @LastEditors: Tungbo
 * @Description: leecode: 769. 最多能完成排序的块
 * 
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同
 * 返回数组能分成的最多块数量
 * 
 */
package wyx.wyx20221010;

public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if(max == i)
                ans++;
        }
        return ans;
    }
}
