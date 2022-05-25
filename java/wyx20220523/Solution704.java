/*
 * @Author: Tungbo
 * @Date: 2022-05-25 16:59:14
 * @LastEditTime: 2022-05-25 17:07:06
 * @LastEditors: Tungbo
 * @Description: leecode: 704. 二分查找
 * 
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 
 */
public class Solution704 {
    
    //二分查找
    public int search(int[] nums, int target) {
        //注意右边界
        int left = 0, right = nums.length - 1;
        while(left <= right){
            // right + left  有可能越界
            // (right - left) / 2 + left = (right + left) / 2
            // right - left + 2left = right + left
            int mid = (right - left) / 2 + left;
            if(target < nums[mid]) {
                right = mid-1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return ans;
    }
}
