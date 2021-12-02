fun main() {
    val instructions = readLines("Day02.txt")
        .map { instruction ->
            instruction.split(' ').let {
                Pair(it[0], it[1].toInt())
            }
        }

    val result1 = part1(instructions)
    val result2 = part2(instructions)

    println("Result1: $result1")
    println("Result2: $result2")
}

private fun part1(instructions: List<Pair<String, Int>>): Int {
    var horizontalPos = 0
    var depth = 0

    instructions.forEach {
        when (it.first) {
            "forward" -> horizontalPos += it.second
            "down" -> depth += it.second
            "up" -> depth -= it.second
        }
    }

    return horizontalPos * depth
}

private fun part2(instructions: List<Pair<String, Int>>): Int {
    var horizontalPos = 0
    var depth = 0
    var aim = 0

    instructions.forEach {
        when (it.first) {
            "forward" -> {
                horizontalPos += it.second
                depth += it.second * aim
            }
            "down" -> aim += it.second
            "up" -> aim -= it.second
        }
    }

    return horizontalPos * depth
}