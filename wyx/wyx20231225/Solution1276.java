/*
 * @Author: Tungbo
 * @Date: 2023-12-25 21:41:08
 * @LastEditTime: 2023-12-25 21:54:11
 * @LastEditors: Tungbo
 * @Description: leecode: 1276. 不浪费原料的汉堡制作方案
 */
package wyx.wyx20231225;

import java.util.ArrayList;
import java.util.List;

public class Solution1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices % 2 != 0 || cheeseSlices * 4 < tomatoSlices || cheeseSlices * 2 > tomatoSlices) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        result.add(tomatoSlices / 2 - cheeseSlices);
        result.add(cheeseSlices / 2 - tomatoSlices / 2);
        return result;
    }
}
