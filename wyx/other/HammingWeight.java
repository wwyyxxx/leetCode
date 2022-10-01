package wyx.other;

/*
 * @Author: Tungbo
 * @Date: 2021-07-02 16:48:14
 * @LastEditTime: 2021-07-05 11:29:14
 * @LastEditors: Tungbo
 * @Description: leecode: 二进制中1的个数
 */
public class HammingWeight{
    public static void main(String[] args) {}
    public int hammingWeight(int n) {
        String temp = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0;i<temp.length();i++) {
            if (temp.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}