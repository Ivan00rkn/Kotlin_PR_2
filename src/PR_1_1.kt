/*Измените программу, сделанную в задании No1 практической работы No1:
основной алгоритм вынесите в функцию. Опишите функцию несколькими
способами:
1. как обычную функцию;
2. как tailrec-функцию.*/

fun common (input: String): Char {
    var max = '0'
    for (num: Char in input) if (num > max && num.toInt() % 2 == 0) max = num
    return  max
}

tailrec fun recursive(input: String, max: Char, n: Int = 0): Char = when {
    n == input.length - 1 -> max
    input.length == 1 -> input[0]
    (input[n] > max && input[n].toInt() % 2 == 0) -> recursive(input, input[n], n+1 )
    else -> recursive(input, max, n+1 )
}

fun main () {
    println("Введите неотрицательное число и я найду максимальную чётную цифру: ")
    val input = readLine()
    if (input!!.toIntOrNull() != null) {
        println("Результат: ${common(input)}")
        println("Рекурсивный результат: ${recursive(input, '0')}")
    } else println("Неверно введено число")
}