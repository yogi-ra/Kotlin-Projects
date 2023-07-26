import java.util.Base64
import java.lang.System

fun main() {
  while (true) {
    println("Enter text to encode or decode: ")
    val input = readLine() ?: continue

    println("Do you want to encode or decode? (e/d/exit)")
    val action = readLine() ?: continue

    when (action) {
      "e" -> {
        println("The encoded text is: ${Base64.getEncoder().encodeToString(input.toByteArray())}")
      }
      "d" -> {
        println("The decoded text is: ${String(Base64.getDecoder().decode(input))}")
      }
      "exit" -> {
        System.exit(1)
      }
      else -> {
        println("Invalid input.")
      }
    }
  }
}
