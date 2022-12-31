/*
 * @Author: Tungbo
 * @Date: 2022-12-31 21:03:12
 * @LastEditTime: 2022-12-31 21:05:10
 * @LastEditors: Tungbo
 * @Description: leecode: 2037. 使每位学生都有座位的最少移动次数
 */
package wyx.wyx20221226;

import java.util.Arrays;

public class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            answer += Math.abs(students[i] - seats[i]);
        }
        return answer;
    }
}
