/*
 * @Author: Tungbo
 * @Date: 2022-07-30 15:46:47
 * @LastEditTime: 2022-07-30 15:48:24
 * @LastEditors: Tungbo
 * @Description: leecode: 952. 按公因数计算最大组件大小
 * 
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 *  有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记
 *  只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边
 * 返回 图中最大连通组件的大小
 * 
 */
package wyx.wyx20220725;

import java.util.Arrays;

public class Solution952 {
    
    public int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }

    class UnionFind {
        int[] parent;
        int[] rank;
    
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }
    
        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx]++;
                }
            }
        }
    
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

}
