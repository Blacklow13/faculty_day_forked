package ru.tbank.education.school.lesson2.homework

class Pokemon(_pokClass: String) {
    val pokClass: String = _pokClass
    var name: String = ""
    var speed: Int = 0
    var type: String = ""
    var hp: Double = 0.0
    var base_hp: Double = 0.0
    var atk: Double = 0.0
    var def: Double = 0.0
    var description: String = ""

    var choose_move: (Pokemon, Pokemon) -> Unit =  {a, b -> a}
    constructor(_pokClass: String, _name: String): this(_pokClass){
        name = _name
        when (pokClass){
            "1" -> {
                val desc = CharmanderDescription()
                type = desc.type
                hp = desc.base_hp
                base_hp = desc.base_hp
                atk = desc.base_atk
                def = desc.base_def
                description = desc.description
                choose_move = {User: Pokemon, Target: Pokemon -> desc.choose_move(User, Target)}
            }
            "2" -> {
                val desc = BulbasaurDescription()
                type = desc.type
                base_hp = desc.base_hp
                hp = desc.base_hp
                atk = desc.base_atk
                def = desc.base_def
                description = desc.description
                choose_move = {User: Pokemon, Target: Pokemon -> desc.choose_move(User, Target)}
            }
            "3" -> {
                val desc = SquirtleDescription()
                type = desc.type
                base_hp = desc.base_hp
                hp = desc.base_hp
                atk = desc.base_atk
                def = desc.base_def
                description = desc.description
                choose_move = {User: Pokemon, Target: Pokemon -> desc.choose_move(User, Target)}

            }
            else -> {}



        }




    }

    fun get_info(){
        println(description)
    }


}
