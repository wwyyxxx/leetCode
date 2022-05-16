package java;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Author: Tungbo
 * @Date: 2022-04-22 16:46:31
 * @LastEditTime: 2022-04-22 17:15:09
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class LRUCache1 {

    int maxSize;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache1(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(11, 0.75f,true);
        maxSize = capacity;
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
        if (cache.size()>maxSize) {
            Map.Entry<Integer, Integer> entry = cache.entrySet().iterator().next();
            cache.remove(entry.getKey());
        }
        
    }


}