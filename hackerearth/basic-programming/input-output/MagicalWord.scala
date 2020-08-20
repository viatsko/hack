import java.util.Scanner
import scala.util.control.Breaks._

object MagicalWord {
  def main(args: Array[String]) {
    val primes = Array(67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113)

    val scanner = new Scanner(System.in)

    val t = scanner.nextInt()

    for (j <- 0 until t) {
      val n = scanner.nextInt()

      val string = scanner.next()

      val l = string.length()

      val result = new Array[Char](n)

      for (i <- 0 until l) {
        val ch = string.charAt(i)

        if (primes.contains(ch)) {
          result(i) = ch
        } else if (ch < 67) {
          result(i) = 67
        } else if (ch > 113) {
          result(i) = 113
        } else {
          var index = 0

          breakable {
            for (k <- primes.indices) {
              if (primes(k) > ch) {
                index = k
                break
              }
            }
          }

          val cur = primes(index)
          val next = primes(index - 1)

          if ((ch - cur) <= (next - ch)) {
            result(i) = next.toChar
          } else {
            result(i) = cur.toChar
          }
        }
      }

      println(result.mkString)
    }
  }
}
