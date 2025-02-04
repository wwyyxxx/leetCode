/*
 * @Author: Tungbo
 * @Date: 2022-11-19 16:37:23
 * @LastEditTime: 2022-11-19 16:48:30
 * @LastEditors: Tungbo
 * @Description: leecode: 1732. 找到最高海拔
 * 
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
 * 自行车手从海拔为 0 的点 0 开始骑行
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。
 * 请你返回 最高点的海拔
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221114;

public class Solution1732 {

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < gain.length; i++) {
            temp += gain[i];
            ans = Math.max(ans,temp);
        }
        return ans;
    }

}
