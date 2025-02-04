/*
 * @Author: Tungbo
 * @Date: 2022-06-20 16:30:09
 * @LastEditTime: 2022-06-20 17:28:52
 * @LastEditors: Tungbo
 * @Description: leecode: 剑指 Offer II 075. 数组相对排序
 * 
 * 给定两个数组，arr1 和 arr2，
 *  arr2 中的元素各不相同
 *  arr2 中的每个元素都出现在 arr1 中
 * 
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220620;

public class Solution075 {

    public static void main(String[] args) {
        System.out.println(new Solution075().relativeSortArray(new int[] {2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
    }
    
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //先把所有存在的数字往前移动。并记录下标
        int idx = 0;
        for(int i = 0; i < arr2.length; i++) {
            int target = arr2[i];
            for(int j = idx; j < arr1.length; j++) {
                if(arr1[j] == target ) {
                    if(idx != j) {
                        swap(arr1, idx, j);
                    }
                    idx++;
                }
            }
        }
        //排序下标后的剩余数字
        for (int i = idx; i < arr1.length; i++) {
            for (int j = idx; j < arr1.length -1; j++) {
                if(arr1[j] > arr1[j+1]) {
                    swap(arr1, j, j+1);
                }
            }
        }
        return arr1;
    }

    private void swap(int[] arr1, int idx, int j) {
        int temp = arr1[j];
        arr1[j] = arr1[idx];
        arr1[idx] = temp;
    }

}
