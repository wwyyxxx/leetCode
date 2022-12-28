/*
 * @Author: Tungbo
 * @Date: 2022-12-28 18:17:25
 * @LastEditTime: 2022-12-28 18:32:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1750. 删除字符串两端相同字符后的最短长度
 */
package wyx.wyx20221226;

public class Solution1750 {
    public int minimumLength(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) break;
            char t = s.charAt(left++);
            while(left <= right && s.charAt(left) == t) left++;
            while(left <= right && s.charAt(right) == t) right--;
        }
        return right - left+1;
    }
}
