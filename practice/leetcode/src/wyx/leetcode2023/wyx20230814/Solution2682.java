/*
 * @Author: Tungbo
 * @Date: 2023-08-16 17:27:59
 * @LastEditTime: 2023-08-16 17:28:01
 * @LastEditors: Tungbo
 * @Description: leecode: 2682. 找出转圈游戏输家
 */
package practice.leetcode.src.wyx.leetcode2023.wyx20230814;

import java.util.ArrayList;
import java.util.List;

public class Solution2682 {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visted = new boolean[n];
        for(int i = k, j = 0; !visted[j]; i += k) {
            visted[j] = true;
            j = (j + i) % n;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < visted.length; i++) {
            if(!visted[i]) list.add(i+1);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
