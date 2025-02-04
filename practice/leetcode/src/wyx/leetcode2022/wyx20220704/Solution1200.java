/*
 * @Author: Tungbo
 * @Date: 2022-07-04 19:00:59
 * @LastEditTime: 2022-07-04 19:26:36
 * @LastEditors: Tungbo
 * @Description: leecode: 1200. 最小绝对差
 * 
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution1200 {


    
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        TreeMap<Integer, List<List<Integer>>> tree = new TreeMap<Integer, List<List<Integer>>>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int k = Math.abs(arr[i] - arr[i + 1]);
            List<List<Integer>> tempList = tree.getOrDefault(k,new ArrayList<List<Integer>>());

            List<Integer> children = new ArrayList<Integer>();
            children.add(arr[i]);
            children.add(arr[i + 1]);
            
            tempList.add(children);
            tree.put(k,tempList);
        }
        for(List<List<Integer>> list : tree.values()) {
            return list;
        }
        return new ArrayList<List<Integer>>();
    }
    
}
