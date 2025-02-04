/*
 * @Author: Tungbo
 * @Date: 2024-04-26 15:32:33
 * @LastEditTime: 2024-04-26 17:12:33
 * @LastEditors: Tungbo
 * @Description: leecode: 1146. 快照数组
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240422;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {

    int curSnapId;
    Map<Integer,List<int[]>> history;

    public SnapshotArray(int length) {
        curSnapId = 0;
        history = new HashMap<>();
    }
    
    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{curSnapId, val});
    }
    
    public int snap() {
        return curSnapId++;
    }
    
    public int get(int index, int snap_id) {
        if(!history.containsKey(index)) return 0;
        List<int[]> h = history.get(index);
        int j = search(h, snap_id);
        return j < 0 ? 0 : h.get(j)[1];
    }

    private int search(List<int[]> h, int snap_id) {
        int left = -1;
        int right = h.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (h.get(mid)[0] <= snap_id) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
