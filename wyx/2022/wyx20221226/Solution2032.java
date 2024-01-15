/*
 * @Author: Tungbo
 * @Date: 2022-12-29 22:29:51
 * @LastEditTime: 2022-12-29 22:38:04
 * @LastEditors: Tungbo
 * @Description: leecode: 2032. 至少在两个数组中出现的值
 * 
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。
 * 数组中的元素可以按 任意 顺序排列。
 * 
 */
package wyx.wyx20221226;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> res = new HashSet<Integer>();
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (Integer num: nums1) {
            set1.add(num);
        }
        for (Integer num : nums2) {
            set2.add(num);
            if(set1.contains(num)) res.add(num);
        }
        for (Integer num: nums3) {
            if(set1.contains(num)) res.add(num);
            if(set2.contains(num)) res.add(num);
        }
        return new ArrayList<>(res);
    }
}
