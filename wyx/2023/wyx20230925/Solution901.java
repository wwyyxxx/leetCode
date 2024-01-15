/*
 * @Author: Tungbo
 * @Date: 2023-10-07 16:16:52
 * @LastEditTime: 2023-10-07 16:24:54
 * @LastEditors: Tungbo
 * @Description: leecode: 901. 股票价格跨度
 */
package wyx.wyx20230925;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution901 {
    Deque<int[]> stack;
    int idx;

    public Solution901() {
        stack = new ArrayDeque<>();
        stack.add(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        while(price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}
