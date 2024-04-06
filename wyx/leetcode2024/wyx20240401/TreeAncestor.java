/*
 * @Author: Tungbo
 * @Date: 2024-04-06 16:16:28
 * @LastEditTime: 2024-04-06 19:05:07
 * @LastEditors: Tungbo
 * @Description: leecode: 1483. 树节点的第 K 个祖先
 */
package wyx.leetcode2024.wyx20240401;

public class TreeAncestor {

    int[] parent;
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        while (k > 0 || node != -1) {
            node = parent[node];
        }
        return node;
    }
}
