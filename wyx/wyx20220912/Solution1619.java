/*
 * @Author: Tungbo
 * @Date: 2022-09-14 15:42:37
 * @LastEditTime: 2022-09-14 16:04:30
 * @LastEditors: Tungbo
 * @Description: leecode: 1619. 删除某些元素后的数组均值
 * 
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果
 * 
 */
package wyx.wyx20220912;

import java.util.Arrays;

public class Solution1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double start = arr.length * 0.05, end = arr.length * 0.95;
        int[] temp = Arrays.copyOfRange(arr, (int) start, (int) end);
        return Arrays.stream(temp).average().getAsDouble();
    }

}
