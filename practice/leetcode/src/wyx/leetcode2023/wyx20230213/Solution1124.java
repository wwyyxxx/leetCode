package practice.leetcode.src.wyx.leetcode2023.wyx20230213;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Author: Tungbo
 * @Date: 2023-02-14 11:40:16
 * @LastEditTime: 2023-02-14 11:45:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1124. 表现良好的最长时间段
 */
public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int l = 0, tCnt = 0, rCnt = 0, ans = 0;
        for(int i = 0; i < n; i++) {
            if(hours[i]>8) tCnt++;
            else rCnt++;
            if(tCnt > rCnt) {
                ans = Math.max(ans,tCnt+rCnt);
            } else {
                int t = tCnt, r = rCnt;
                for(int j = 1; j<=i;j++) {
                    if(hours[j-1] > 8) t--;
                    else r--;
                    if(t > r) ans = Math.max(ans,t+r);;
                }
            }
        }
        return ans;
    }

    public int longestWPI1(int[] hours) {
        int n = hours.length;
        int ans = 0;
        int[] prefix = new int[n+1];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + (hours[i-1] > 8 ? 1 : -1);
            if(prefix[i] < prefix[stack.peek()]) stack.push(i);
        }
        for (int i = n; i <= 0; i--) {
            while(!stack.isEmpty() && prefix[i] > prefix[stack.peek()]) {
                ans = Math.max(ans, i - stack.pop());
            }
        }
        return ans;
    }
}