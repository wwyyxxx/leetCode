/*
 * @Author: Tungbo
 * @Date: 2022-05-19 18:52:59
 * @LastEditTime: 2022-05-19 18:53:01
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class Solution105 {
    
    private HashMap<Integer,Integer> map;

    //先序遍历 中左右
    //中序遍历 左中右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer,Integer>();
        for(int i = 0; i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) return null;
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int inorder_root = map.get(preorder[preorder_left]);
        int inorder_new_right = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + inorder_new_right, inorder_left, inorder_root - 1); 
        root.right = myBuildTree(preorder, inorder, preorder_left + inorder_new_right + 1, preorder_right, inorder_root+ 1, inorder_right);
        return root;
    }
    
}
