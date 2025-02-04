/*
 * @Author: Tungbo
 * @Date: 2023-02-18 18:37:56
 * @LastEditTime: 2023-02-18 18:42:31
 * @LastEditors: Tungbo
 * @Description: leecode: 1237. 找出给定方程的正整数解
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1;
        List<List<Integer>> ans = new ArrayList<>();
        while(x <= z && customfunction.f(x,1) <= z) {
            int y = 1;
            while(y <= z && customfunction.f(x,y) <= z) { 
                if(customfunction.f(x,y) == z) {
                    ans.add(Arrays.asList(x,y));
                }
                y++;
            }
            x++;
        }
        return ans;
    }
}
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 */
interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y);
};