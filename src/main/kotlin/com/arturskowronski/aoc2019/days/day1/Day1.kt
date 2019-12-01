package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils
import kotlin.math.floor

val utils: Utils = Utils()

fun modulesMasses() = utils.getFileLines("/day1/1").mapNotNull { it.toDoubleOrNull() }

fun calculateFuel(mass: Double) = floor(mass / 3) - 2

fun calculateFuelWithFuelMass(mass: Double): Double {
    val fuel = calculateFuel(mass)

    return if(calculateFuel(fuel) > 0.0) {
        fuel + calculateFuelWithFuelMass(fuel)
    } else {
        fuel
    }
}

private fun task1() {
    val totalFuel = modulesMasses()
        .map { calculateFuel(it) }
        .sumByDouble { it }

    println("total fuel: $totalFuel")
}

private fun task2() {
    val totalFuel = modulesMasses()
        .map { calculateFuelWithFuelMass(it) }
        .sumByDouble { it }

    println("total fuel with fuel: $totalFuel")
}

fun main() {
    task1()
    task2()
}