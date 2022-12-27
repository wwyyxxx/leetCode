package wyx.wyx20221226;
/*
 * @Author: Tungbo
 * @Date: 2022-12-27 15:49:14
 * @LastEditTime: 2022-12-27 17:05:26
 * @LastEditors: Tungbo
 * @Description: leecode: 1759. 统计同构子字符串的数目
 * 
 */
public class Solution1759 {
    public int countHomogenous(String s) {
        int n = s.length(), k = 1;
        long res = 1;
        char[] ch = s.toCharArray();
        for (int i = 1; i < n; i++) {
            if (ch[i] == ch[i - 1]) k++;
            else k = 1;
            res += k;
        }
        return (int) (res % 1000000007);
    }
}
