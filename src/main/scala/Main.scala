import scala.annotation.tailrec

object Main {

  def solution(input: Array[Int]): Int = {
    @tailrec
    def sol(current: Int, input: Array[Int], counter: Int): Int =
      if (input.isEmpty) counter
      else if (current > input.head) sol(input.head, input.tail, counter)
      else sol(input.head, input.tail, counter + 1)

    sol(input.head, input.tail, 0)
  }


  def main(args: Array[String]): Unit = {
    val input = Input.test.split("\n").map(s => s.toInt)
    println(solution(input) == Input.result)
    println(solution(input))
  }
}
