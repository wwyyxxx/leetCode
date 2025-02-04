/*
 * @Author: Tungbo
 * @Date: 2023-11-21 13:56:11
 * @LastEditTime: 2023-11-21 14:07:53
 * @LastEditors: Tungbo
 * @Description: leecode: 2216. 美化数组的最少删除数
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231106;

public class Solution2216 {

    public int minDeletion(int[] nums) {
        int n = nums.length, cnt = 0;
        if(nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = (i - cnt);
            if (idx % 2 == 0 
            && i + 1 < n
            && nums[i] == nums[i+1]) {
                if(nums[i] == nums[i+1]) cnt++;
            }
        }
        return (nums.length - cnt) % 2 == 0 ? cnt : cnt+1;
    }

}
