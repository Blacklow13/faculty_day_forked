package ru.tbank.education.school.lesson2.homework
import java.util.Scanner;



class Dispatcher(val Player1: Player, val Player2: Player) {
    fun game(){
        while (Player1.pokemon.hp > 0 && Player2.pokemon.hp > 0){
            println("done")
            if (Player1.pokemon.speed > Player2.pokemon.speed){
                println("${Player1.name}'s turn")
                displays_hp()
                Player1.make_a_move(Player1.pokemon, Player2.pokemon)
                displays_hp()
                if (Player2.pokemon.hp > 0){
                    println("${Player2.name}'s turn")
                    displays_hp()
                    Player2.make_a_move(Player2.pokemon, Player1.pokemon)
                    displays_hp()
                    if (Player1.pokemon.hp <= 0){
                        game_end(Player2)
                    }
                }else{
                    game_end(Player1)
                }
            }else{
                println("${Player2.name}'s turn")
                displays_hp()
                Player2.make_a_move(Player2.pokemon, Player1.pokemon)
                displays_hp()
                if (Player1.pokemon.hp > 0){
                    println("${Player1.name}'s turn")
                    displays_hp()
                    Player1.make_a_move(Player1.pokemon, Player2.pokemon)
                    displays_hp()
                    if (Player2.pokemon.hp <= 0){
                        game_end(Player2)
                    }
                }else{
                    game_end(Player2)
                }
            }
        }
    }

    fun game_end(Winner: Player){
        println("${Winner.name} won in the game")
        println("Congrats to ${Winner.name}")
    }

    fun displays_hp(){
        if (Player1.pokemon.hp < 0){
            Player1.pokemon.hp = 0.0
        }
        if(Player2.pokemon.hp < 0){
            Player2.pokemon.hp = 0.0
        }
        println("${Player1.pokemon.name} - ${Player1.pokemon.hp}/${Player1.pokemon.get_base_hp()}")
        println("${Player2.pokemon.name} - ${Player2.pokemon.hp}/${Player2.pokemon.get_base_hp()}")
    }

}