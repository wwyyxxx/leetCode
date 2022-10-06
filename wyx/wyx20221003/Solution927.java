/*
 * @Author: Tungbo
 * @Date: 2022-10-06 20:19:48
 * @LastEditTime: 2022-10-06 20:20:54
 * @LastEditors: Tungbo
 * @Description: leecode: 927. 三等分
 * 
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * 如果无法做到，就返回 [-1, -1]。
 * 
 */
package wyx.wyx20221003;

public class Solution927 {
    private int[] arr;

    public int[] threeEqualParts(int[] arr) {
        this.arr = arr;
        int cnt = 0;
        int n = arr.length;
        for (int v : arr) {
            cnt += v;
        }
        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        cnt /= 3;

        int i = find(1), j = find(cnt + 1), k = find(cnt * 2 + 1);
        for (; k < n && arr[i] == arr[j] && arr[j] == arr[k]; ++i, ++j, ++k) {
        }
        return k == n ? new int[]{i - 1, j} : new int[]{-1, -1};
    }

    private int find(int x) {
        int s = 0;
        for (int i = 0; i < arr.length; ++i) {
            s += arr[i];
            if (s == x) {
                return i;
            }
        }
        return 0;
    }
}
