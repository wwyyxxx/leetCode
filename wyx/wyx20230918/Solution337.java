/*
 * @Author: Tungbo
 * @Date: 2023-09-18 14:23:53
 * @LastEditTime: 2023-09-18 15:01:52
 * @LastEditors: Tungbo
 * @Description: leecode: 337. 打家劫舍 III
 */
package wyx.wyx20230918;

import java.util.HashMap;

import wyx.bean.TreeNode;

public class Solution337 {
    
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int money = root.val;
        if(root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }
        int res = Math.max(rob(root.left) + rob(root.right), money);
        map.put(root, res);

        return res;
    }
}
