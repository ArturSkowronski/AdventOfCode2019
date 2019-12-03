package com.arturskowronski.aoc2019.utils

class Utils {
    fun getFileLines(fileName: String) =
        this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()

    fun getLine(fileName: String, lineNumber: Int = 0) =
        this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()[lineNumber]

    fun printArrayOfArrays(map: Array<Array<String>>) {
        for (array in map) {
            for (value in array) {
                print("$value ")
            }
            println()
        }
    }
}
