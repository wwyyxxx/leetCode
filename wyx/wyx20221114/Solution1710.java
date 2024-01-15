/*
 * @Author: Tungbo
 * @Date: 2022-11-15 14:33:52
 * @LastEditTime: 2022-11-15 14:45:29
 * @LastEditors: Tungbo
 * @Description: leecode: 1710. 卡车上的最大单元数
 * 
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
 *  numberOfBoxesi 是类型 i 的箱子的数量。
 *  numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上
 * 返回卡车可以装载 单元 的 最大 总数。
 * 
 */
package wyx.wyx20221114;

import java.util.Arrays;

public class Solution1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //降序
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize > boxTypes[i][0]) {
                ans += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                ans += truckSize * boxTypes[i][1];
                break;
            }
        }
        return ans;
    }

}
