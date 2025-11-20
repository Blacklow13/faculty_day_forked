package ru.tbank.education.school.lesson2.homework
import java.util.*


abstract class ClassesDescriptions {
    abstract val width: Double
    abstract val height: Double
    abstract var speed: Int
    abstract val description: String
    abstract val type: String
    abstract val base_hp: Double
    abstract val base_def: Double
    abstract val base_atk: Double

    abstract fun choose_move(User: Pokemon, Target: Pokemon)

}

class BulbasaurDescription : ClassesDescriptions(){
    override val base_atk: Double = 49.0
    override val type: String = "grass"
    override var speed: Int = 45
    override val width: Double = 1.0
    override val height: Double = 1.0
    override val description: String = """
        sSS
        
    """.trimIndent()
    override val base_hp: Double = 45.0
    override val base_def: Double = 49.0
    val firstMove: Tackle = Tackle()
    val secondMove: VineWhip = VineWhip()

    override fun choose_move(User: Pokemon, Target: Pokemon){
        val scanner = Scanner(System.`in`)
        println("""
            Choose move and enter num 1-2:
            Tackle | Vine Whip 
        """.trimIndent())
        val move: String = scanner.nextLine()
        when (move){
            "1" -> firstMove.use_movement(User, Target)
            "2" -> secondMove.use_movement(User, Target)
        }

    }
}

class CharmanderDescription() : ClassesDescriptions(){
    override val base_atk: Double = 52.0
    override var speed: Int = 65
    override val type: String = "fire"
    override val width: Double = 1.0
    override val height: Double = 1.0
    override val description: String = """
        sSS
        
    """.trimIndent()
    override val base_hp: Double = 39.0
    override val base_def: Double = 43.0
    val firstMove: Tackle = Tackle()
    val secondMove: Ember = Ember()

    override fun choose_move(User: Pokemon, Target: Pokemon){
        val scanner = Scanner(System.`in`)
        println("""
            Choose move and enter num 1-2:
            Tackle | Ember 
        """.trimIndent())
        val move: String = scanner.nextLine()
        when (move){
            "1" -> firstMove.use_movement(User, Target)
            "2" -> secondMove.use_movement(User, Target)
        }

    }
}

class SquirtleDescription : ClassesDescriptions(){
    override val base_atk: Double = 48.0
    override var speed: Int = 43
    override val type: String = "water"
    override val width: Double = 1.0
    override val height: Double = 1.0
    override val description: String = """
        sSS
        
    """.trimIndent()
    override val base_hp: Double = 44.0
    override val base_def: Double = 65.0
    val firstMove: Tackle = Tackle()
    val secondMove: WaterGun = WaterGun()

    override fun choose_move(User: Pokemon, Target: Pokemon){
        val scanner = Scanner(System.`in`)
        println("""
            Choose move and enter num 1-2:
            Tackle | Water Gun 
        """.trimIndent())
        val move: String = scanner.nextLine()
        when (move){
            "1" -> firstMove.use_movement(User, Target)
            "2" -> secondMove.use_movement(User, Target)
        }

    }
}