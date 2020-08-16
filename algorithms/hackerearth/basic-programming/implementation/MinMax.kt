import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextInt()

    val set = HashSet<Int>()

    var min = Int.MAX_VALUE

    var max = Int.MIN_VALUE

    for (i in 0 until n) {
        val num = scanner.nextInt()

        min = Math.min(min, num)

        max = Math.max(max, num)

        set.add(num)
    }

    set.remove(min)
    set.remove(max)

    if (min != Int.MAX_VALUE && max != Int.MIN_VALUE && set.size == (max - min - 1)) {
        println("YES")
    } else {
        println("NO")
    }
}
