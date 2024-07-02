/*
 * @Author: Tungbo
 * @Date: 2024-07-01 14:39:10
 * @LastEditTime: 2024-07-01 16:29:30
 * @LastEditors: Tungbo
 * @Description: leecode: 146. LRU 缓存
 */
package wyx.leetcode2024.wyx20240701;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<Integer,Integer>{
    
    HashMap<Integer,Integer> dic;
    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
    
}
