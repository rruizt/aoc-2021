fun main() {
    val numberList = readLinesNumbers("Day01.txt")

    val result1 = part1(numberList)
    val result2 = part2(numberList)

    println("Result1: $result1")
    println("Result2: $result2")
}

private fun part1(numbers: List<Int>): Int {
    var increases = 0
    var previous: Int? = null

    numbers.forEach { current ->
        previous?.let {
            if (current > it) {
                ++increases
            }
        }
        previous = current
    }

    return increases
}

private fun part2(numbers: List<Int>): Int {
    var increases = 0
    var previous: Int? = null

    numbers.asSequence().windowed(3).map { window ->
        window.sum()
    }.forEach { current ->
        previous?.let {
            if (current > it) {
                ++increases
            }
        }
        previous = current
    }

    return increases
}
