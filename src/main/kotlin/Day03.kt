fun main() {
    val reportLines = readLines("Day03.txt")

    val reportListNumbers = reportLines.map { line -> line.chunked(1).map { it.toInt() } }

    val result1 = part1(reportListNumbers)
    println(result1)
}

fun part1(reportListNumbers: List<List<Int>>): Int {
    val totalEntriesInReport = reportListNumbers.size

    val gammaRateArray = mutableListOf<Char>()

    reportListNumbers.reduce { sum, other ->
        sum.zip(other, Int::plus)
    }.forEach {
        if (it > totalEntriesInReport / 2) {
            gammaRateArray.add('1')
        } else {
            gammaRateArray.add('0')
        }
    }

    val epsilonRateArray = gammaRateArray.reverseBinaryChar()

    val gammaRate = Integer.parseInt(gammaRateArray.fold("", String::plus), 2)
    val epsilonRate = Integer.parseInt(epsilonRateArray.fold("", String::plus), 2)

    return gammaRate * epsilonRate
}

private fun List<Char>.reverseBinaryChar() = this.map {
    when (it) {
        '1' -> 0
        else -> 1
    }
}
