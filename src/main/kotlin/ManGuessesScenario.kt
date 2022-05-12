import kotlin.system.exitProcess

class ManGuessesScenario {
    private var userNumber = 0
    private var numberAttempts = 0
    private val randomNumber = (0..100).random()
    fun start() {
        println("Начнем игру? (да/нет)")
        while (true) {
            when (readln()) {
                "да" -> {
                    println("Welcome to the club buddy")
                    println("Игра называется угадай число")
                    playGame()
                    break
                }
                "нет" -> {
                    println("Очень жаль, приходи еще")
                    exitProcess(0)
                }
                "101" -> exitProcess(2)
                else -> println("Нужно ввести да или нет")
            }
        }
    }

   private fun playGame() {
        println("Итак какое же число я загадал?")
        while (userNumber != randomNumber) {
            val number = readln()
            if(number == "101")
                exitProcess(2)
            if (!testingIsNumber(number))
                println("$number это не число")
            else
                userNumber = number.toInt()

            if (userNumber < randomNumber) {
                println("число больше")
                numberAttempts++
            }
            else if (userNumber > randomNumber) {
                println("число меньше")
                numberAttempts++
            } else {
                println("Ты угадал за $numberAttempts попыток, go suck something dick")
            }
        }
    }

   private fun testingIsNumber(string: String): Boolean {
        string.forEach {
            if(Character.isDigit(it).not()){
                return false
            }
        }
        return true
    }
}