/*
 * @Author: Tungbo
 * @Date: 2022-08-29 16:12:46
 * @LastEditTime: 2022-08-29 16:42:56
 * @LastEditors: Tungbo
 * @Description: leecode: 搜索旋转排序数组
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220829;

public class Solution1003 {

    public int search1(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public boolean search2(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return true;
            if(arr[l] == arr[mid]) {
                l++;
                continue;
            }
            if(arr[l] < arr[mid]) {
                if(arr[l] <= target && target <= arr[mid]) {
                    r = mid - 1;
                } else l = mid + 1;
            } else {
                if(arr[mid] <= target && target <= arr[r]) {
                    l = mid + 1;
                } else r = mid - 1;
            }
         }
        return false;
    }
}
