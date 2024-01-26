package _2020

import java.io.File
import java.io.InputStream

object DayOne {

    private fun getDataFromFile(): List<Int> {
        val listOfValue = mutableListOf<Int>()
        val inputStream: InputStream = File("dayOne.txt").inputStream()
        inputStream.bufferedReader().use { reader ->
            reader.readLines().forEach { line ->
                listOfValue.add(line.toInt())
            }
        }
        println(listOfValue)
        return listOfValue
    }

    private val input = getDataFromFile()

    fun partOne() {
        input.forEachIndexed { index1, number1 ->
            input.forEachIndexed() { index2, number2 ->
                if (number1 + number2 == 2020 && index1 != index2) {
                    println(number2 * number1)
                }
            }
        }
    }

    fun partTwo() {
        input.forEach { number1 ->
            input.forEach { number2 ->
                input.forEach { number3 ->
                    if (number1 + number2 + number3 == 2020) {
                        println(number1 * number2 * number3)
                    }
                }
            }
        }
    }
}