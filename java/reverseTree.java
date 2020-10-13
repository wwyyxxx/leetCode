public class reverseTree(){
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