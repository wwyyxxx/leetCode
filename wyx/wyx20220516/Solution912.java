package wyx.wyx20220516;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-05-12 18:55:12
 * @LastEditTime: 2022-05-26 21:58:17
 * @LastEditors: Tungbo
 * @Description: leecode:  排序数组
 * 
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 */
public class Solution912 {
    
    public int[] sortArray(int[] nums) {
        return headSort(nums);
    }

    //冒泡  两层遍历
    public int[] BubbleSort(int[] nums){
        for(int i = 0;i < nums.length; i++) {
            //每一次把最大的值交换到最后
            for(int j= 0; j < nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]) {
                    swap(nums,j+1,j);
                }
            }
        }
        return nums;
    }

    //选择 两层遍历
    public int[] SelectorSort(int[] nums){
        for(int i = 0;i < nums.length-1; i++) {
            int min = i;
            for(int j= i+1; j < nums.length; j++) {
                //找出最小的一个，然后交换
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(i != min) {
                swap(nums,i,min);
            }
        }
        return nums;
    }

    //插入 
    public int[] InsertSort(int[] nums){
        for(int i = 1;i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            //往前比较，然后位置交换
            while(j > 0 && temp < nums[j-1]) {
                nums[j] = nums[j-1];
                j--;
            }
            if(j !=i ) {
                nums[j] = temp;
            }
        }
        return nums;
    }

    // 快排 选出基点,大小部分递归
    public int[] QuickSort(int[] nums, int left, int right){
        if(left < right) {
            int p = handleP(nums,left,right);
            QuickSort(nums,left,p - 1);
            QuickSort(nums,p, right);
        }
        return nums;
    }

    //选出基点
    private int handleP(int[] nums, int left, int right){
        int p = left;
        int index = p + 1;
        for(int i = index;i<=right;i++) {
            // 比基点小的移动到基点前面，记录交换后的一个index
            if(nums[i] < nums[p]) {
                swap(nums,index,i);
                index++;
            }
        }
        swap(nums,p,index-1);
        return index-1;
    }

    //归并排序
    public int[] sort(int[] nums){
        if(nums.length < 2) return nums;
        int mid = nums.length / 2;
        //递归折半后，然后合并时做排序
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);
        return merge(sort(left), sort(right));
    }
    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int n = left.length-1;
        int m = right.length-1;
        int i = 0;
        //同时遍历两个数组，插入新数组中
        while(n>=0 && m>=0) {
            if(left[n] < right[m]) {
                res[i++] = left[n];
                n--;
            } else {
                res[i++] = right[m];
                m--;
            }
        }
        //处理数组长度不一致的情况
        while(n>=0) {
            res[i++] = left[n];
            n--;
        }
        while(m>=0) {
            res[i++] = right[m];
            m--;
        }
        return res;
    }

    //堆排序
    public int[] headSort(int[] nums) {
        //1.构建大顶堆 -- 左 < 右 < 根
        for(int i= nums.length/2-1 ;i>=0;i--){
            //从第一个非叶子结点（nums.length/2-1）从下至上，从右至左调整结构
            headpify(nums,i,nums.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        //上一次调整已经把最大值移动到了最后
        for(int j=nums.length-1;j>0;j--){
            swap(nums,0,j);//将堆顶元素与末尾元素进行交换
            headpify(nums,0,j);//重新对堆进行调整 只需要把当前堆顶元素找到合适的位置即可
        }
        return nums;
    }
    private void headpify(int[] nums, int i, int j) {
        int temp = nums[i];
        // 左叶子节点=i*2+1  
        for(int k = i*2+1; k < j; k = k*2+1) {
            if(k+1 < j && nums[k] < nums[k+1]) {
                k++; //指向右节点  
            }
            if(nums[k] > temp) {
                nums[i] = nums[k];
                //保留交换节点
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    //希尔排序
    private int[] shellSort(int[] nums){
        //对半进行分组
        for (int i = nums.length/2; i > 0; i /= 2) {
            //每一组做交换处理
            for (int j = i; j < nums.length; j++) {
                int tempIdx = j;
                while(tempIdx-i >=0 && nums[tempIdx] < nums[tempIdx-i]) {
                    swap(nums,tempIdx,tempIdx-i);
                    tempIdx -= i;
                }
            }
        }
        return nums;
    }

    
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}