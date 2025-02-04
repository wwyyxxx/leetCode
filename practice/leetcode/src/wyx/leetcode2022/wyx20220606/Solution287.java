/*
 * @Author: Tungbo
 * @Date: 2022-06-08 12:34:20
 * @LastEditTime: 2022-06-08 13:03:08
 * @LastEditors: Tungbo
 * @Description: leecode: 287. 寻找重复数
 * 
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

public class Solution287 {
    
    public int findDuplicate1(int[] nums) {
        int[] dic = new int[nums.length];
        for(int num : nums) {
            if(dic[num]++ >=1 ) return num;
        }
        return -1;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);
        slow = 0;
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


}
