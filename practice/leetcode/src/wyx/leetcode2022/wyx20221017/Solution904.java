/*
 * @Author: Tungbo
 * @Date: 2022-10-17 11:33:54
 * @LastEditTime: 2022-10-17 11:33:54
 * @LastEditors: Tungbo
 * @Description: leecode: 904. 水果成篮
 * 
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果
 *  你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制
 *  你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘
 *  一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20221017;

import java.util.HashMap;
import java.util.Map;

public class Solution904 {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> record = new HashMap<>();
        int n = fruits.length;
        int l = 0, r = 0;
        int temp = 0, ans = 0;
        while (r < n) {
            record.put(fruits[r], record.getOrDefault(fruits[r], 0) + 1);
            temp++;
            while (record.size() > 2) {
                record.put(fruits[l], record.get(fruits[l]) - 1);
                temp--;
                if(record.get(fruits[l]) <= 0) record.remove(fruits[l]);
                l++;
            }
            r++;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

}
