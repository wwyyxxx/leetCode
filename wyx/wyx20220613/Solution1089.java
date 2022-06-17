package wyx.wyx20220613;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-06-08 12:34:20
 * @LastEditTime: 2022-06-17 15:24:46
 * @LastEditors: Tungbo
 * @Description: leecode: 1089. 复写零
 * 
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位
 * 要求：请对输入的数组 就地进行上述修改，不要从函数返回任何东西。
 * 
 */

public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        String[] arrs = new String[arr.length];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = arr[i]+"";
        }
        String s = String.join("", arrs).replace("0","00");
        for(int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
    }
}