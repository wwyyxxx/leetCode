import java.util.Arrays;

/*
 * @Author: Tungbo
 * @Date: 2022-08-24 10:43:06
 * @LastEditTime: 2022-08-24 10:44:10
 * @LastEditors: Tungbo
 * @Description: leecode: 1460. 通过翻转子数组使两个数组相等
 * 
 * 给你两个长度相同的整数数组 target 和 arr 。每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次
 * 如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False
 * 
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
