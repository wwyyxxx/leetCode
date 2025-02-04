package practice.leetcode.src.wyx.leetcode2023.wyx20230220;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2023-02-23 15:10:07
 * @LastEditTime: 2023-02-23 15:17:17
 * @LastEditors: Tungbo
 * @Description: leecode: 1238. 循环码排列
 */
public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        int[] dic = new int[1<<n];
        int j = 0;
        for (int i = 0; i < 1<<n; i++) {
            dic[i] = i ^ (i>>1);
            if(dic[i] == start) j = i;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = j; i < j + (1 << n); i++) {
            result.add(dic[i % (1 << n)]);
        }
        return result;
    }
}