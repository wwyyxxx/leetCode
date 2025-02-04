package practice.leetcode.src.wyx.leetcode2022.wyx20220516;

import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-05-12 18:55:12
 * @LastEditTime: 2023-03-08 11:45:59
 * @LastEditors: Tungbo
 * @Description: leecode:  八大排序算法数组
 * 
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 */
public class Solution912 {
    
    public int[] sortArray(int[] nums) {
        return headSort(nums);
    }

    //冒泡  两层遍历，每次把最大的冒泡到最后 O(n^2)
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

    public void BubbleSort1(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j]>nums[j+1]) {
                    swap(nums,j,j+1);
                }
            }
        }
    }
    
    //选择 两层遍历,每次找出最小的一个 O(n^2)
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

    public void SelectorSort1(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] < nums[i]) min = j;
            }
            if(i != min) {
                swap(nums,i,min);
            }
        }
    }

    //插入 逐渐往前比较 并插入到比它小的前面 O(n^2)
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

    //插入 
    public void InsertSort1(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while(j>0 && nums[j] < nums[j-1]) {
                nums[j] = nums[j-1];
                j--;
            }
            if(j != i) nums[j] = nums[i];
        }
    }
    
    //快排 选出基点,大小部分递归 O(n log n)， 
    //最坏情况：每次划分都将序列分成长度为 $n-1$ 和 1 的两个子序列 O(n^2)
    public int[] QuickSort(int[] nums, int left, int right){
        if(left < right) {
            int p = selectPoint(nums,left,right);
            QuickSort(nums,left,p - 1);
            QuickSort(nums,p + 1, right);
        }
        return nums;
    }
    //选出基点
    private int selectPoint(int[] nums, int left, int right){
        int temp = nums[left];
        while(left < right) {
            while(left < right && nums[right] >= temp) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= temp) left++;
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
    
    //归并排序 递归折半后，然后合并时做排序 O(n log n)
    public void mergeSort(int[] nums,int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) /2;
        mergeSort(nums,left, mid);
        mergeSort(nums,mid+1, right);
        merge(nums,left,mid,right);
    }
    private void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=right) {
            if(arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            res[k++] = arr[i++];
        }
        while(j <= right) {
            res[k++] = arr[j++];
        }
        for(int p = 0; p < res.length; p++) {
            arr[left+p] = res[p];
        }
    }

    //堆排序 O(n log n)
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

    //希尔排序 O(n log n) ~ O(n^2)
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