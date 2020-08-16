import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    var q = scanner.nextInt()

    val arr = IntArray(n)

    for (i in 0 until n) {
        arr[i] = scanner.nextInt()
    }

    while (q-- > 0) {
        val op = scanner.nextInt()

        val x = scanner.nextInt()

        val y = scanner.nextInt()

        if (op == 1) {
            arr[x] = y
        } else {
            println((x..y).sumBy { arr[it] })
        }
    }
}
