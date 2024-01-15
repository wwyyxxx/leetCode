/*
 * @Author: Tungbo
 * @Date: 2022-07-23 16:41:05
 * @LastEditTime: 2022-07-23 18:29:56
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 115. 重建序列
 * 
 * 给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列
 * 检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 
 *  例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2]
 *  而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
 * 
 * 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false
 * 
 */
package wyx.wyx20220718;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        //记录边
        Map<Integer, Set<Integer>> edge = new HashMap<Integer, Set<Integer>>();
        //记录入度
        int[] inDegree = new int[nums.length + 1];
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int from = sequence[i - 1];
                int to = sequence[i];
                // 判断是否有这边
                if (edge.containsKey(from) && edge.get(from).contains(to)) {
                    continue;
                }
                //存在则不插入，直接添加
                edge.putIfAbsent(from, new HashSet<>());
                edge.get(from).add(to);
                inDegree[to]++;
            }
        }
        //记录入度0的点
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            //存在多个入度0的点，false
            if (queue.size() > 1) {
                return false;
            }
            int from = queue.poll();
            //获得连通点
            Set<Integer> to = edge.get(from);
            if (to == null) {
                continue;
            }
            //和此点连通的点入度-1
            for (int point : to) {
                inDegree[point]--;
                if (inDegree[point] == 0) {
                    queue.add(point);
                }
            }
        }
        return true;
    }

}
