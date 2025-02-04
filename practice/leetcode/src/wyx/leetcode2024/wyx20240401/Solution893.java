/*
 * @Author: Tungbo
 * @Date: 2024-04-02 11:27:02
 * @LastEditTime: 2024-04-02 11:36:37
 * @LastEditors: Tungbo
 * @Description: leecode: 894. 所有可能的真二叉树
 */
package practice.leetcode.src.wyx.leetcode2024.wyx20240401;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Solution893 {

    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
