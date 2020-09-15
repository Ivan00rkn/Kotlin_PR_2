/*В задании №3 первой практической работы реализуйте следующее:
выделите основной алгоритм в отдельную функцию,
куда в качестве аргумента передавайте lambda,
имеющую смысл – способ сравнения двух чисел;
изменяя данную lambda, пользователь вашей функции
должен иметь возможность получить информацию либо о самых длинных,
либо о самых коротких словах.
Аналогичным образом передавайте в вашу функцию lambda,
которая будет определять условие отбора слов.*/

fun main() {

    fun mainAlgoritm(input: String, comparison: (length: Int, wordLength: Int) -> Boolean, condition: (wordLength: Int) -> Boolean): Char {
        var word = ""
        var resultChar = ' '
        var length = 0
        var idx = 0

        for (letter in input) {
            if (letter != ' ') {
                word += letter
            }
            // TODO add condition for check last word
            if (letter == ' ') {
                if (condition(word.length)) {
                    if (comparison(length, word.length)) {
                        length = word.length
                        resultChar = word[0]
                    }
                }
                word = ""
            }
            idx++
        }


        return resultChar
    }


    println("Введите строку")
    val input: String? = readLine()

    if (input !== null)  {
        val result = mainAlgoritm(input, {length, wordLength -> length > wordLength || length == 0}, {wordLength -> wordLength % 2 != 0})
        if (result != ' ') println("Результат: $result") else println("Нет ни одного слова с нечётным количеством символов")
    }
    else println("Ошибка ввода!")

}