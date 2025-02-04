/*
 * @Author: Tungbo
 * @Date: 2023-03-13 10:19:26
 * @LastEditTime: 2023-03-13 10:53:23
 * @LastEditors: Tungbo
 * @Description: leecode: 2383. 赢得比赛需要的最少训练时长
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230313;

public class Solution2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sumEne = 0;
        int ans = 0;
        for(int ene:energy) sumEne += ene;
        ans = Math.max(sumEne - initialEnergy + 1, 0);

        for(int exp : experience) {
            if(initialExperience <= exp) {
                ans += exp - initialExperience + 1;
                initialExperience = exp + 1;
            }
            initialExperience = initialExperience + exp;
        }
        return ans;
    }
}
