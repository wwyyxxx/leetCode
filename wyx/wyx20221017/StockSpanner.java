/*
 * @Author: Tungbo
 * @Date: 2022-10-21 15:43:12
 * @LastEditTime: 2022-10-21 16:05:16
 * @LastEditors: Tungbo
 * @Description: leecode: 901. 股票价格跨度
 * 
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]
 * 
 */
package wyx.wyx20221017;

import java.util.LinkedList;

public class StockSpanner {

    LinkedList<int[]> queue;
    int idx;

    public StockSpanner() {
        queue = new LinkedList<int[]>();
        idx = -1;
        queue.push(new int[]{idx, Integer.MAX_VALUE});
    }
    
    public int next(int price) {
        idx++;
        while(price >= queue.peek()[1]) {
            queue.pop();
        }
        int ret = idx - queue.peek()[0];
        queue.push(new int[]{idx, price});
        return ret;
    }
}
