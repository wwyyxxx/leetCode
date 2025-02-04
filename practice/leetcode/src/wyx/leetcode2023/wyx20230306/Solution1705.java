/*
 * @Author: Tungbo
 * @Date: 2023-03-11 16:53:39
 * @LastEditTime: 2023-03-11 16:53:43
 * @LastEditors: Tungbo
 * @Description: leecode: 面试题 17.05.  字母与数字
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230306;

import java.util.HashMap;
import java.util.Map;

public class Solution1705 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] preSum = new int[n+1];
        for(int i = 0; i < n; i++) {
            int temp = Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            preSum[i+1] = preSum[i] + temp;
        }
        int end = 0, start = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i <= n; i++) {
            int t = map.getOrDefault(preSum[i],-1);
            if(t<0) map.put(preSum[i],i);
            else if(i - t > end - start) {
                end = i;
                start = t;
            }
        }
        String[] ans = new String[end - start];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = array[i+start];
        }
        return ans;
    }

    public String[] findLongestSubarray1(String[] array) {
        int n = array.length;
        int ansIdx = 0, len = 0;;
        for(int left = 0; left < n; left++) {
            int cntNum = 0;
            for(int rigth = left; rigth < n; rigth++) {
                String cur = array[rigth];
                if(Character.isDigit(cur.charAt(0))) cntNum++;
                if((rigth - left + 1) % 2 != 0 || (rigth - left + 1) / 2 != cntNum) continue;
                
                if(rigth - left + 1 > len) {
                    ansIdx = left;
                    len = rigth - left + 1;
                }
            }
        }
        String[] ans = new String[len];
        for(int i = 0; i < len; i++) {
            ans[i] = array[i+ansIdx];
        }
        return ans;
    }
}
