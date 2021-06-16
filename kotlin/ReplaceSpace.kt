/*
 * @Author: Tungbo
 * @Date: 2021-06-16 15:05:32
 * @LastEditTime: 2021-06-16 15:30:16
 * @LastEditors: Tungbo
 * @Description: leecode: 替换空格
 */
fun main(args: Array<String>) {
    println(replaceSpace("wyx jjj"))
}
fun replaceSpace(s: String): String {
    val result:CharArray = CharArray(s.length * 3)
    var index = 0
    var i = 0
    while (index<s.length) {
        if (s[index] == ' ') {
            result[i++] = '%'
            result[i++] = '2'
            result[i++] = '0'
        } else {
            result[i++] = s[index]
        }
        index++
    }
    return String(result,0,i)
}