class moveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) {
            return
        }
        var j = 0
        for ((index,e) in nums.withIndex()) {
            if (e!=0) {
                if (j<index) {
                    nums[j] = e
                    nums[index] = 0
                }
                j++
            }
        }
    }
}