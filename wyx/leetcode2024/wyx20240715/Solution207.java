/*
 * @Author: Tungbo
 * @Date: 2024-07-15 17:40:18
 * @LastEditTime: 2024-07-15 17:59:16
 * @LastEditors: Tungbo
 * @Description: leecode: 207. 课程表
 */
package wyx.leetcode2024.wyx20240715;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] records = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            records[i] = 0;
            list.add(new ArrayList<>());
        }

        for (int[] temp : prerequisites) {
            records[temp[0]]++;
            list.get(temp[1]).add(temp[0]);
        }

        for (int i = 0; i < records.length; i++) {
            if (records[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int index: list.get(pre)) {
                if (--records[index] == 0) {
                    queue.add(index);
                }
            }
        }
        return numCourses == 0;
    }
}
