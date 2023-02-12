/*
 * @Author: Tungbo
 * @Date: 2023-02-12 15:12:52
 * @LastEditTime: 2023-02-12 15:24:54
 * @LastEditors: Tungbo
 * @Description: leecode: 1138. 字母板上的路径
 */
package wyx.wyx20230206;

public class Solution1138 {
    public String alphabetBoardPath(String target) {
        int[][] dic = new int[26][2];
        int idx = 'a';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j <5;j++) {
                dic[idx-'a'][0] = i; dic[idx-'a'][1] = j;
                idx++;
                if(idx > 'z') break;
            }
        }
        int[] curIdx = new int[]{0,0};
        for(char c : target.toCharArray()) {
            int[] tg = new int[]{dic[c-'a'] [0]- curIdx[0], dic[c-'a'][1]- curIdx[1]};
            String step = tg[0] > 0 ? "D" : "U";
            String v = step.repeat(Math.abs(tg[0]));
            step = tg[1] > 0 ? "R" : "L";
            String h = step.repeat(Math.abs(tg[1]));
            sb.append(c == 'z' ? h + v : v+h).append("!");
            curIdx = dic[c - 'a'];
        }
        return sb.toString();
    }
}
