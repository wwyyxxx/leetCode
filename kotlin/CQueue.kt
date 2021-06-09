/*
 * @Author: Tungbo
 * @Date: 2021-06-09 15:24:18
 * @LastEditTime: 2021-06-09 16:09:31
 * @LastEditors: Tungbo
 * @Description: leecode: 双栈实现队列
 */
class CQueue() {
    
    var stack2 = LinkedList<Int>()
    var stack1 = LinkedList<Int>()

    fun appendTail(value: Int){
        stack1.add(value)
    } 

    fun deleteHead(){
        if(stack2.isEmpty()) {
            if(stack1.isEmpty()) return -1
            while(!stack1.isEmpty()) {
                stack2.add(stack1.pop())
            }
            return stack2.pop()
        } else return stack2.pop()
    }
}