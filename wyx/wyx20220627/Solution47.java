/*
 * @Author: Tungbo
 * @Date: 2022-06-30 15:55:20
 * @LastEditTime: 2022-06-30 16:17:16
 * @LastEditors: Tungbo
 * @Description: leecode: 473. 火柴拼正方形
 * 
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 
 */
package wyx.wyx20220627;

import java.util.Arrays;

public class Solution47 {

    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int sum = 0;
        for (int i = 0; i < matchsticks.length; i++) {
            sum+=matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        int side = sum / 4;
        return dfs(0,matchsticks,new int[4],side);
    }

    private boolean dfs(int i, int[] matchsticks, int[] js, int side) {
        if(i == matchsticks.length) return true;
        for (int j = 0; j < js.length; j++) {
            js[j] += matchsticks[i];
            if(js[j] <= side && dfs(i+1, matchsticks, js, side)) return true;
            js[j] -= matchsticks[i];
        }
        return false;
    }

}