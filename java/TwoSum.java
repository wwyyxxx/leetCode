/*
 * @Author: Tungbo
 * @Date: 2020-10-10 13:38:58
 * @LastEditTime: 2021-07-26 15:18:40
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */

import java.util.*;

public class TwoSum {

    /*public static void main(String[] args) {
        twoSum(new int[]{-1,-2,-3,-4,-5,-7},-8);
    }*/

    public static int[] twoSum1(int[] nums, int target) {
        Set<Integer> indexs = new HashSet<Integer>();
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums.length;j++){
                if (i == j ) break;
                if(nums[i] + nums[j] == target){
                    indexs.add(new Integer(i));
                    indexs.add(new Integer(j));
                }
            }
        }
        Iterator iterator = indexs.iterator();
        int[] ints = new int[indexs.size()];
        int z = 0;
        while(iterator.hasNext()){
            int st = (int)iterator.next();
            ints[z] = st;
            z++;
            System.out.println(st);
        }
        return ints;
    }

    public static  int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum()  {
        int[] nums = new int[]{-1,-2,-3,-4,-5,-7};
        int target = -8;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println(i);
                System.out.println(map.get(complement));
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
