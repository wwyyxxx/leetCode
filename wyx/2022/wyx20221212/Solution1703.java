/*
 * @Author: Tungbo
 * @Date: 2022-12-18 19:47:13
 * @LastEditTime: 2022-12-18 20:22:20
 * @LastEditors: Tungbo
 * @Description: leecode: 1703. 得到连续 K 个 1 的最少相邻交换次数
 * 
 * 给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。
 * 每一次移动，你可以选择 相邻 两个数字并将它们交换。
 * 请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
 * 
 */
package wyx.wyx20221212;

import java.util.ArrayList;
import java.util.List;

public class Solution1703 {

    List<Integer> zeros;
    int[] pre;

    public int minMoves(int[] nums, int k) {
        zeros = new ArrayList<>();
        GenerateZeros(nums);

        int cost = 0;
        int left = 0, right = k - 2;
        for (int i = left; i <= right; i++) {
            cost += zeros.get(i) * (Math.min(i + 1, right - i + 1));
        }
        int minCost = cost;
        GeneratePresum();

        int i = 1, j = i + k - 2;
        for (; j < nums.length; i++, j++) {
            int mid = (i + j) / 2;
            cost -= GetRangeSum(i - 1, mid - 1);
            cost += GetRangeSum(mid + k % 2, j);
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    private int GetRangeSum(int i, int j) {
        return pre[j + 1] - pre[i];
    }

    private void GeneratePresum() {
        pre = new int[zeros.size() + 1];
        for (int i = 1; i <= zeros.size(); i++) {
            pre[i] = pre[i - 1] + zeros.get(i - 1);
        }
    }

    private void GenerateZeros(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n && nums[i] == 0)
            i++;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == 0)
                j++;
            if (j < n)
                zeros.add(j - i - 1);
            i = j;
        }
    }

}
