import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val a = scanner.next()

    val b = scanner.next()

    val chars = IntArray(26)

    for (i in 0 until a.length) {
        chars[a[i] - 'a']++
    }

    for (i in 0 until b.length) {
        chars[b[i] - 'a']--
    }

    println(chars.sumBy { Math.abs(it) })
}
