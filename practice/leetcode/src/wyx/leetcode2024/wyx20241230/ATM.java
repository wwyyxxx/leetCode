/*
 * @Author: Tungbo
 * @Date: 2025-01-05 18:48:15
 * @LastEditTime: 2025-01-05 19:10:05
 * @LastEditors: Tungbo
 * @Description: leecode: 2241. 设计一个 ATM 机器
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241230;

public class ATM {

    private static final int[] DENOMINATIONS = {20, 50, 100, 200, 500};
    private static final int KINDS = DENOMINATIONS.length;

    private final int[] banknotes = new int[KINDS];

    public ATM() {
        
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            banknotes[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[KINDS];

        for(int i = KINDS - 1; i>=0; i--) {
            ans[i] = Math.min(amount / DENOMINATIONS[i], banknotes[i]);
            amount -= ans[i] * DENOMINATIONS[i];
        }

        if (amount > 0) {
            return new int[]{-1};
        }

        for (int i = 0; i < KINDS; i++) {
            banknotes[i] -= ans[i];
        }

        return ans;
    }
}