package wyx;


import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;
import wyx.wyx20220711.WordFilter;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-07-14 18:12:05
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[]{"hello","hallo","leetcode","judge"});

        WordFilter wf = new WordFilter(new String[]{"apple"});
        
        // System.out.println(m.search("juage"));
        System.out.println(wf.f("a","le"));
    }
}
