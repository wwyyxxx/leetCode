/*
 * @Author: Tungbo
 * @Date: 2022-06-06 15:08:59
 * @LastEditTime: 2022-06-06 16:00:36
 * @LastEditors: Tungbo
 * @Description: leecode: 394. 字符串解码
 * 
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 */
package wyx.wyx20220606;

import java.util.Stack;

public class Soultion394 {
    

    public String decodeString(String s) {
        StringBuilder strb = new StringBuilder();
        //保存已走过的res
        Stack<String> res_stack = new Stack<String>();
        //保存已走过的num
        Stack<Integer> num_stack = new Stack<Integer>();
        int numilt = 0; //倍数
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                //最近的一个数字
                int n = num_stack.pop();
                StringBuilder temp = new StringBuilder();
                //拼接
                for(int j = 0; j < n; j++) temp.append(strb);
                strb = new StringBuilder(res_stack.pop() + temp);
            }else if(s.charAt(i) == '[') {
                //储存预处理的数据
                res_stack.push(strb.toString());
                num_stack.push(numilt);
                //初始化
                numilt = 0;
                strb = new StringBuilder();
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                //会有多位数的情况 --> 100
                numilt =numilt*10+ Integer.parseInt(s.charAt(i)+"");

            } else {
                //储存字符传 ，后续倍数拼接
                strb.append(s.charAt(i));
            }
            
        }
        return strb.toString();
    }


    //不能处理"3[a2[c]]"情况
    public String decodeString1(String s) {
        // StringBuilder
        StringBuilder strb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ']') {
                stack.push(i);
            }else if(s.charAt(i) == '[') {
                String str = s.substring(i+1, stack.pop());
                int n = Integer.parseInt(String.valueOf(s.charAt(i-1)));
                for (int j = 0; j < n; j++) {
                    strb.insert(0, str);
                }
                i--;
            } else if(stack.isEmpty()){
                strb.insert(0, s.charAt(i));
            }
            
        }
        return strb.toString();
    }
}
