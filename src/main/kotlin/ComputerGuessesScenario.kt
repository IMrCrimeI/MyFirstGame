import kotlin.system.exitProcess

class ComputerGuessesScenario {
    private var randomNumber = (0..100).random()
    fun start() {
        println("Теперь моя очередь, загадывай число, а я попробую его отгадать, загадал?(да/нет)")
        while (true) {
            when (readln()) {
                "да" -> {
                    println("Хорошо мы начинаем")
                    playGame()
                    break
                }
                "нет" -> println("Хорошо я подожду")
                "101" -> exitProcess(2)
                else -> println("Нужно ввести да или нет, я же не искусственный интеллект и не могу общаться")
            }
        }
    }


    private fun playGame() {
        var numberMax = 100
        var numberMin = 0
        println("Твое число $randomNumber (1-больше/2-меньше/3-правильно)")
        while (true) {
            when (readln()) {
                "1" -> {
                    if (numberMax == randomNumber + 1) {
                        println("Обманул меня, начинаем заново")
                        numberMin = 0
                        numberMax = 100
                        println("$randomNumber")
                    } else {
                        numberMin = randomNumber
                        randomNumber = (numberMin until numberMax).random()
                        println("Твое число $randomNumber")
                    }
                }
                "2" -> {
                    if (numberMin == randomNumber) {
                        println("Обманул меня, начинаем заново")
                        numberMin = 0
                        numberMax = 100
                        println("$randomNumber")
                    } else {
                        numberMax = randomNumber
                        randomNumber = (numberMin until numberMax).random()
                        println("Твое число $randomNumber")
                    }
                }
                "3" -> {
                    println("Я машина, а ты нет :р")
                    break
                }

                "101" -> exitProcess(2)

                else -> println("я тебя не понимаю, попробуй еще раз")
            }
        }
    }
}