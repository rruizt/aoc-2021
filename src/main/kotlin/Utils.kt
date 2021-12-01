import java.io.File

internal fun readLinesNumbers(filename: String) = File("src/main/resources", filename).readLines().map { it.toInt() }