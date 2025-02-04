/*
 * @Author: Tungbo
 * @Date: 2024-07-01 16:29:18
 * @LastEditTime: 2024-07-02 17:11:50
 * @LastEditors: Tungbo
 * @Description: leecode: 146. LRU 缓存 - 双链表
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240701;

import java.util.HashMap;
import java.util.concurrent.DelayQueue;

import practice.leetcode.src.wyx.bean.DLinkedNode;

public class LRUCache1 {
    
    HashMap<Integer,DLinkedNode> cache;
    int size, capacity;
    DLinkedNode head, tail;


    public LRUCache1(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            addToHead(node);
            if (++size > capacity) {
                int removeKey = removeTail();
                cache.remove(removeKey);
            }
            cache.put(key, node);
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int removeTail(){
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node.key;
    }
}