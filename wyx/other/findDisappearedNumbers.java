package wyx.other;

/*
 * @Author: Tungbo
 * @Date: 2020-10-14 14:27:54
 * @LastEditTime: 2022-05-26 21:57:28
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        HashMap<Integer,Boolean> temp = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            temp.put(nums[i],true);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=1;i<=nums.length;i++) {
            if (!temp.containsKey(i))
                result.add(i);
        }
        return result;
    }
}