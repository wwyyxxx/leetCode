package wyx;

import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;
import wyx.wyx20220711.WordFilter;
import wyx.wyx20220808.Solution1417;
import wyx.wyx20220822.Solution658;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-08-25 15:37:04
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[] { "hello", "hallo", "leetcode", "judge" });

        WordFilter wf = new WordFilter(new String[] { "apple" });

        // System.out.println(m.search("juage"));
        System.out.println(new Solution658().findClosestElements(new int[] { 1,3,3,4,5,7,7,8,8,8 }, 6, 6));
    }
}
