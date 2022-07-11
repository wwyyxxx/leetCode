package wyx;


import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-07-11 11:27:26
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        MagicDictionary m = new MagicDictionary();
        m.buildDict(new String[]{"hello","hallo","leetcode","judge"});
        System.out.println(m.search("juage"));
    }
}
