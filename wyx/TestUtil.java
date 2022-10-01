package wyx;

import java.util.*;

import wyx.other.Solution;
import wyx.wyx20220711.MagicDictionary;
import wyx.wyx20220711.WordFilter;
import wyx.wyx20220829.Solution646;
import wyx.wyx20220905.Solution1592;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-09-07 14:47:18
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {

        // MagicDictionary m = new MagicDictionary();
        // m.buildDict(new String[] { "hello", "hallo", "leetcode", "judge" });

        // WordFilter wf = new WordFilter(new String[] { "apple" });
        // int[][] temp = new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        // Arrays.stream(temp).distinct();
        // List<int[]> list = Arrays.asList(temp);
        // Collections.shuffle(list);
        // System.out.println(list);
        System.out.println(new Solution1592().reorderSpaces("  this   is  a sentence "));
    }

    public int trap(int[] height) {
        int ans = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i -1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i +1], height[i +1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(min > height[i]) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }
}
