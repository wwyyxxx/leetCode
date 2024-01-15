/*
 * @Author: Tungbo
 * @Date: 2022-09-13 15:00:31
 * @LastEditTime: 2022-09-13 15:06:12
 * @LastEditors: Tungbo
 * @Description: leecode: 670. 最大交换
 * 
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值
 * 
 */
package wyx.wyx20220912;

public class Solution670 {

    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(nums, i, j);
                num = Math.max(num, Integer.valueOf(String.valueOf(nums)));
                swap(nums, i, j);
            }
        }
        return num;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
