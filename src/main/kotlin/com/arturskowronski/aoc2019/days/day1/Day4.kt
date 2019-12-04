package com.arturskowronski.aoc2019.days.day1

const val lowerBound = 153517
const val upperBound = 630395

fun ascending(number: Int): Boolean {
    val split = digits(number)
    return split == split.sorted()
}

fun doubledDigit(number: Int): Boolean {
    val split = digits(number)

    return (split[0] == split[1]) ||
            (split[1] == split[2]) ||
            (split[2] == split[3]) ||
            (split[3] == split[4]) ||
            (split[4] == split[5])
}

fun doubledDigit(number: Int, value: Int): Boolean {
    val split = digits(number)

    return (0..4).filter { split[it] == value && split[it] == split[it + 1] }.any()
}

fun nonTripleButDouble(number: Int): Boolean {
    return (0..9)
        .filter { doubledDigit(number, it) && !tripleDigit(number, it) }
        .any()
}

fun tripleDigit(number: Int, value: Int): Boolean {
    val split = digits(number)

    return (0..3).filter { split[it] == value && split[it] == split[it + 1] &&  split[it + 1] == split[it + 2] }.any()
}

private fun digits(number: Int): List<Int> {
    return number
        .toString()
        .split("")
        .filter { it != "" }
        .map { Integer.parseInt(it) }
}

fun main() {

    val y = (lowerBound..upperBound)
        .filter { ascending(it) }
        .filter { doubledDigit(it) }

    println("task1: ${y.count()}")

    val z = (lowerBound..upperBound)
        .filter { ascending(it) }
        .filter { doubledDigit(it) }
        .filter { nonTripleButDouble(it) }

    println("task2: ${z.count()}")
}