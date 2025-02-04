/*
 * @Author: Tungbo
 * @Date: 2022-08-15 21:17:27
 * @LastEditTime: 2022-08-15 21:33:57
 * @LastEditors: Tungbo
 * @Description: leecode: 641. 设计循环双端队列
 * 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

import java.util.ArrayList;
import java.util.List;

public class MyCircularDeque {
    
    List<Integer> list;
    int k;

    //构造函数,双端队列最大为 k 。
    public MyCircularDeque(int k) {
        list = new ArrayList<>(k);
        this.k = k;
    }
    
    //boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
    public boolean insertFront(int value) {
        if(list.size() >= k) return false;
        list.add(0, value);
        return true;
    }
    
    //将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false
    public boolean insertLast(int value) {
        if(list.size() >= k) return false;
        list.add(value);
        return true;
    }
    
    //从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
    public boolean deleteFront() {
        if(list.isEmpty()) return false;
        list.remove(0);
        return true;
    }
    
    //从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
    public boolean deleteLast() {
        if(list.isEmpty()) return false;
        list.remove(list.size()-1);
        return true;
    }
    
    //从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
    public int getFront() {
        if(list.isEmpty()) return -1;
        return list.get(0);
    }
    
    //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
    public int getRear() {
        if(list.isEmpty()) return -1;
        return list.get(list.size()-1);
    }
    
    //若双端队列为空，则返回 true ，否则返回 false  。
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    //若双端队列满了，则返回 true ，否则返回 false 。
    public boolean isFull() {
        return list.size() == k;
    }

}
