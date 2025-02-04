package practice.leetcode.src.wyx.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        t -= 3000;
        while(queue.peek() < t){
            queue.poll();
        }
        return queue.size();
    }
}
