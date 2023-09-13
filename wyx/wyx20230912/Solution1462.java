/*
 * @Author: Tungbo
 * @Date: 2023-09-12 17:01:33
 * @LastEditTime: 2023-09-12 17:20:10
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.wyx20230912;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>(numCourses);
        List<Boolean> res = new ArrayList<>();
        Collections.fill(list, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int[] querie : queries) {
            int u = querie[0], v = querie[1];
            List<Integer> temp = list.get(u);
            if(temp.isEmpty()) {
                res.add(false);
            } else {
                boolean flag = false;
                for (int i = 0; i < queries.length; i++) {
                    temp
                }
            }
        }
    }

    private boolean searchResult() {
        
    }
}
