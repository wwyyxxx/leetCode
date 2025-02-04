/*
 * @Author: Tungbo
 * @Date: 2022-06-26 15:04:34
 * @LastEditTime: 2022-06-26 15:15:52
 * @LastEditors: Tungbo
 * @Description: leecode: 710. 黑名单中的随机数
 * 
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。
 * 设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。
 * 任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220620;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution710 {
    
    private final Map<Integer, Integer> blackToWhite = new HashMap<>();
    private final Random random = new Random();
    private int whiteLength = 0;

    public Solution710(int n, int[] blacklist) {
        //黑名单长度
        int balckLength = blacklist.length;
        //白名单长度
        whiteLength = n - balckLength;
        //记录后半部分中的黑名单 表示在后半部分这个位置是黑名单，不能做映射
        int[] black = new int[balckLength];
        for(int i : blacklist) {
            if(i >= whiteLength) {
                black[i - whiteLength] = 1;
            }
        }
        int pos = 0;
        for (int i : blacklist) {
             //前半部分中的黑名单，要对其做映射
            if(i < whiteLength) {
                //找到后半部分的白名单位置
                while(black[pos] == 1) {
                    pos++;
                }
                //映射到黑名单中的白名单位置
                blackToWhite.put(i, pos + whiteLength);
                pos++;
            }
        }
    }
    
    public int pick() {
        //随机数
        int i = random.nextInt(whiteLength);
        return blackToWhite.getOrDefault(i, i);
    }

}
