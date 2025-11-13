package ru.tbank.education.school.lesson1

/**
 * Сумма четных чисел.
 */
fun sumEvenNumbers(numbers: Array<Int>) = numbers.filter{it % 2 == 0}.sum()

fun main(){
    val array = arrayOf(1, 2, 3, 4, 6)
    println(sumEvenNumbers(array))
}