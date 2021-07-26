/*
 * @Author: Tungbo
 * @Date: 2021-07-05 18:25:00
 * @LastEditTime: 2021-07-05 18:25:29
 * @LastEditors: Tungbo
 * @Description: leecode: 打印从1到最大的n位数
 */
public class printNumbers{
    public int[] printNumbers1(int n) {
        int[] res = new int[(int)Math.pow(10,n)-1];
         for(int i =0;i<res.length;i++) {
             res[i] = i+1;
         }
        return res;
    }
}