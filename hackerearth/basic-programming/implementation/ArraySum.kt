import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    var n = scanner.nextInt()

    var sum: Long = 0

    while (n-- > 0) {
        sum += scanner.nextInt()
    }

    println(sum)
}
