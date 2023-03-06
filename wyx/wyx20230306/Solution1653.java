/*
 * @Author: Tungbo
 * @Date: 2023-03-06 11:39:57
 * @LastEditTime: 2023-03-06 11:40:01
 * @LastEditors: Tungbo
 * @Description: leecode: 1653. 使字符串平衡的最少删除次数
 */
package wyx.wyx20230306;

public class Solution1653 {
    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int cntB = 0;
        int f= 0;
        for(int i = 0; i< n;i++) {
            if(cs[i] == 'b') cntB++;
            // a 保留它 删除前面所有B
            //   删除它 dp[i-1] + 1
            // b 保留它 删除前面所有B
            //   删除它 dp[i-1] + 1
            else f = Math.min(f + 1, cntB);
        }
        return f;
    }
    
    public int minimumDeletions1(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int delA = 0;
        for(int i = 0; i< n;i++) {
            delA += cs[i] == 'a' ? 1 : 0; // 'b' -cs[i]
        }
        System.out.println(delA);
        int ans = delA;
        for(int i = 0; i< n;i++) {
            delA += cs[i] == 'a' ? -1 : 1;
            ans = Math.min(ans,delA);
        }
        return ans;
    }
}
