/*
 * @Author: Tungbo
 * @Date: 2022-05-26 16:45:20
 * @LastEditTime: 2022-05-26 17:12:39
 * @LastEditors: Tungbo
 * @Description: leecode: 437. 路径总和 III
 * 
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 */
public class Solution437 {
    

    //递归枚举
    public int pathSum(TreeNode root, int targetSum) {
        if(root != null) return 0;
        int ans = 0;
        ans += rootSum(root, targetSum); //统计根节点
        //递归遍历左右节点
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    public int rootSum(TreeNode root, int targetSum, int sum) {
        int res = 0;

        if(root == null) return res;

        if(sum == targetSum) res++; //存在负数 所以不剪枝

        //递归遍历左右节点
        res += rootSum(root.left, targetSum, sum + root.val);
        res += rootSum(root.right, targetSum, sum + root.val);
        return res;
    }

    //前缀和统计， targetSum = 当前节点和 - 存在的某一个节点 ====> 当前节点和 - target = 存在的某一个节点和
    public int pathSum1(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1); //前缀和初始化map
        return dfs(root,targetSum,map,0);
    }

    public int dfs(TreeNode root, Integer targetSum, Map<Integer,Integer> map, int curr) {
        if(root == null) return 0;
        int res = 0;
        //计算当前和
        curr += root.val;
        //获取有没有符合条件的结果   ====> 当前节点和 - target = 存在的某一个节点和
        res = map.getOrDefault(curr - targetSum, 0);

        //更新当前节点和个数+1
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        //递归遍历左右节点
        res += dfs(root.left, targetSum, map, curr);
        res += dfs(root.right, targetSum, map, curr);
        
        //回溯的时候减去当前和个数-1
        map.put(curr, map.getOrDefault(curr, 0) -1);
        return res;
    }
}
