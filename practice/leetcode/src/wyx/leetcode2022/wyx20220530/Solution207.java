/*
 * @Author: Tungbo
 * @Date: 2022-06-04 15:54:34
 * @LastEditTime: 2022-06-04 17:06:55
 * @LastEditors: Tungbo
 * @Description: leecode: 207. 课程表
 * 
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *      例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220530;

import java.util.*;

public class Solution207 {

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;


    public static void main(String[] args) {
        System.out.println(new Solution207().canFinish(2, new int[][] {{1,0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        //已学过的课程
        visited = new int[numCourses];
        for(int[] info: prerequisites) {
            // [1] -> [0]
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            //遍历完
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        //搜索中
        visited[i] = 1;
        for(int v : edges.get(i)) {
            if(visited[v] == 0) { //未学习
                dfs(v);
                if(!valid) {
                    return;
                }
            } else if(visited[v] ==1) { //在学习中 冲突
                valid = false;
                return;
            }
        }
        visited[i] =2; //完成
    }
    
}
