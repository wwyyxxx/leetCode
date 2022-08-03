/*
 * @Author: Tungbo
 * @Date: 2022-08-03 16:46:12
 * @LastEditTime: 2022-08-03 16:59:34
 * @LastEditors: Tungbo
 * @Description: leecode: 899. 有序队列
 * 
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * 
 */
package wyx.wyx20220801;

import java.util.Arrays;

public class Solution899 {
    
    public String orderlyQueue(String s, int k) {
        char[] c = s.toCharArray();
        if(k == 1) { //不能完全混排，只能单个检查
            StringBuilder sb = new StringBuilder(s);
            String small = s;
            int n = s.length();
            while(n > 0){
                n--;
                char temp = sb.charAt(0);
                sb.deleteCharAt(0).append(temp);
                if(small.compareTo(sb.toString()) > 0) {
                    small = sb.toString();
                }
            }
            return small;
        } else {//可以完全排列，直接字典序排序
            Arrays.sort(c);
            return new String(c);
        }
    }

}
