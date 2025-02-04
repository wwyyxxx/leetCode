package practice.leetcode.src.wyx.leetcode2022.wyx20220926;

/*
 * @Author: Tungbo
 * @Date: 2021-10-02 15:09:15
 * @LastEditTime: 2021-10-02 14:47:18
 * @LastEditors: Tungbo
 * @Description: leecode: 777. 在LR字符串中交换相邻字符
 * 
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 * 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，
 * 当且仅当存在一系列移动操作使得start可以转换成end时， 返回True
 * 
 */
public class Solution777 {

    public boolean canTransform(String start, String end) {
        // String[] starts = start.split("X");
        // String[] ends = end.split("X");
        // return Arrays.equals(starts, ends);
        // String s = start.replace("X", "");
        // String e = end.replace("X", "");
        // return s.equals(e);
        int n = start.length(), i = 0, j =0;
        while(i<n || j < n) {
            while(i < n && start.charAt(i) == 'X') i++;
            while(j < n && end.charAt(j) == 'X') j++;
            if(i == n || j == n) return i == j;
            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'L' && i < j) return false;
            if(start.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return i == j;
    }

}
