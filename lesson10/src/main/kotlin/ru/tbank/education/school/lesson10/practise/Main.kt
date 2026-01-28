import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.Period
import java.time.Period.*
import java.time.format.DateTimeFormatter
import kotlin.time.Duration
import kotlin.Int

fun main() {
    task1()
    println()
    task2()
    println()
    task3()
    println()
    task4()
    task5()
    task6()
    task7()
    task8()
}

/*
1) Строки + регулярные выражения
["Name: Ivan, score=17", ...]
Извлечь имя и score, собрать пары, вывести победителя.
*/
fun task1() {
    val lines = listOf(
        "Name: Ivan, score=17",
        "Name: Olga, score=23",
        "Name: Max, score=5"
    )

    val re = Regex("""^Name:\s*([A-Za-z]+)\s*,\s*score=(\d+)\s*$""")

    val pairs: List<Pair<String, Int>> = lines.mapNotNull { s ->
        val m = re.find(s) ?: return@mapNotNull null
        val name = m.groupValues[1]
        val score = m.groupValues[2].toInt()
        name to score
    }

    println("Task 1 pairs: $pairs")

    val best = pairs.maxByOrNull { it.second }
    if (best != null) {
        println("Task 1 best: ${best.first} (${best.second})")
    } else {
        println("Task 1: no valid lines")
    }
}

/*
2) Даты + коллекции
["2026-01-22", ...]
Преобразовать в даты, отсортировать, посчитать сколько в январе 2026.
*/
fun task2() {
    val dateStrings = listOf(
        "2026-01-22",
        "2026-02-01",
        "2025-12-31",
        "2026-01-05"
    )

    val fmt = DateTimeFormatter.ISO_LOCAL_DATE

    val dates = dateStrings.map { LocalDate.parse(it, fmt) }.sorted()

    println("Task 2 sorted dates: ${dates.joinToString { it.format(fmt) }}")

    val countJan2026 = dates.count { it.year == 2026 && it.month == Month.JANUARY }
    println("Task 2 count in Jan 2026: $countJan2026")
}

/*
3) Коллекции + строки
"apple orange apple banana orange apple"
Частоты слов, вывести слова с частотой > 1 по алфавиту.
*/
fun task3() {
    val text = "apple orange apple banana orange apple"

    val words = text.trim().split(Regex("""\s+""")).filter { it.isNotEmpty() }

    val freq = mutableMapOf<String, Int>()
    for (w in words) {
        freq[w] = (freq[w] ?: 0) + 1
    }

    println("Task 3 freq: $freq")

    val repeated = freq
        .filter { (_, c) -> c > 1 }
        .keys
        .sorted()

    println("Task 3 repeated words: ${repeated.joinToString(", ")}")
}

fun task4(){
    var a = listOf("A-123", "B-7", "AA-12", "C-001", "D-99x")
    val re = Regex("""^([A-Z]{1})-(\d{1,3})$""")
    a = a.filter{i -> re.matches(i )
    }
    println(a);

}

fun task5(){
    var a = listOf("  Hello   world  ", "A   B    C", "   one")
    a = a.map { i -> i.trim().split(" ").filter { it -> it != "" }.joinToString(" ") }
    println(a)

}

fun task6(){
    var a = listOf(listOf("2026-01-01","2026-01-10"), listOf("2025-12-31","2026-01-01"), listOf("2026-02-01","2026-01-22"))
    var dur = a.map{it ->
        it.map{ i -> LocalDate.parse(i) }
    }
    var an : List<Int> = dur.map{ it -> (Period.between(it[0], it[1])).days }
    println(an)
}


fun task7(){
    var a = listOf("math:Ivan", "bio:Olga", "math:Max", "bio:Ivan", "cs:Olga")
    var b : MutableMap<String, MutableList<String>> = mutableMapOf()
    var i = 0;

    for (i in 0..a.size - 1){
        val el = a[i].split(":")
        b[el[0]] = b.getOrDefault(el[0], mutableListOf())
        b[el[0]]!!.add(el[1])
    }
    println(b)
}

fun task8(){
    var s = listOf("Start at 2026/01/22 09:14", "No time here", "End: 22-01-2026 18:05")
    var e : MutableList<String> = mutableListOf()
    s.forEach {
        var re = Regex(""".*(\d{4})/(\d{2})/(\d{2}).*(\d{2}):(\d{2})""")
        if (Regex(""".*(\d{4})/(\d{2})/(\d{2}).*(\d{2}):(\d{2})""").find(it) != null){
            var intDate = Regex(""".*(\d{4})/(\d{2})/(\d{2}).*(\d{2}):(\d{2})""").find(it)?.groupValues
            var date = LocalDateTime.of(intDate!![1]?.toIntOrNull() ?: 0, intDate!![2]?.toIntOrNull() ?: 0, intDate!![3]?.toIntOrNull() ?: 0, intDate!![4]?.toIntOrNull() ?: 0, intDate!![5]?.toIntOrNull() ?: 0)
            var d = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            e.add(d)
        }
        else if (Regex(""".*(\d{2})-(\d{2})-(\d{4}).*(\d{2}):(\d{2})""").find(it) != null){
            var intDate = Regex(""".*(\d{2})-(\d{2})-(\d{4}).*(\d{2}):(\d{2})""").find(it)?.groupValues
            var date = LocalDateTime.of(intDate!![3]?.toIntOrNull() ?: 0, intDate!![2]?.toIntOrNull() ?: 0, intDate!![1]?.toIntOrNull() ?: 0, intDate!![4]?.toIntOrNull() ?: 0, intDate!![5]?.toIntOrNull() ?: 0)
            var d = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            e.add(d)
        }

    }
    println(e)



}





