/*
 * @Author: Tungbo
 * @Date: 2023-10-20 16:16:57
 * @LastEditTime: 2023-10-20 16:16:59
 * @LastEditors: Tungbo
 * @Description: leecode: 2525. 根据规则将箱子分类
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20231016;

public class Solution2525 {
    int v4 = 10000;
    int v9 = v4 * 100000;

    public String categorizeBox(int length, int width, int height, int mass) {
        
        String res = "";
        if(isBulky(length,width,height)) {
                res = "Bulky";
        }

        if(isHeavy(mass)) {
            res = "Heavy";
        }

        if(isBoth(length,width,height,mass)) res = "Both";

        if(isNeither(length,width,height,mass)) res = "Neither";

        return res;
    }

    private Boolean isBulky(int length, int width, int height){
        long temp = (long)length * width * height;
        return length >= v4 || width >= v4 || height >= v4
            || temp >= v9;
    }

    private Boolean isHeavy(int mass) {
        return mass >= 100;
    }

    private Boolean isNeither(int length, int width, int height, int mass) {
        return !isBulky(length,width,height) && !isHeavy(mass);
    }

    private Boolean isBoth(int length, int width, int height, int mass) {
        return isBulky(length,width,height) && isHeavy(mass);
    }
}
