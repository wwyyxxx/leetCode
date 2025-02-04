package practice.leetcode.src.wyx.leetcode2022.wyx20221128;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @Author: Tungbo
 * @Date: 2022-11-30 10:25:22
 * @LastEditTime: 2022-11-30 11:21:38
 * @LastEditors: Tungbo
 * @Description: leecode: 895. 最大频率栈
 * 
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * 实现 FreqStack 类:
 *  
 * 
 */
public class FreqStack {

    HashMap<Integer,Integer> freqMap;
    List<ArrayDeque<Integer>> stack;
    //FreqStack() 构造一个空的堆栈。
    public FreqStack() {
        freqMap = new HashMap<Integer,Integer>();
        stack = new ArrayList<ArrayDeque<Integer>>();
    }
    
    //void push(int val) 将一个整数 val 压入栈顶。
    public void push(int val) {
        int cnt = freqMap.getOrDefault(val, 0);
        if(cnt == stack.size()) {
            stack.add(new ArrayDeque<>());
        }
        stack.get(cnt).push(val);
        freqMap.put(val, cnt + 1);
    }
    
    //int pop() 删除并返回堆栈中出现频率最高的元素。
    //如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素
    public int pop() {
        int n = stack.size() - 1;
        int val = stack.get(n).pop();
        if(stack.get(n).isEmpty()) {
            stack.remove(n);
        }
        freqMap.put(val, freqMap.get(val) - 1);
        return val;
    }

}
