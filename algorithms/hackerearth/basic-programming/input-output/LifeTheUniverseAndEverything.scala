import java.util.Scanner

object LifeTheUniverseAndEverything {
  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)

    while (scanner.hasNextInt()) {
      val num = scanner.nextInt()

      if (num == 42) {
        return
      }

      println(num)
    }
  }
}
