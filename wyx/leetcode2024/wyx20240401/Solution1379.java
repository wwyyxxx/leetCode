/*
 * @Author: Tungbo
 * @Date: 2024-04-03 17:22:07
 * @LastEditTime: 2024-04-03 17:22:09
 * @LastEditors: Tungbo
 * @Description: leecode: 1379. 找出克隆二叉树中的相同节点
 */
package wyx.leetcode2024.wyx20240401;

import wyx.bean.TreeNode;

public class Solution1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    public TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if(original == null) return null;
        if(original == target) return cloned;
        TreeNode res =  dfs(original.left, cloned.left, target);
        if(res != null) {
            return res;
        }
        return dfs(original.right, cloned.right, target);
    }
}
