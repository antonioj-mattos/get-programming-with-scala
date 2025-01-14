package quickchecks

import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should

// Continuation from file src/main/scala/quickchecks/QuickCheck-52.2.scala

class QuickCheck_52_2_FrequencyTest extends AsyncFlatSpec with should.Matchers {
   import QuickCheck_52_2.Frequency // using the Frequency implementation from QuickCheck-52.2

   val frequency = new Frequency

  "Frequency" should "count no frequency for the empty string" in {
    val result = frequency.count("")
    result.shouldEqual(Set.empty)
  }

  it should "count the frequency of the characters in a text" in {
    val result = frequency.count("test")
    val expected = Set('t' -> 2, 'e' -> 1, 's' -> 1)
    result.shouldEqual(expected)
  }

  it should "asynchronously count characters from a file" in {
    val filename = getClass.getResource("/myFile.txt").getPath
    val result = frequency.countFromFile(filename)
    val expected = Set('t' -> 2, 'e' -> 1, 's' -> 1)
    result.map(_.shouldEqual(expected))
  }

  it should "return the empty set if the file does not exist" in {
    val result = frequency.countFromFile("I-do-not-exist.txt")
    result.map(_.shouldEqual(Set.empty))
  }
 }
