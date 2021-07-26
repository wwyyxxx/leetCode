/*
 * @Author: Tungbo
 * @Date: 2020-10-10 13:45:13
 * @LastEditTime: 2021-07-26 15:16:10
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class reverseTree{
    public static void main(String[] args) {
        System.out.println("Test");
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}