import java.io.File

object DayThree {

    private fun getDataFromFile(): List<String> {
        return File("./data/dayThree.txt").readLines()
    }

    private val data = getDataFromFile()

    fun partOne() {
        var trees = 0
        val width = data[0].length
        for (y in data.indices) {
            if (data[y][y * 3 % width] == '#') trees++
        }
        println(trees)
    }

    fun partTwo() {
        var multiplyValue: Long = 1
        val slopes = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))

        fun eachSlope(slopeX: Int, slopeY: Int): Int {
            var trees = 0
            val width = data[0].length
            for (y in data.indices) {
                if ((y % slopeY == 0) and (data[y][y / slopeY * slopeX % width] == '#')) trees++
            }
            return trees
        }
        slopes.forEach {
            multiplyValue *= eachSlope(it.first, it.second)
        }
        println(multiplyValue)
    }
}