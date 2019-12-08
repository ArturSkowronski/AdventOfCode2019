package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils
import java.lang.Exception
import java.lang.RuntimeException

class Layer {
    private val rows: MutableList<List<String>> = mutableListOf()

    fun add(row: List<String>) {
        rows.add(row)
    }

    private fun countDigits(digit: String): Int {
        return rows.flatten().filter {it == digit}.count()
    }

    fun countZeroDigit(): Int {
        return countDigits("0")
    }

    fun countOneMultipledByTwo(): Int {
        return countDigits("1") * countDigits("2")
    }

    fun getPixelByPosition(x: Int, y: Int): String {
        return rows[y][x]
    }

    override fun toString(): String {
        return "Layer(rows=$rows)"
    }
}

fun main() {
    task1()
    task2()
}


private fun task2() {
    val input = Utils().getLine("/day8/input").split("").filter { it != "" }
    val layers = createLayers(input)

    var image = mutableListOf<MutableList<String>>()

    (0..5).forEach{y ->
        var row = mutableListOf<String>()
        (0..24).forEach { x ->
             row.add(calculatePixel(layers, x, y))
        }
        image.add(row)
    }

    image.forEach {
        println(it.map{ el -> el.replace("0", " ")}.joinToString { it })
    }
}

private fun task1() {
    val input = Utils().getLine("/day8/input").split("").filter { it != "" }
    val layers = createLayers(input)
    val sortedLayers = layers.map {
        it.countZeroDigit() to it
    }.sortedBy { it.first }

    println(sortedLayers.first().second.countOneMultipledByTwo())
}

private fun createLayers(input: List<String>): List<Layer> {
    return input.chunked(25).chunked(6).map { rows ->
        val layer = Layer()
        rows.forEach { layer.add(it) }
        layer
    }
}

private fun calculatePixel(input: List<Layer>, x: Int, y: Int): String {
    for (layer in input) {
        val pixelByPosition = layer.getPixelByPosition(x, y)
        if (pixelByPosition != "2") {
            return pixelByPosition
        }
    }
    throw RuntimeException()
}