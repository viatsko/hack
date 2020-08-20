import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    val d = scanner.nextInt()

    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[(i + n - d) % n] = scanner.nextInt()
    }

    println(arr.joinToString(" "))
}
