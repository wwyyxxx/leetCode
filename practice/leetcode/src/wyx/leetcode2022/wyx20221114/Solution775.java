/*
 * @Author: Tungbo
 * @Date: 2022-11-16 15:28:46
 * @LastEditTime: 2022-11-16 16:05:44
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
/*
 * @Author: Tungbo
 * @Date: 2022-11-16 15:28:46
 * @LastEditTime: 2022-11-16 15:38:08
 * @LastEditors: Tungbo
 * @Description: leecode: 775. 全局倒置与局部倒置
 * 
 * 局部倒置： 只后一个数比前一个数大
 * 全局倒置： 包含局部倒置，没有限制
 * 
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221114;

public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int max  = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] < max) return false;
            max = Math.max(max, nums[i-1]);
        }
        return true;
    }
}
