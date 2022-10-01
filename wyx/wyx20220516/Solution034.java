package wyx.wyx20220516;

/*
 * @Author: Tungbo
 * @Date: 2022-05-21 16:48:46
 * @LastEditTime: 2022-05-26 21:58:04
 * @LastEditors: Tungbo
 * @Description: leecode: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 
 */
public class Solution034 {
    
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};

        int l = 0, r = nums.length-1;
        int halft = (l+r)/2;
        while(l <= r){
            if(nums[halft] > target ) {
                r = halft-1;
                halft = (l + r) / 2;
            } else if(nums[halft] < target) {
                l = halft+1;
                halft = (l + r) / 2;
            } else {
                int temp = halft;
                while(temp >= 0 && nums[temp] == target) {
                    res[0] = temp--;
                }
                while(halft < nums.length && nums[halft] == target) {
                    res[1] = halft++;
                }
                return res;
            }

        }
        return res;
    }
}
