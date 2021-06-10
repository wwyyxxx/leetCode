fun main(args: Array<String>) {
    println(fib2(5))
}
fun fib(n: Int): Int {
    if (n == 0 || n == 1) return n
    return fib(n-1) + fib(n-2)
}
fun fib2(n: Int): Int {
    if (n == 0 || n == 1) return n
    var a = 0
    var b = 1
    var sum = 0
    for (i in 0 until n) {
        println("i+$i")
        sum = (a + b) % 1000000007  // 1  2  3
        a = b                       // 1  1  2
        b = sum                     // 1  2  3
    }
    return a
}