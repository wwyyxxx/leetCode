/*
 * @Author: Tungbo
 * @Date: 2022-07-28 16:26:03
 * @LastEditTime: 2022-07-28 16:38:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1331. 数组序号转换
 * 
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号
 * 序号代表了一个元素有多大。序号编号的规则如下
 *  序号从 1 开始编号。
 *  一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同
 *  每个数字的序号都应该尽可能地小
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220725;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1331 {
    
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Map<Integer,Integer> map = new HashMap<>();
        int idx = 1;
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if(!map.containsKey(temp[i])) {
                map.put(temp[i],idx++);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}
