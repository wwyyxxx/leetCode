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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null) return t2;
        if (t2==null) return t1;
        t1.val = t1.val + t2.val;
        t1.left=mergeTrees(t1.left,t2.left);
        t1.right=mergeTrees(t1.right,t2.right);
        return t1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}