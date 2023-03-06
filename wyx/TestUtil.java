/*
 * @Author: Tungbo
 * @Date: 2021-10-10 17:32:11
 * @LastEditTime: 2023-03-06 11:39:30
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx;

import java.util.*;

import wyx.wyx20221212.Solution1925;
import wyx.wyx20230109.Solution1807;
import wyx.wyx20230116.Solution1813;
import wyx.wyx20230116.Solution1814;
import wyx.wyx20230116.Solution2299;
import wyx.wyx20230130.Solution2325;
import wyx.wyx20230206.Solution1138;

/*
 * @Author: Tungbo
 * @Date: 2021-09-03 15:09:15
 * @LastEditTime: 2022-10-14 15:47:22
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
public class TestUtil {
    public static void main(String[] args) {
        System.out.println(new Solution1138().alphabetBoardPath("leet"));
        Arrays.toString(args);
    }

    public int trap(int[] height) {
        int ans = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                ans += (min - height[i]);
            }
        }
        return ans;
    }
}
