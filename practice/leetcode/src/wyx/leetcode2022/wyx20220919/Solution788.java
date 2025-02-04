/*
 * @Author: Tungbo
 * @Date: 2022-09-25 19:35:29
 * @LastEditTime: 2022-09-25 19:52:56
 * @LastEditors: Tungbo
 * @Description: leecode: 788. 旋转数字
 * 
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220919;

import java.util.HashMap;
import java.util.Map;

public class Solution788 {

    public int rotatedDigits(int n) {
        int ans = 0;
        Map<Character, Character> dic = new HashMap<Character, Character>();
        dic.put('0', '0');
        dic.put('1', '1');
        dic.put('2', '5');
        dic.put('5', '2');
        dic.put('6', '9');
        dic.put('8', '8');
        dic.put('9', '6');
        for (int i = 2; i <= n; i++) {
            Boolean flag = false;

            char[] chs = String.valueOf(i).toCharArray();
            for (int j = 0; j < chs.length; j++) {
                if(!dic.containsKey(chs[j])) {
                    flag = false;
                    break;
                } else {
                    if(chs[j] != '0' && chs[j] != '1' && chs[j] != '8') {
                        // System.out.println(String.valueOf(chs[j]));
                        flag = true;
                    }
                }

            }

            if (flag)
                ans++;
        }
        return ans;
    }

}
