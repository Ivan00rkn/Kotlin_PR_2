/*Функции, созданные в задании №1, модифицируйте таким образом,
чтобы условие, по которому происходит отбор, можно было передавать как аргумент
(один из аргументов функции должен быть lambda со значением
по умолчанию – условием, что указано было в вашем варианте)*/



fun main () {
    fun common (input: String, condition:(Char, Char) -> Boolean): Char {
        var max = '0'
        for (num: Char in input) if (condition(num, max)) max = num
        return  max
    }

    tailrec fun recursive(input: String, max: Char, n: Int = 0, condition:(Char, Char) -> Boolean): Char = when {
        n == input.length - 1 -> max
        input.length == 1 -> input[0]
        condition(input[n], max) -> recursive(input, input[n], n+1, condition )
        else -> recursive(input, max, n+1, condition )
    }

    println("Введите неотрицательное число и я найду максимальную чётную цифру: ")
    val input = readLine()
    if (input!!.toIntOrNull() != null) {
        println("Результат: ${common(input) {num, max -> num > max && num.toInt() % 2 == 0}}")
        println("Рекурсивный результат: ${recursive(input, '0'){num, max -> num > max && num.toInt() % 2 == 0}}")
    } else println("Неверно введено число")
}