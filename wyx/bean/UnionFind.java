/*
 * @Author: Tungbo
 * @Date: 2023-12-11 17:17:03
 * @LastEditTime: 2023-12-11 17:53:07
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.bean;

public class UnionFind {
    int count; // 连通分量个数
    int[] parent; // 节点i的父节点是parent[i]

    public UnionFind(int N) {
        this.count = N; // n为图的节点总数
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i; // 父节点指针初始指向自己
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        parent[rootX] = rootY; // x成为y的子树
        count--;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
