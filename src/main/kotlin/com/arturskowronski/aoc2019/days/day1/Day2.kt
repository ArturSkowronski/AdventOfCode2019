package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils


private fun getOpcodes() = Utils().getLine("/day2/input").split(",").mapNotNull { it.toIntOrNull() }.toMutableList()

private fun task1(noun: Int, verb: Int): Int {

    var i = 0
    val opcodes = getOpcodes()

    opcodes[1] = noun
    opcodes[2] = verb

    while (true) {
        val operation = getOperation(opcodes.drop(4 * i))

        if (operation != null) {
            when (operation.operation) {
                1 -> opcodes[operation.output!!] = opcodes[operation.input1!!] + opcodes[operation.input2!!]
                2 -> opcodes[operation.output!!] = opcodes[operation.input1!!] * opcodes[operation.input2!!]
            }
            i++
        } else {
            break
        }
    }
    return opcodes[0]
}


private fun getOperation(opcodes: List<Int>): Opcode? {
    val take = opcodes
        .take(4)

    return when (take[0]) {
        1 -> Opcode(take[0], take[1], take[2], take[3])
        2 -> Opcode(take[0], take[1], take[2], take[3])
        else -> null
    }
}


fun main() {
    for (i in 0..60) {
        val y = 86
        val state = task1(i, y)

        println("operation: $state")

        if (state == 19690720) {
            println("got it $i $y ${(100*i)+y}")
        }
    }
}

data class Opcode(val operation: Int, val input1: Int?, val input2: Int?, val output: Int?)