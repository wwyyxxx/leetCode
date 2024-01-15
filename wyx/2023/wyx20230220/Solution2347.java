/*
 * @Author: Tungbo
 * @Date: 2023-02-20 10:19:13
 * @LastEditTime: 2023-02-20 10:20:37
 * @LastEditors: Tungbo
 * @Description: leecode: 2347. 最好的扑克手牌
 */
package wyx.wyx20230220;

public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        if(suits[0]==suits[1] && suits[0]==suits[2] && suits[0]==suits[3]
          &&suits[0]==suits[4]) return "Flush";
        String ans = "High Card";
        int[] dic = new int[14];
        for(int i = 0; i < 5; i++) {
            dic[ranks[i]]++;
            if(dic[ranks[i]] >= 3) {
                ans = "Three of a Kind";
                break;
            }
            if(dic[ranks[i]] >= 2) ans = "Pair";
        }
        return ans;
    }
}
