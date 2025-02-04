/*
 * @Author: Tungbo
 * @Date: 2024-04-15 17:41:59
 * @LastEditTime: 2024-04-15 17:54:25
 * @LastEditors: Tungbo
 * @Description: leecode: 706. 设计哈希映射
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240415;

import java.util.Iterator;
import java.util.LinkedList;

import practice.leetcode.src.wyx.bean.Pair;

public class MyHashMap {
    int SIZE = 769;
    LinkedList<Pair<Integer, Integer>>[] list;


    public MyHashMap() {
        list = new LinkedList[SIZE];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<Pair<Integer, Integer>>();
        }
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        Iterator<Pair<Integer, Integer>> temp = list[idx].iterator();
        while (temp.hasNext()) {
            Pair<Integer, Integer> pair = temp.next();
            if(pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        list[idx].offerLast(new Pair<Integer,Integer>(key, value));
    }
    
    private int hash(int key) {
        return key % SIZE;
    }

    public int get(int key) {
        int idx = hash(key);
        Iterator<Pair<Integer, Integer>> temp = list[idx].iterator();
        while (temp.hasNext()) {
            Pair<Integer, Integer> pair = temp.next();
            if(pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        Iterator<Pair<Integer, Integer>> temp = list[idx].iterator();
        while (temp.hasNext()) {
            Pair<Integer, Integer> pair = temp.next();
            if(pair.getKey() == key) {
                list[idx].remove(pair);
                return;
            }
        }
    }
}
