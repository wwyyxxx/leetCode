package practice.leetcode.src.wyx.leetcode2023.wyx20230410;
/*
 * @Author: Tungbo
 * @Date: 2023-04-10 17:27:17
 * @LastEditTime: 2023-04-10 18:24:41
 * @LastEditors: Tungbo
 * @Description: leecode: 1041. 困于环中的机器人
 */
public class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int k = 0;
        int[] dist = new int[4];
        for (int i = 0; i < instructions.length(); ++i) {
            char c = instructions.charAt(i);
            if (c == 'L') {
                k = (k + 1) % 4;
            } else if (c == 'R') {
                k = (k + 3) % 4;
            } else {
                ++dist[k];
            }
        }
        return (dist[0] == dist[2] && dist[1] == dist[3]) || (k != 0);
    }
}
