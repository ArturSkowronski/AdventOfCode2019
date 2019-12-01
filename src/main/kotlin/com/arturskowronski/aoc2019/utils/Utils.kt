package com.arturskowronski.aoc2019.utils

class Utils {
    fun getFileLines(fileName: String) =
        this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
}
