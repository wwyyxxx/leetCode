package wyx.wyx20230918;

/*
 * @Author: Tungbo
 * @Date: 2023-09-22 17:25:58
 * @LastEditTime: 2023-09-22 18:10:22
 * @LastEditors: Tungbo
 * @Description: leecode: 2591. 将钱分给最多的儿童
 */
public class Solution2591{
    public int distMoney(int money, int children) {
        if(money < children) return -1;

        money -= children;
        int cnt = Math.min(money / 7, children);
        money -= cnt * 7;
        children -= cnt;
        if ((children == 0 && money > 0) || (children == 1 && money == 3)) {
            cnt--;
        }
        return cnt;
    }
}
