/*
 * @Author: Tungbo
 * @Date: 2022-05-26 21:46:25
 * @LastEditTime: 2022-05-26 21:58:07
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220516;/*
 * @Author: Tungbo
 * @Date: 2022-05-18 16:59:01
 * @LastEditTime: 2022-05-18 18:27:05
 * @LastEditors: Tungbo
 * @Description: leecode: 75. 颜色分类
 * 
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 
 */
public class Solution075 {
    
    //插入排序
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n;i++) {
            int temp = nums[i];
            int j = i;
            while(j > 0 && temp <= nums[j-1]) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    //双指针
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int p0=0,p2 = n-1;
        for(int i = 0; i <= p2; i++) {
            while(p2 > i && nums[i] == 2) {
                swap(nums, p2, i);
                p2--;
            }
            if(nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            }
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
