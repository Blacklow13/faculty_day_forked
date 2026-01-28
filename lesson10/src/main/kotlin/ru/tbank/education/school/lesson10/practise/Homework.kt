package ru.tbank.education.school.lesson10.practise

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.Period
import java.time.Period.*
import java.time.format.DateTimeFormatter
import kotlin.time.Duration
import kotlin.Int

fun main(){
    val logs = listOf(
        "2026-01-22 09:14 | ID:042 | STATUS:sent",
        "TS=22/01/2026-09:27; status=delivered; #042",
        "2026-01-22 09:10 | ID:043 | STATUS:sent",
        "2026-01-22 09:18 | ID:043 | STATUS:delivered",
        "TS=22/01/2026-09:05; status=sent; #044",
        "[22.01.2026 09:40] delivered (id:044)",
        "2026-01-22 09:20 | ID:045 | STATUS:sent",
        "[22.01.2026 09:33] delivered (id:045)",
        "   ts=22/01/2026-09:50; STATUS=Sent; #046   ",
        " [22.01.2026 10:05]   DELIVERED   (ID:046) "
    )

    var e: MutableList<MutableMap<String, String>> = mutableListOf()
    var brokenStrings : MutableList<String> = mutableListOf()

    logs.forEach {
            var reDt = listOf(Regex("""\s*(\d{4})-(\d{2})-(\d{2})\s*(\d{2}):(\d{2})\s*\|\s*id:(\d{3})\s*\|\s*status:(\w*)\s*"""), Regex("""\s*ts=(\d{2})/(\d{2})/(\d{4})-(\d{2}):(\d{2});\s*status=(\w*);\s*#(\d{3})\s*"""), Regex("""\s*\[(\d{2}).(\d{2}).(\d{4})\s*(\d{2}):(\d{2})\]\s*(\w*)\s*\(id:(\d{3})\)"""))
            if (reDt[0].find(it.lowercase()) != null){
                var intDate = reDt[0].find(it.lowercase())?.groupValues
                var date = LocalDateTime.of(intDate!![1]?.toIntOrNull() ?: 0, intDate!![2]?.toIntOrNull() ?: 0, intDate!![3]?.toIntOrNull() ?: 0, intDate!![4]?.toIntOrNull() ?: 0, intDate!![5]?.toIntOrNull() ?: 0)
                var d = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                var log: MutableMap<String, String> = mutableMapOf("dt" to d, "id" to intDate!![6]?.toIntOrNull().toString(), "status" to intDate!![7].lowercase())
                e.add(log)

            }
            else if (reDt[1].find(it.lowercase()) != null){
                var intDate = reDt[1].find(it.lowercase())?.groupValues
                var date = LocalDateTime.of(intDate!![3]?.toIntOrNull() ?: 0, intDate!![2]?.toIntOrNull() ?: 0, intDate!![1]?.toIntOrNull() ?: 0, intDate!![4]?.toIntOrNull() ?: 0, intDate!![5]?.toIntOrNull() ?: 0)
                var d = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                var log: MutableMap<String, String> = mutableMapOf("dt" to d, "id" to intDate!![7]?.toIntOrNull().toString(), "status" to intDate!![6].lowercase())
                e.add(log)

            }
            else if (reDt[2].find(it.lowercase()) != null){
                var intDate = reDt[2].find(it.lowercase())?.groupValues
                var date = LocalDateTime.of(intDate!![3]?.toIntOrNull() ?: 0, intDate!![2]?.toIntOrNull() ?: 0, intDate!![1]?.toIntOrNull() ?: 0, intDate!![4]?.toIntOrNull() ?: 0, intDate!![5]?.toIntOrNull() ?: 0)
                var d = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                var log: MutableMap<String, String> = mutableMapOf("dt" to d, "id" to intDate!![7]?.toIntOrNull().toString(), "status" to intDate!![6].lowercase())
                e.add(log)

            }else{
                println("${it} is broken")
                brokenStrings.add(it)
            }

        }
    println("normalized strings ${e}")
    println("broken strings ${brokenStrings}")

    var dataGroupedById : MutableMap<String, MutableList<Pair<String, LocalDate>>> = mutableMapOf()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    e.forEach {
        dataGroupedById[it!!["id"] as String] = dataGroupedById.getOrDefault(it!!["id"] as String, mutableListOf())
        dataGroupedById[it!!["id"] as String]!!.add(Pair("status=${it!!["status"] as String} time=${it!!["dt"]}",
            LocalDate.parse(it["dt"], formatter)))
        println(it)

    }
    println(dataGroupedById)


}