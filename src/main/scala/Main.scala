
import scala.annotation.tailrec

case class Triplet(lst: Array[Int])

object Main {

  def triple(input: Array[Int], triplets: Array[Triplet] = Array()): Array[Triplet] =
    if (input.take(3).length < 3) triplets
    else triple(input.tail, triplets.appended(Triplet(input.take(3))))

  def solution(input: Array[Int]): Int = {
    @tailrec
    def sol(current: Int, input: Array[Int], counter: Int): Int =
      if (input.isEmpty) counter
      else if (current >= input.head) sol(input.head, input.tail, counter)
      else sol(input.head, input.tail, counter + 1)

    val triplets = triple(input).map(l => l.lst.sum)
    sol(triplets.head, triplets.tail, 0)
  }


  def main(args: Array[String]): Unit = {
    val input = Input.test.split("\n").map(s => s.toInt)
    println(solution(input) == Input.result)
    println(solution(input))
  }
}
