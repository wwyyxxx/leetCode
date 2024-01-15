package wyx.wyx20220523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: Tungbo
 * @Date: 2022-05-25 23:06:51
 * @LastEditTime: 2022-05-25 23:08:03
 * @LastEditors: Tungbo
 * @Description: leecode:  47. 全排列 II
 * 
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 
 */
public class Solution047 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums, vis, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int i, int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j=0;j<nums.length;j++) {
            //因为是可重复的，所以需要剪枝
            if(vis[j] || (j > 0 && !vis[j-1] && nums[j-1] == nums[j]) ) continue;
            vis[j] = true;
            path.add(nums[j]);
            dfs(i+1,nums,vis,path,res);
            path.remove(path.size() - 1);
            vis[j] = false;
        }
    }
    
}