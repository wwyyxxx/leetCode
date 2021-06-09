/*
 * @Author: Tungbo
 * @Date: 2020-10-14 15:05:18
 * @LastEditTime: 2021-06-07 11:26:46
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
class findDisappearedNumbers {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (index in nums.indices) {
            val newIndex = Math.abs(nums[index]) - 1;
            if(nums[newIndex]>0)
                nums[newIndex] *= -1
        }
        val result : MutableList<Int> =ArrayList()
        for ((index,e) in nums.withIndex()) {
            if (e>0) {
                result.add(index+1)
            }
        }
        return result
    }
}