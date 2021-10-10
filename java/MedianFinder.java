import java.util.*;

/*
 * @Author: Tungbo
 * @Date: 2021-09-18 11:24:49
 * @LastEditTime: 2021-09-18 16:44:49
 * @LastEditors: Tungbo
 * @Description: leecode: 数据流中的中位数
 */
public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}
