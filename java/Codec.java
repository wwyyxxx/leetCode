import java.util.*;
import bean.TreeNode;
/*
 * @Author: Tungbo
 * @Date: 2021-09-22 11:12:38
 * @LastEditTime: 2022-04-01 15:45:35
 * @LastEditors: Tungbo
 * @Description: leecode: 序列化二叉树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        List<Integer> children = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp!=null) {
                children.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                children.add(null);
            }
        }
        return children.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data.equals("[]")) return null;
        String[] v = data.substring(1, data.length() - 1).split(",");
        TreeNode node = new TreeNode(Integer.parseInt(v[0]));
        Queue<TreeNode> queue = new LinkedList<>(){{ add(node); }};
        int i = 1;
        while(!queue.isEmpty()) {
            if(i>=v.length) break;
            TreeNode n = queue.poll();
            if(!v[i].trim().equals("null")) {
                n.left = new TreeNode(Integer.valueOf(v[i].trim()));
                queue.add(n.left);
            }
            i++;
            if(i>=v.length) break;
            if(!v[i].trim().equals("null")) {
                n.right = new TreeNode(Integer.valueOf(v[i].trim()));
                queue.add(n.right);
            }
            i++;
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));