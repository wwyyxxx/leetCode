/*
 * @Author: Tungbo
 * @Date: 2021-07-06 14:44:26
 * @LastEditTime: 2021-07-09 15:22:14
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

    // 正则表达式匹配
    public boolean isMatchOfMy(String s, String p) {
        int len = p.length();
        for(int i=0;i<len;i++){
            if(s.length()==0) return true;
            char temp = p.charAt(i);
            switch(temp){
                case '.':
                    s = s.substring(1);
                    break;
                case '*':
                    if(i!=0) {
                        char div = p.charAt(i-1);
                        s = sub(s,div);
                    }
                    break;
                default:
                    if(s.charAt(0) == temp) {
                        s = s.substring(1);
                    } else return false;
            }
        }
        return s.length() == 0;
    }
    public String sub(String s,char div){
        if(s.length() == 0) return "";
        if(div == '.') return "";
        if(s.charAt(0) == div) s = sub(s.substring(1),div);
        return s;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    
    // 二叉树的镜像
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tempLeft = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tempLeft);
        return root;
    }

    // 对称的二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode rootL,TreeNode rootR) {
        if(rootL == null && rootR == null) return true;
        if(rootL == null || rootR == null) return false;
        return rootL.val == rootR.val && isSymmetric(rootL.left,rootR.right) && isSymmetric(rootL.right,rootR.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}