/*
 * @Author: Tungbo
 * @Date: 2025-02-26 22:05:48
 * @LastEditTime: 2025-02-26 22:05:52
 * @LastEditors: Tungbo
 * @Description: leecode: 2502. 设计内存分配器
 */
package practice.leetcode.src.wyx.leetcode2025.wyx20250224;

import java.util.Arrays;

public class Allocator {

    private int[] m;

    public Allocator(int n) {
        m = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int cnt = 0;
        for (int i = 0; i < m.length; ++i) {
            if (m[i] > 0) {
                cnt = 0;
            } else if (++cnt == size) {
                Arrays.fill(m, i - size + 1, i + 1, mID);
                return i - size + 1;
            }
        }
        return -1;
    }
    
    public int freeMemory(int mID) {
        int ans = 0;
        for (int i = 0; i < m.length; ++i) {
            if (m[i] == mID) {
                m[i] = 0;
                ++ans;
            }
        }
        return ans;
    }
}
