/*
 * @Author: Tungbo
 * @Date: 2021-06-15 11:20:06
 * @LastEditTime: 2021-06-15 14:46:43
 * @LastEditors: Tungbo
 * @Description: leecode: 旋转数组的最小数字
 */
fun main(args: Array<String>) {
}
fun minArray(numbers: IntArray): Int {
    var low = 0
    var high = numbers.size -1
    while(low<high) {
        var pov = low + (high-low) / 2
        if(numbers[pov] < numbers[high]) {
            high = pov
        } else if(numbers[pov] > numbers[high]) {
            low = pov + 1
        } else {
            high = high-1
        }
    }
    return numbers[low]
}