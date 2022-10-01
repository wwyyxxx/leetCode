/*
 * @Author: Tungbo
 * @Date: 2022-07-01 15:16:54
 * @LastEditTime: 2022-07-04 19:00:27
 * @LastEditors: Tungbo
 * @Description: leecode: 241. 为运算表达式设计优先级
 * 
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * 
 */
package wyx.wyx20220627;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    public static void main(String[] args) {
        System.out.println(new Solution241().diffWaysToCompute("2-1-1"));
    }

    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> nums = new ArrayList<Integer>();
    List<Character> ops = new ArrayList<Character>();

    public List<Integer> diffWaysToCompute(String expression) {
        for (int i = 0; i < expression.length();) {
            if (!Character.isDigit(expression.charAt(i))) {
                ops.add(expression.charAt(i));
                i++;
            } else {
                int t = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    t = t * 10 + expression.charAt(i) - '0';
                    i++;
                }
                nums.add(t);
            }
        }
        int N = nums.size();
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(nums.get(i));
            dp[i][i] = res;
        }
        // 2 个数字到 N 个数字
        for (int n = 2; n <= N; n++) {
            // 开始下标
            for (int i = 0; i < N; i++) {
                // 结束下标
                int j = i + n - 1;
                if (j >= N) {
                    break;
                }
                ArrayList<Integer> result = new ArrayList<>();
                // 分成 i ~ s 和 s+1 ~ j 两部分
                for (int s = i; s < j; s++) {
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for (int x = 0; x < result1.size(); x++) {
                        for (int y = 0; y < result2.size(); y++) {
                            // 第 s 个数字下标对应是第 s 个运算符
                            char op = ops.get(s);
                            result.add(caculate(result1.get(x), op, result2.get(y)));
                        }
                    }
                }
                dp[i][j] = result;

            }
        }
        return dp[0][N - 1];
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }
}
