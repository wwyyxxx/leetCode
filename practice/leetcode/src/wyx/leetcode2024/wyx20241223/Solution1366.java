/*
 * @Author: Tungbo
 * @Date: 2024-12-29 13:43:38
 * @LastEditTime: 2024-12-29 15:09:15
 * @LastEditors: Tungbo
 * @Description: leecode: 1366. 通过投票对团队排名
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20241223;

import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution1366 {
    public String rankTeams(String[] votes) {
        int n = votes.length;
        if (n == 1) {
            return votes[0];
        }
        int m = votes[0].length();
        int[][] cnts = new int[26][m];
        for(String vote : votes) {
            for(int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                cnts[c - 'A'][i]++;// 统计每个候选人在每个位置上的票数
            }
        }
        
        return votes[0].chars().mapToObj(c -> (char) c).sorted(((a,b) -> {
            int[] cntA = cnts[a - 'A'];
            int[] cntB = cnts[b - 'A'];
            for (int i = 0; i < cntA.length; i++) {
                if (cntA[i] != cntB[i]) {
                    return cntB[i] - cntA[i]; // 按照每个位置上的票数降序排序
                }
            }
            return a - b; // 如果票数相同，则按字母顺序升序排序
        })).map(String::valueOf).collect(Collectors.joining()); // 将排序后的字符转换为字符串并连接成最终结果
    }
}
