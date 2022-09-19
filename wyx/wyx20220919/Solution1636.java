/*
 * @Author: Tungbo
 * @Date: 2022-09-19 16:15:21
 * @LastEditTime: 2022-09-19 16:28:52
 * @LastEditors: Tungbo
 * @Description: leecode: 1636. 按照频率将数组升序排序
 * 
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序
 * 请你返回排序后的数组。
 * 
 */
package wyx.wyx20220919;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            list.add(nums[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer i1, Integer i2) {
                int cnt1 = map.get(i1), cnt2 = map.get(i2);
                return cnt1 != cnt2 ? cnt1 - cnt2 : i2 - i1;
            }
        });
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
