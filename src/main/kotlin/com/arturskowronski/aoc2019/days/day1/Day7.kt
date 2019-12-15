package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils
import com.marcinmoskala.math.permutations


private fun getOpcodes7() = Utils().getLine("/day7/input").split(",").mapNotNull { it.toIntOrNull() }.toMutableList()



fun main(){
    task2()
}

private fun task1() {
    val permutations = listOf(0, 1, 2, 3, 4).permutations()
    val sorted = permutations.map {
        val amp1 = IntcodeComputer(listOf(it[0], 0), getOpcodes7())
        val amp2 = IntcodeComputer(listOf(it[1], amp1), getOpcodes7())
        val amp3 = IntcodeComputer(listOf(it[2], amp2), getOpcodes7())
        val amp4 = IntcodeComputer(listOf(it[3], amp3), getOpcodes7())
        val amp5 = IntcodeComputer(listOf(it[4], amp4), getOpcodes7())
        amp5
    }
        .sorted()
    println(sorted.last())
}



private fun task2() {
    val permutations = setOf(listOf(9, 7, 8, 5, 6))
    val sorted = permutations.map {
        val amp1 = IntcodeComputer(listOf(it[0], 0), getOpcodes7())
        val amp2 = IntcodeComputer(listOf(it[1], amp1), getOpcodes7())
        val amp3 = IntcodeComputer(listOf(it[2], amp2), getOpcodes7())
        val amp4 = IntcodeComputer(listOf(it[3], amp3), getOpcodes7())
        val amp5 = IntcodeComputer(listOf(it[4], amp4), getOpcodes7())
        amp5
    }
        .sorted()
    println(sorted.last())
}