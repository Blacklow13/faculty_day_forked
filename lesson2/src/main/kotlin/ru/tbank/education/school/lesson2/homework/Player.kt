package ru.tbank.education.school.lesson2.homework
import java.util.Scanner;


data class Player(val _name: String, val _pokClass: String, val _pokemonName: String ) {
    val name: String = _name
    val pokemon: Pokemon = Pokemon(_pokClass, _pokemonName)
    fun make_a_move(User: Pokemon, Target: Pokemon){
        pokemon.choose_move(User, Target)

    }
}

fun main(){
    val p = Pokemon("2", "dad")
}