/*
 * @Author: Tungbo
 * @Date: 2022-08-13 17:07:52
 * @LastEditTime: 2022-08-13 17:14:07
 * @LastEditors: Tungbo
 * @Description: leecode: 768. 最多能完成排序的块 II
 * 
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同
 * 我们最多能将数组分成多少块？
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220808;

import java.util.LinkedList;

public class Solution768 {
    
    public int maxChunksToSorted(int[] arr) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int num : arr) {
            if(!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                while(!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                stack.addLast(head);
            }
            else stack.addLast(num);
        }
        return stack.size();
    }

}
