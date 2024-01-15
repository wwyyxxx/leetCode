/*
 * @Author: Tungbo
 * @Date: 2022-07-24 17:39:31
 * @LastEditTime: 2022-07-24 18:08:08
 * @LastEditors: Tungbo
 * @Description: leecode: 1184. 公交站间的距离
 * 
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离
 * 
 */
package wyx.wyx20220718;

public class Solution1184 {

    public static void main(String[] args) {
        System.out.println(new Solution1184().distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int startTo = 0;
        int endTo = 0;
        int tempStart = start;
        int n = distance.length;
        while(tempStart != destination) {
            System.out.println("1tempStart "+tempStart);
            startTo += distance[tempStart++];
            tempStart %= n;
        }
        tempStart = start;
        while(tempStart != destination) {
            System.out.println("2tempStart "+tempStart);
            tempStart = --tempStart < 0 ? n -1 : tempStart;
            endTo += distance[tempStart];
        }
        return Math.min(startTo,endTo);
    }
}
