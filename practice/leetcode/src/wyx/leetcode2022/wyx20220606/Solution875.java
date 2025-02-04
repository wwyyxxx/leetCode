/*
 * @Author: Tungbo
 * @Date: 2022-06-07 15:36:04
 * @LastEditTime: 2022-06-07 15:37:10
 * @LastEditors: Tungbo
 * @Description: leecode: 875. 爱吃香蕉的珂珂
 * 
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 
 */
package practice.leetcode.src.wyx.leetcode2022.wyx20220606;

public class Solution875 {
    
    public int minEatingSpeed(int[] piles, int h) {
        //最大速度
        int maxval = 0;
        for(int pile : piles) {
            maxval = Math.max(pile,maxval);
        }
        //最小速度
        int minval = 1;
        int k = maxval;
        //二分查找 最小的速度
        while(minval < maxval) {
            int mid = minval + (maxval - minval) /2;
            if(caclulatSum(piles,mid) <= h) {
                k = mid;
                maxval = mid;
            } else {
                minval = mid + 1;
            }
        }
        return k;
    }

    public int caclulatSum(int[] piles, int speed) {
        int ans = 0;
        for(int pile : piles) {
            // ans += Math.ceil(pile/speed);
            ans += (pile + speed - 1) / speed;
        }
        return ans;
    }

}
