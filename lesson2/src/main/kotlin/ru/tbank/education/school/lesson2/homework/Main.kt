package ru.tbank.education.school.lesson2.homework
import java.util.*

fun main(){
    println("First Player enter your name:")
    val scaner: Scanner = Scanner(System.`in`)
    val nameOfFirstPlayer: String = scaner.nextLine()
    println("""
    Choose your Pokemon and enter 1-3:
    Charmander | Bulbasaur | Squirtle
    """.trimIndent())
    val _firstpokClass: String = scaner.nextLine()
    println("""
        Enter name of your pokemon:
    """.trimIndent())
    val nameOfFirstPlayersPokemon: String = scaner.nextLine()
    println("Second Player enter your name:")
    val nameOfSecondPlayer: String = scaner.nextLine()
    println("""
    Choose your Pokemon and enter 1-3:
    Charmander | Bulbasaur | Squirtle
    """.trimIndent())
    val _secondpokClass: String = scaner.nextLine()
    println("""
    Enter name of your pokemon:
    """.trimIndent())
    val nameOfSecondPlayersPokemon: String = scaner.nextLine()
    val player1 = Player(nameOfFirstPlayer, _firstpokClass, nameOfFirstPlayersPokemon)
    val player2 = Player(nameOfSecondPlayer, _secondpokClass, nameOfSecondPlayersPokemon)
    val dispatcher = Dispatcher(player1, player2)
    dispatcher.game()

}