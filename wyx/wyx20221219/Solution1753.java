package wyx.wyx20221219;

import java.util.PriorityQueue;

/*
 * @Author: Tungbo
 * @Date: 2022-12-21 15:49:14
 * @LastEditTime: 2022-12-21 16:32:34
 * @LastEditors: Tungbo
 * @Description: leecode: 1753. 移除石子的最大得分
 * 
 * 你正在玩一个单人游戏，面前放置着大小分别为 a​​​​​​、b 和 c​​​​​​ 的 三堆 石子。
 * 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
 * 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
 * 
 */
public class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((m,n)->n-m);
        queue.offer(a);
        queue.offer(b);
        queue.offer(c);
        while (true) {
            int x = queue.poll();
            int y = queue.poll();
            if(x == 0 || y == 0) break;
            queue.offer(x-1);
            queue.offer(y-1);
            ans++;
        }
        return ans;
    }

}
