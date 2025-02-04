package practice.leetcode.src.wyx.leetcode2024.wyx20250106;
/*
 * @Author: Tungbo
 * @Date: 2025-01-07 16:13:30
 * @LastEditTime: 2025-01-07 16:17:13
 * @LastEditors: Tungbo
 * @Description: leecode: 3019. 按键变更的次数
 */
public class Solution3019 {

    public int countKeyChanges(String s) {
        String str = s.toLowerCase();
        int ans = 0;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i-1)) ans++;
        }
        return ans;
    }
}