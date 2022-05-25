/*
 * @Author: Tungbo
 * @Date: 2022-05-25 17:32:19
 * @LastEditTime: 2022-05-25 17:32:21
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 068. 查找插入位置
 * 
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 */
public class Solution068 {
    
    //二分查找 插入到后面
    public int searchInsert(int[] nums, int target) {

        int low = 0, height = nums.length -1, ans = nums.length;
        while(low <= height) {
            int mid = low + (height - low) / 2;
            int num = nums[mid];
            if(target <= num) { //插入到后面
                ans = mid;
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
