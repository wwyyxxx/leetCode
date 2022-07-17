/*
 * @Author: Tungbo
 * @Date: 2022-07-17 11:45:48
 * @LastEditTime: 2022-07-17 12:07:02
 * @LastEditors: Tungbo
 * @Description: leecode: 565. 数组嵌套
 * 
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * 
 */
package wyx.wyx20220711;

public class Solution565 {
    
    public int arrayNesting(int[] nums) {
        int ans = 0;
        // 用于记录是否已经遍历过
        boolean[] found = new boolean[nums.length];
        if(nums.length == 0) return ans;
        // 每个数字只有出现一次，所以路径唯一。 
        // 同一路径中。最长路径先于短路径出现
        for (int i = 0; i < found.length; i++) {
            int res = 0;
            while (!found[i]) {
                found[i] = true;
                res++;
                i = nums[i];
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }

}
