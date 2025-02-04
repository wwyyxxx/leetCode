package practice.leetcode.src.wyx.leetcode2023.wyx20230227;

/*
 * @Author: Tungbo
 * @Date: 2023-03-04 15:48:59
 * @LastEditTime: 2023-03-04 15:49:06
 * @LastEditors: Tungbo
 * @Description: leecode: 982. 按位与为零的三元组
 */
public class Solution982 {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dic = new int[1<<16];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dic[nums[i] & nums[j]]++;
            }
        }
        for(int x : nums) {
            for(int k = 0; k < 1<<16; k++) {
                if((x & k) == 0)  ans += dic[k];
            }
        }
        return ans;
    }
}
