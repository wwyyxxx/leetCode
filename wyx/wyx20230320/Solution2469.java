/*
 * @Author: Tungbo
 * @Date: 2023-03-20 11:50:25
 * @LastEditTime: 2023-03-21 11:50:28
 * @LastEditors: Tungbo
 * @Description: leecode: 2469. 温度转换
 */
package wyx.wyx20230320;

public class Solution2469 {
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;
    }
}
