/*
 * @Author: Tungbo
 * @Date: 2022-08-18 21:13:55
 * @LastEditTime: 2022-08-18 22:22:42
 * @LastEditors: Tungbo
 * @Description: leecode: 1224. 最大相等频率
 * 
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度
 *  从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）
 * 
 */
package wyx.wyx20220815;

import java.util.Arrays;

public class Solution1224 {
    //cnt 每个数出现最多的次数
    //sum 次数为某个值的数有多少个
    int[] cnt = new int[100005], sum = new int[100005];
    public int maxEqualFreq(int[] nums) {
        Arrays.fill(cnt, 0);
        Arrays.fill(sum, 0);
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i], cur = ++cnt[t], len = i + 1;
            sum[cur]++; sum[cur - 1]--;
            max = Math.max(max, cur);
            if(max == 1) ans = len;
            if(max * sum[max] + 1 == len) ans = len;
            if((max - 1) * (sum[max - 1] + 1) + 1 == len) ans = len;
        }
        return ans;
    }

}
