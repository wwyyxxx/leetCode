package wyx;

import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;
import wyx.wyx20220711.WordFilter;
import wyx.wyx20220829.Solution646;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-09-04 13:32:21
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[] { "hello", "hallo", "leetcode", "judge" });

        WordFilter wf = new WordFilter(new String[] { "apple" });
        int[][] temp = new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        Arrays.stream(temp).distinct();
        List<int[]> list = Arrays.asList(temp);
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(new Solution646().findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
    }
}
