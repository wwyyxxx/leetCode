/*
 * @Author: Tungbo
 * @Date: 2021-06-10 14:35:57
 * @LastEditTime: 2021-06-10 15:21:36
 * @LastEditors: Tungbo
 * @Description: leecode: 查找重复数
 */
fun main(args: Array<String>) {
    println(findRepeatNumber(5))
}
fun findRepeatNumber(nums: IntArray): Int {
    val set = HashSet<Int>()
    nums.forEach { 
        if (!set.add(it)) {
            return it
        }
    }
    return 0
}
fun findRepeatNumber2(nums: IntArray): Int {
    var temp = arrayOfNulls<Int>(nums.size)
    nums.forEach {
        if (temp.contains(it)) return it
        temp[it] = it
    }
    return -1
}
fun findRepeatNumber3(nums: IntArray): Int {
    var i = 0
    while (i < nums.size) {
        if (nums[i] == i) {
            i++
            continue
        }
        if (nums[nums[i]] = nums[i]) return nums[i]
        var temp = nums[i]
        nums[i] = nums[nums[i]]
        nums[nums[i]] = temp
    }
    
}