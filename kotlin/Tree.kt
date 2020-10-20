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

    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if(t1==null) return t2
        if(t2==null) return t1
        t1.`val` = t1.`val` + t2.`val`
        t1.left = mergeTrees(t1.left,t2.left)
        t1.right = mergeTrees(t1.right,t2.right)
        return t1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}