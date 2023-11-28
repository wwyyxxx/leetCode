/*
 * @Author: Tungbo
 * @Date: 2023-11-28 14:08:24
 * @LastEditTime: 2023-11-28 15:11:59
 * @LastEditors: Tungbo
 * @Description: leecode: 1670. 设计前中后队列
 */
package wyx.wyx20231127;

import java.util.LinkedList;

public class FrontMiddleBackQueue {

    LinkedList<Integer> frList;
    LinkedList<Integer> laList;
    
    public FrontMiddleBackQueue() {
        frList = new LinkedList<>();
        laList = new LinkedList<>();
    }
    
    private void blance(){
        if(frList.size() > laList.size()) {
            laList.addFirst(frList.removeLast());
        } else if (laList.size() > frList.size() + 1) {
            frList.addLast(laList.removeFirst());
        }
    }
    
    public void pushFront(int val) {
        frList.addFirst(val);
        blance();
    }
    
    public void pushMiddle(int val) {
        // 
        if(frList.size() < laList.size()) {
            frList.addLast(val);
        } else {
            laList.addFirst(val);
        }
    }
    
    public void pushBack(int val) {
        laList.addLast(val);
        blance();
    }
    
    public int popFront() {
        if(laList.isEmpty()) return -1; 
        int val = frList.isEmpty() ? laList.removeFirst() : frList.removeFirst();
        blance();
        return val;
    }
    
    public int popMiddle() {
        if(laList.isEmpty()) return -1;
        return frList.size() == laList.size() ? frList.removeLast() : laList.removeFirst();
    }
    
    public int popBack() {
        if(laList.isEmpty()) return -1; 
        int val = laList.isEmpty() ? frList.removeLast() : laList.removeLast();
        blance();
        return val;
    }
}
