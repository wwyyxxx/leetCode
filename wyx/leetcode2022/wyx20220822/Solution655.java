/*
 * @Author: Tungbo
 * @Date: 2022-08-22 15:13:51
 * @LastEditTime: 2022-08-22 15:36:20
 * @LastEditors: Tungbo
 * @Description: leecode: 655. 输出二叉树
 * 
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则
 *  
 *  树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1
 *  矩阵的列数 n 应该等于 2height+1 - 1
 *  根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2]
 *  对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1]
 *  继续这一过程，直到树中的所有节点都妥善放置
 *  任意空单元格都应该包含空字符串 ""
 * 
 * 返回构造得到的矩阵 res
 */
package wyx.wyx20220822;

import java.util.ArrayList;
import java.util.List;

import wyx.bean.TreeNode;

public class Solution655 {

    int height;
    List<List<String>> answer;

    public List<List<String>> printTree(TreeNode root) {
        initHeigth(root, 0);
        answer = new ArrayList<List<String>>();
        int m = height + 1, n = (int) (Math.pow(2, height + 1) - 1);
        for (int i = 0; i < m; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                temp.add("");
            }
            answer.add(temp);
        }
        dfs(root, 0, (n - 1) / 2);
        return answer;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null)
            return;
        answer.get(x).set(y, root.val + "");
        dfs(root.left, x + 1, (int) (y - Math.pow(2, height - x - 1)));
        dfs(root.right, x + 1, (int) (y + Math.pow(2, height - x - 1)));
    }

    private void initHeigth(TreeNode root, int i) {
        if (root == null)
            return;
        height = Math.max(i, height);
        initHeigth(root.left, i + 1);
        initHeigth(root.right, i + 1);
    }

}
