/*
 * @Author: Tungbo
 * @Date: 2022-08-20 16:07:10
 * @LastEditTime: 2022-08-30 11:45:20
 * @LastEditors: Tungbo
 * @Description: leecode: 654. 最大二叉树
 * 
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建
 *  创建一个根节点，其值为 nums 中的最大值
 *  递归地在最大值 左边 的 子数组前缀上 构建左子树
 *  递归地在最大值 右边 的 子数组后缀上 构建右子树
 * 返回 nums 构建的 最大二叉树 。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220815;

import practice.leetcode.src.wyx.bean.TreeNode;

public class Sution654 {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums,0,nums.length - 1);
    }

    private TreeNode constructTree(int[] nums, int left, int rigth) {
        if(left > rigth) {
            return null;
        }
        int max = left;
        for (int i = left; i <= rigth; i++) {
            if(nums[max] < nums[i]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructTree(nums, left, max - 1);
        node.right = constructTree(nums, max + 1, rigth);
        return node;
    }

}
