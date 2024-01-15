/*
 * @Author: Tungbo
 * @Date: 2022-12-11 19:09:16
 * @LastEditTime: 2022-12-12 15:07:46
 * @LastEditors: Tungbo
 * @Description: leecode: 970.强整数
 */
package wyx.wyx20221205;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<Integer>();
        for(int i = 1; i < bound; i *= x) {
            for(int j = 1; i+j <= bound; j *= y) {
                result.add(i+j);
                if(y==1) break;
            }
            if(x==1)break;
        }
        return new ArrayList<>(result);
    }
}
