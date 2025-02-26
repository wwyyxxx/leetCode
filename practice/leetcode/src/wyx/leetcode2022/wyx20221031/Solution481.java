/*
 * @Author: Tungbo
 * @Date: 2022-10-31 10:48:46
 * @LastEditTime: 2022-10-31 10:59:40
 * @LastEditors: Tungbo
 * @Description: leecode: 481. 神奇字符串
 * 
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 *  神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串
 * 
 * s 的前几个元素是 s = "1221121221221121122……" 。
 * 如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
 * 每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。
 * 上面的出现次数正是 s 自身
 * 
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221031;

public class Solution481 {

    public int magicalString(int n) {
        int[] s = new int[n + 2];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        int target = 2;
        for (int i = 2, idx = 3; idx < n; i++) {
            target = target == 1 ? 2 : 1;
            s[idx++] = target;
            if (s[i] == 2)
                s[idx++] = target;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 1)
                ans++;
        }
        return ans;
    }
}
