/*
 * @Author: Tungbo
 * @Date: 2022-08-15 21:52:12
 * @LastEditTime: 2022-08-15 22:19:38
 * @LastEditors: Tungbo
 * @Description: leecode: 641. 设计循环双端队列
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

public class MyCircularDeque1 {
    
    int[] list;
    int capacity;
    int head,foot;

    //构造函数,双端队列最大为 k 。
    public MyCircularDeque1(int k) {
        this.capacity = k+1;
        list = new int[capacity];
        head = foot = 0;
    }
    
    //boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
    public boolean insertFront(int value) {
        if(isFull()) return false;
        head = (head - 1 + capacity) % capacity;
        list[head] = value;
        return true;
    }
    
    //将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false
    public boolean insertLast(int value) {
        if(isFull()) return false;
        list[foot] = value;
        foot = (foot + 1) % capacity;
        return true;
    }
    
    //从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
    public boolean deleteFront() {
        if(isEmpty()) return false;
        head = (head + 1) % capacity;
        return true;
    }
    
    //从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
    public boolean deleteLast() {
        if(isEmpty()) return false;
        foot = (foot - 1 + capacity) % capacity;
        return true;
    }
    
    //从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
    public int getFront() {
        if(isEmpty()) return -1;
        return list[head];
    }
    
    //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
    public int getRear() {
        if(isEmpty()) return -1;
        return list[(foot - 1 + capacity) % capacity];
    }
    
    //若双端队列为空，则返回 true ，否则返回 false  。
    public boolean isEmpty() {
        return foot == head;
    }
    
    //若双端队列满了，则返回 true ，否则返回 false 。
    public boolean isFull() {
        return (foot + 1) % capacity == head;
    }

}
