/*
 * @Author: Tungbo
 * @Date: 2023-08-20 21:23:39
 * @LastEditTime: 2023-08-20 21:23:43
 * @LastEditors: Tungbo
 * @Description: leecode: 2236. 判断根结点是否等于子结点之和
 */
package wyx.wyx20230814;

import wyx.bean.TreeNode;

public class Solution2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
