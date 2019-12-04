package com.arturskowronski.aoc2019.days.day1

const val lowerBound = 153517
const val upperBound = 630395

fun ascending(number: Int): Boolean {
    val split = number
        .toString()
        .split("")
        .filter { it != "" }
        .map { Integer.parseInt(it) }
    return split == split.sorted()
}

fun doubledDigit(number: Int): Boolean {
    val split = number
        .toString()
        .split("")
        .filter { it != "" }
        .map { Integer.parseInt(it) }

    return (split[0] == split[1]) ||
            (split[1] == split[2]) ||
            (split[2] == split[3]) ||
            (split[3] == split[4]) ||
            (split[4] == split[5])
}

fun doubledDigit(number: Int, value: Int): Boolean {
    val split = number
        .toString()
        .split("")
        .filter { it != "" }
        .map { Integer.parseInt(it) }

    return  ((split[0] == value) && (split[0] == split[1])) ||
            ((split[1] == value) && (split[1] == split[2])) ||
            ((split[2] == value) && (split[2] == split[3])) ||
            ((split[3] == value) && (split[3] == split[4])) ||
            ((split[4] == value) && (split[4] == split[5]))
}

fun nonTripleButDouble(number: Int): Boolean {
    return (0..9).map {
        doubledDigit(number, it) && !tripleDigit(number, it)
    }.filter {it}.any()
}

fun tripleDigit(number: Int, value: Int): Boolean {
    val split = number
        .toString()
        .split("")
        .filter { it != "" }
        .map { Integer.parseInt(it) }

    return  ((split[0] == value) && (split[0] == split[1]) && (split[1] == split[2])) ||
            ((split[1] == value) && (split[1] == split[2]) && (split[2] == split[3])) ||
            ((split[2] == value) && (split[2] == split[3]) && (split[3] == split[4])) ||
            ((split[3] == value) && (split[3] == split[4]) && (split[4] == split[5]))
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