package ru.tbank.education.school.lesson2.homework


abstract class Move {
    abstract val description: String
    abstract fun use_movement(user: Pokemon, target: Pokemon)
}

class Tackle: Move(){
    val power: Int = 40
    override val description = ""
    override fun use_movement(user: Pokemon, target: Pokemon) {
        target.hp -= power * (user.atk) / target.def
    }
}
class WaterGun: Move(){
    val power: Int = 40
    override val description = ""
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "fire")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "grass"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }
    }
}

class VineWhip: Move(){
    val power: Int = 45
    override val description = ""
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "water")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "fire"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }
    }
}

class Ember: Move(){
    val power: Int = 40
    override val description = ""
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "grass")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "water"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }
    }
}
