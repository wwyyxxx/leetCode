class Tree {
    var ans : Int = 1
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        countDeep(root)
        return ans -1
    }

    private fun countDeep(root: TreeNode?) :Int {
        if (root == null) return 0
        val l  = countDeep(root.left)
        val r = countDeep(root.right)
        ans = Math.max(ans,l+r+1)
        return Math.max(l,r) +1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}