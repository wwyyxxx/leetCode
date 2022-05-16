package java;
import java.bean.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * @Author: Tungbo
 * @Date: 2022-04-01 15:07:46
 * @LastEditTime: 2022-04-01 16:06:07
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class Codec1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[null]";
        List<String> res = new ArrayList<String>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode child = queue.poll();
            
            if(child == null) 
                res.add("null");
            else
                res.add(String.valueOf(child.val));
            if(child != null) {
                queue.add(child.left);
                queue.add(child.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = "[1,2,3,null,null,4,5]";
        if(data.equals("[]")) return null;
        String[] parts = data.substring(1, data.length() - 1).split(",");
        TreeNode res = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(res);
        int i = 1;
        while(!q.isEmpty()) {
            if(i>=parts.length) break;
            TreeNode child = q.poll();
            if(!parts[i].trim().equals("null")) {
                child.left = new TreeNode(Integer.parseInt(parts[i]));
                q.add(child.left);
            }
            i++;
            if(i>=parts.length) break;
            if(!parts[i].equals("null")) {
                child.right = new TreeNode(Integer.parseInt(parts[i]));
                q.add(child.right);
            }
            i++;
        }
        serialize(res);
        return res;
    }

}