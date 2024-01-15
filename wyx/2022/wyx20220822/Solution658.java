/*
 * @Author: Tungbo
 * @Date: 2022-08-25 11:27:45
 * @LastEditTime: 2022-08-25 15:44:41
 * @LastEditors: Tungbo
 * @Description: leecode: 658. 找到 K 个最接近的元素
 * 
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 */
package wyx.wyx20220822;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
        }
        Collections.sort(ans, (a,b)->{
            if(Math.abs(a-x) != Math.abs(b-x)) {
                return Math.abs(a-x) - Math.abs(b-x);
            } else return 0;
        });
        ans = ans.subList(0, k);
        Collections.sort(ans);
        return ans;
    }
    
}
