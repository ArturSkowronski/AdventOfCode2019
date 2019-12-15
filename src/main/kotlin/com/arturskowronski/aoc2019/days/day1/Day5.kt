package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils


private fun getOpcodes() = Utils().getLine("/day5/input").split(",").mapNotNull { it.toIntOrNull() }.toMutableList()

private fun task1(): Int {

    var i = 0
    var drop = 0
    var opcodes = getOpcodes()
    val input = 5

    while (true) {
        val operation = getOperation(opcodes.drop(drop))
        if (operation != null) {
            when (operation.operation) {
                1 -> {
                    operation.output?.setValue(operation.input1!!.getValue(opcodes) + operation.input2!!.getValue(opcodes), opcodes)
                    drop += 4
                }
                2 -> {
                    operation.output?.setValue(operation.input1!!.getValue(opcodes) * operation.input2!!.getValue(opcodes), opcodes)
                    drop += 4
                }
                3 -> {
                    operation.input1!!.setValue(input, opcodes)
                    drop += 2
                }
                4 -> {
                    println(operation.input1!!.getValue(opcodes))
                    drop += 2
                }
                5 -> {
                    if(operation.input1!!.getValue(opcodes) != 0) {
                        drop = operation.input2!!.getValue(opcodes)
                    } else {
                        drop+=3
                    }
                }
                6 -> {
                    if(operation.input1!!.getValue(opcodes) == 0) {
                        drop = operation.input2!!.getValue(opcodes)
                    } else {
                        drop+=3
                    }
                }
                7 -> {
                    if(operation.input1!!.getValue(opcodes) < operation.input2!!.getValue(opcodes)) {
                        operation.output?.setValue(1, opcodes)
                    } else {
                        operation.output?.setValue(0, opcodes)
                    }
                    drop +=4
                }
                8 -> {
                    if(operation.input1!!.getValue(opcodes) == operation.input2!!.getValue(opcodes)) {
                        operation.output?.setValue(1, opcodes)
                    } else {
                        operation.output?.setValue(0, opcodes)
                    }
                    drop +=4
                }
            }
            i++
        } else {
            break
        }
    }
    return opcodes[0]
}

private fun getOperation(opcodes: List<Int>): Opcode2? {
    val take = opcodes
        .first()

    var padStart = take.toString().padStart(5, '0')

    var instruction = Integer.parseInt(padStart[4].toString())

    return when (instruction) {
        1 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), Parameter(opcodes[3], padStart[0]))
        2 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), Parameter(opcodes[3], padStart[0]))
        3 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), null, null)
        4 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), null, null)
        5 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), null)
        6 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), null)
        7 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), Parameter(opcodes[3], padStart[0]))
        8 -> Opcode2(instruction, Parameter(opcodes[1], padStart[2]), Parameter(opcodes[2], padStart[1]), Parameter(opcodes[3], padStart[0]))
        else -> null
    }
}

data class Parameter(val value: Int?, val mode: Char?){
    fun getValue(opcodes: List<Int>): Int {
        if(mode == '0') {
            return opcodes[value!!]
        } else {
            return value!!
        }
    }

    fun setValue(input: Int, opcodes: MutableList<Int>) {
        opcodes[value!!] = input
    }
}

data class Opcode2(val operation: Int, val input1: Parameter?, val input2: Parameter?, val output: Parameter?)

fun main() {
    task1()
}

