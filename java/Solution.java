/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2021-07-06 15:01:04
 * @LastEditors: Tungbo
 * @Description: leecode: leetcode记录
 */
public class Solution {

    public static void main(String[] args) {}


    // 树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return isSameNode(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean isSameNode(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val == B.val && isSameNode(A.left,B.left) && isSameNode(A.right,B.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}