/*
 * @Author: Tungbo
 * @Date: 2023-01-29 18:48:57
 * @LastEditTime: 2023-01-29 19:14:43
 * @LastEditors: Tungbo
 * @Description: leecode: 2315. 统计星号
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230123;

public class Solution2315 {
    public int countAsterisks(String s) {
        int ans = 0 ,cnt = 0;
        for (char c : s.toCharArray()) {
            if(cnt=='|') cnt++;
            if(cnt%2==0 && c =='*') ans++; 
        }
        
        return ans;
    }
}
