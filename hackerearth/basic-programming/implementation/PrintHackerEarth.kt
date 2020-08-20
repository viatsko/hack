import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    val string = scanner.next()

    val chars = IntArray(256)

    for (i in 0 until string.length) {
        chars[string[i].toInt()]++
    }

    var count = 0

    // h
    // a 2
    // c
    // k
    // e 2
    // r 2
    // t
    // h

    while (true) {
        if (
            chars['h'] < 2 ||
            chars['a'] < 2 ||
            chars['c'] < 1 ||
            chars['k'] < 1 ||
            chars['e'] < 2 ||
            chars['r'] < 2 ||
            chars['t'] < 1
        ) {
            break
        } else {
            chars['h'] -= 2
            chars['a'] -= 2
            chars['c']--
            chars['k']--
            chars['e'] -= 2
            chars['r'] -= 2
            chars['t']--

            count++
        }
    }

    println(count)
}

private operator fun IntArray.set(c: Char, value: Int) {
    this[c.toInt()] = value
}

private operator fun IntArray.get(c: Char): Int {
    return this[c.toInt()]
}
