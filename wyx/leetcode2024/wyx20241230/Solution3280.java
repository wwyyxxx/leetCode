/*
 * @Author: Tungbo
 * @Date: 2025-01-01 16:13:30
 * @LastEditTime: 2025-01-01 16:17:13
 * @LastEditors: Tungbo
 * @Description: leecode: 3280. 将日期转换为二进制表示
 */
package wyx.leetcode2024.wyx20241230;

public class Solution3280 {
    public String convertDateToBinary(String date) {
        String[] data = date.split("-");
        for(int i =0; i < data.length; i++) {
            data[i] = Integer.toBinaryString(Integer.parseInt(data[i]));
        }
        return String.join("-",data);
    }
}
