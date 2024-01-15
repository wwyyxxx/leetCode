package wyx.wyx20220530;

/*
 * @Author: Tungbo
 * @Date: 2022-05-30 16:14:28
 * @LastEditTime: 2022-05-30 16:37:59
 * @LastEditors: Tungbo
 * @Description: leecode: 238. 除自身以外数组的乘积
 * 
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 */
public class Solution238 {

    public static void main(String[] args) {
        System.out.println(123123);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int ans = 1;
        //上三角 计算最后一个结果
        for(int i = 0; i < nums.length; i++) {
            answer[i] = ans;
            ans *= nums[i];
        }
        //下三角 对于上三角相乘 
        ans = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans *= nums[i];
            //错开自身差值
            answer[i-1] *= ans;
        }
        return answer;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] answer = new int[nums.length];
        int ans = 1;
        for(int num: nums) {
            ans *= num;
        }
        for(int i = 0; i < nums.length; i++) {
            //处理为0的情况
            if (nums[i] == 0) {
                int temp = 1;
                //跳过 重新相乘
                for(int j = 0; j < nums.length; j++) {
                    if(i != j) {
                        temp *= nums[j];
                    }
                }
                answer[i] = temp;
            } else {
                answer[i] = ans / nums[i];
            }
            
        }
        return answer;
    }
}
