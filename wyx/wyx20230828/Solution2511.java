package wyx.wyx20230828;

/*
 * @Author: Tungbo
 * @Date: 2023-09-02 23:58:59
 * @LastEditTime: 2023-09-02 23:59:03
 * @LastEditors: Tungbo
 * @Description: leecode: 2511. 最多可以摧毁的敌人城堡数目
 */
public class Solution2511 {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0, pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
