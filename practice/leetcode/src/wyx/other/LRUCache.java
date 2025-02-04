package practice.leetcode.src.wyx.other;

/*
 * @Author: Tungbo
 * @Date: 2022-04-14 17:18:24
 * @LastEditTime: 2022-04-14 17:31:11
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
import java.util.LinkedHashMap;
import java.util.Map;
//LRU 缓存
public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int maxSize;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity,0.75f,true);
        maxSize = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        map.put(key,value);
        if(map.size() > maxSize) {
            Map.Entry<Integer, Integer> e = map.entrySet().iterator().next();
            map.remove(e.getKey());
        }
    }
}