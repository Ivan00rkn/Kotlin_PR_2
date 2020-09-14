/*В программе, сделанной в задании №1,
вынесите проверяемое условие в
отдельную single-expression функцию.*/

fun main () {

    fun checkCondition(num: Char, max:Char):Boolean = num > max && num.toInt() % 2 == 0

    fun common (input: String): Char {
        var max = '0'
        for (num: Char in input) if (checkCondition(num, max)) max = num
        return  max
    }

    tailrec fun recursive(input: String, max: Char, n: Int = 0): Char = when {
        n == input.length - 1 -> max
        input.length == 1 -> input[0]
        checkCondition(input[n], max) -> recursive(input, input[n], n+1 )
        else -> recursive(input, max, n+1 )
    }

    println("Введите неотрицательное число и я найду максимальную чётную цифру: ")
    val input = readLine()
    if (input!!.toIntOrNull() != null) {
        println("Результат: ${common(input)}")
        println("Рекурсивный результат: ${recursive(input, '0')}")
    } else println("Неверно введено число")
}