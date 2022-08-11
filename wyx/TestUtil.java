package wyx;


import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;
import wyx.wyx20220711.WordFilter;
import wyx.wyx20220808.Solution1417;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-08-11 15:17:11
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[]{"hello","hallo","leetcode","judge"});

        WordFilter wf = new WordFilter(new String[]{"apple"});
        
        // System.out.println(m.search("juage"));
        char[] test = "a0b1c2".toCharArray();
        Arrays.sort(test);
        System.out.println(new Solution1417().reformat("a0b1c2"));
    }
}
