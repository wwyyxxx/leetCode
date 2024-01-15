/*
 * @Author: Tungbo
 * @Date: 2022-08-02 10:52:50
 * @LastEditTime: 2022-08-03 17:02:20
 * @LastEditors: Tungbo
 * @Description: leecode: 622. 设计循环队列
 */
package wyx.wyx20220801;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    
    List<Integer> list;
    int k;

    // 构造器，设置队列长度为 k 。
    public MyCircularQueue(int k) {
        list = new ArrayList<Integer>(k);
        this.k = k;
    }
    
    //向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if(list.size() >= k ) return false;
        list.add(value);
        return true;
    }
    
    //从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if(list.isEmpty()) return false;
        list.remove(0);
        return true;
    }
    
    //从队首获取元素。如果队列为空，返回 -1 。
    public int Front() {
        return list.isEmpty() ? -1 : list.get(0);
    }
    
    //获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        return list.isEmpty() ? -1 : list.get(list.size()-1);
    }
    
    //检查循环队列是否为空。
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    //检查循环队列是否已满。
    public boolean isFull() {
        return list.size() == k;
    }

}
