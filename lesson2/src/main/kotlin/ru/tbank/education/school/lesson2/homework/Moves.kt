package ru.tbank.education.school.lesson2.homework


abstract class Move {
    abstract val description: String
    abstract fun use_movement(user: Pokemon, target: Pokemon)
}

open class DamageMove: Move(){
    open val power: Int = 30
    override val description = "This move hits with power${power}"
    override fun use_movement(user: Pokemon, target: Pokemon) {
        target.hp -= power * (user.atk) / target.def
    }
}

class Tackle: DamageMove(){
    override val power: Int = 35

}

class WaterGun: DamageMove(){
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "fire")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "grass"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }else{
            super.use_movement(user, target)
        }
    }
}

class VineWhip: DamageMove(){
    override val power: Int = 35
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "water")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "fire"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }else{
            super.use_movement(user, target)
        }
    }
}

class Ember: DamageMove(){
    override fun use_movement(user: Pokemon, target: Pokemon) {
        if (target.type == "grass")
            target.hp -= power * (user.atk) / target.def * 2
        else if (target.type == "water"){
            target.hp -= power * (user.atk) / target.def * 0.5
        }else{
            super.use_movement(user, target)
        }
    }
}
