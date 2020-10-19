public class Tree {
    public static void main(String[] args) {

    }

    int ans = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        countDeep(root);
        return ans-1;
    }
    private int countDeep(TreeNode root){
        if (root == null) return 0;
        int l = countDeep(root.left);
        int r = countDeep(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}