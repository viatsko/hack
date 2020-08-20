import java.util.Scanner

object Cipher {
  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)

    val string = scanner.next()
    val k = scanner.nextInt()

    val chars = string.toCharArray

    for (i <- 0 until chars.length) {
      val ch = chars(i)

      if (ch >= 'a' && ch <= 'z') {
        chars(i) = ('a'.toInt + (ch.toInt - 'a'.toInt + k) % 26).toChar
      } else if (ch >= 'A' && ch <= 'Z') {
        chars(i) = ('A'.toInt + (ch.toInt - 'A'.toInt + k) % 26).toChar
      } else if (ch >= '0' && ch <= '9') {
        chars(i) = ('0'.toInt + (ch.toInt - '0'.toInt + k) % 10).toChar
      }
    }

    println(chars.mkString)
  }
}
