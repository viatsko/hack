import java.io.{BufferedReader, InputStreamReader}

object PlayWithNumbers {
  def main(args: Array[String]) {
    val isr = new InputStreamReader(System.in)
    val br = new BufferedReader(isr)

    val input:Array[String] = br.readLine().split(" ")

    val n = input(0).toInt
    val q = input(1).toInt

    val arr = br.readLine().split(" ")

    val narr = new Array[Long](arr.length + 1)
    narr(0) = 0

    for (i <- 1 to arr.length) {
      narr(i) = narr(i - 1) + arr(i - 1).toLong
    }

    for (i <- 1 to q) {
      val input:Array[String] = br.readLine().split(" ")

      val l = input(0).toInt
      val r = input(1).toInt

      println((narr(r) - narr(l - 1)) / (r - l + 1))
    }
  }
}

