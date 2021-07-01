/*
 * @Author: Tungbo
 * @Date: 2021-06-30 17:01:09
 * @LastEditTime: 2021-07-01 11:29:06
 * @LastEditors: Tungbo
 * @Description: leecode: 剪绳子
 */
fun main(args: Array<String>) {
    println()
}
fun CuttingRope(n:Int) :Int {
    if(n<=3) return n-1;
    var result = 1
    while(n<=3) {
        result *= 3
        n = n%3
    }
    return if (n!=0) result * n else result
}