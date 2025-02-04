package practice.leetcode.src.wyx.leetcode2023.wyx20230116;

/*
 * @Author: Tungbo
 * @Date: 2023-01-19 22:41:36
 * @LastEditTime: 2023-01-19 22:44:15
 * @LastEditors: Tungbo
 * @Description: leecode: 2299. 强密码检验器 II
 */
public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        char[] ch = password.toCharArray();
        boolean hasDown = false, hasUp = false, hasNum = false, hasStr = false;
        String TAR = "!@#$%^&*()-+";
        for(int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(i!=0 && c == ch[i-1]) return false;
            if(c >= 'a' && c <= 'z') hasDown = true;
            if(c >= 'A' && c <= 'Z') hasUp = true;
            if(c >= '0' && c <= '9') hasNum = true;
            // String str = new String(c);
            if(TAR.indexOf(String.valueOf(c))!=-1) hasStr = true;
        }
        return hasDown && hasUp && hasNum && hasStr;
    }
}
