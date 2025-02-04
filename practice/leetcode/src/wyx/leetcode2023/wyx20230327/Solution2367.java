package practice.leetcode.src.wyx.leetcode2023.wyx20230327;

/*
 * @Author: Tungbo
 * @Date: 2023-03-31 10:38:50
 * @LastEditTime: 2023-03-31 11:01:15
 * @LastEditors: Tungbo
 * @Description: leecode: 2367. 算术三元组的数目
 */
public class Solution2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        boolean[] vis = new boolean[251];
        for(int x : nums) {
            vis[x] = true;
        }
        for(int x : nums) {
            if(vis[x + diff] && vis[x + diff + diff]) ans++;
        }
        return ans;
    }

    public int arithmeticTriplets1(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[j] - nums[i] > diff) break;
                if(nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < n; k++) {
                        if(nums[k] - nums[j] > diff) break;
                        if(nums[k] - nums[j] == diff) {
                            ans++;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

}