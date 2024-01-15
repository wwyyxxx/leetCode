/*
 * @Author: Tungbo
 * @Date: 2022-06-24 10:48:50
 * @LastEditTime: 2022-06-24 10:50:57
 * @LastEditors: Tungbo
 * @Description: leecode: 515. 在每个树行中找最大值
 * 
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 
 */
package wyx.wyx20220620;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import wyx.bean.TreeNode;

public class Solution515 {
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        //利用队列来进行层次遍历
        while(!q.isEmpty()) {
            int n = q.size(); //记录每层的个数，每次遍历一层
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                max = Math.max(max,node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(max);
        }
        return res;
    }

}
