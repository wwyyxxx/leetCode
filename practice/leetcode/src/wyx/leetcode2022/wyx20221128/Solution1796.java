/*
 * @Author: Tungbo
 * @Date: 2022-12-03 18:55:12
 * @LastEditTime: 2022-12-03 19:17:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1796. 字符串中第二大的数字
 * 
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * 混合字符串 由小写英文字母和数字组成。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221128;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution1796 {
    public int secondHighest(String s) {
        char[] ch = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        for (char c : ch) {
            if (Character.isDigit(c)) {
                set.add(c - '0');
            }
        }
        if (set.size() < 2)
            return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (Integer i : set) {
            queue.add(i);
        }
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            if (i == n - 2)
                return queue.poll();
            queue.poll();
        }
        return -1;
    }

    public int secondHighest1(String s) {
        int fir = -1, sec = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if(Character.isDigit(c)) {
                int num = c - '0';
                if(fir < num){
                    sec = fir;
                    fir = num;
                } else if(sec < num && fir != num) {
                    sec = num;
                }
            }
        }
        return sec;
    }
}
