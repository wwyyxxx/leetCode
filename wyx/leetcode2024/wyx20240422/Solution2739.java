package wyx.leetcode2024.wyx20240422;

/*
 * @Author: Tungbo
 * @Date: 2024-04-25 16:35:31
 * @LastEditTime: 2024-04-24 17:29:32
 * @LastEditors: Tungbo
 * @Description: leecode: 2739. 总行驶距离
 */
public class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while(mainTank >= 5) {
            mainTank -= 5;
            ans+=50;
            if(additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
        }
        return ans + mainTank * 10;
    }
}
