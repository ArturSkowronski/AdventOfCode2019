package com.arturskowronski.aoc2019.days.day1

import com.arturskowronski.aoc2019.utils.Utils
import kotlin.math.abs

data class Instruction(val direction: String, val value: Int)
data class Point(val x: Int, val y: Int)

private fun getWire(wireNumber: Int) =
    Utils().getLine("/day3/input", wireNumber).split(",").map {
        Instruction(
            it.substring(0, 1),
            Integer.parseInt(it.substring(1))
        )
    }

private fun getFirstWire() = getWire(0)
private fun getSecondWire() = getWire(1)

fun main() {

    val points1 = mutableSetOf<Point>();
    val points2 = mutableSetOf<Point>();
    val positions = mutableSetOf<Int>();

    var position = Point(0, 0)

    getFirstWire().forEach {
        when (it.direction) {
            "L" -> {
                for (i in 1 until (it.value + 1)) {
                    points1.add(Point(position.x - i, position.y))
                }
                position = Point(position.x - it.value, position.y)
            }
            "R" -> {
                for (i in 1 until (it.value + 1)) {
                    points1.add(Point(position.x + i, position.y))
                }

                position = Point(position.x + it.value, position.y)
            }
            "U" -> {
                for (i in 1 until (it.value + 1)) {
                    points1.add(Point(position.x, position.y - i))
                }

                position = Point(position.x, position.y - it.value)
            }
            "D" -> {
                for (i in 1 until (it.value + 1)) {
                    points1.add(Point(position.x, position.y + i))
                }
                position = Point(position.x, position.y + it.value)
            }
        }
    }

    position = Point(0, 0)

    getSecondWire().forEach {
        when (it.direction) {
            "L" -> {
                for (i in 1 until (it.value + 1)) {
                    points2.add(Point(position.x - i, position.y))
                }
                position = Point(position.x - it.value, position.y)
            }
            "R" -> {
                for (i in 1 until (it.value + 1)) {
                    points2.add(Point(position.x + i, position.y))
                }

                position = Point(position.x + it.value, position.y)
            }
            "U" -> {
                for (i in 1 until (it.value + 1)) {
                    points2.add(Point(position.x, position.y - i))
                }

                position = Point(position.x, position.y - it.value)
            }
            "D" -> {
                for (i in 1 until (it.value + 1)) {
                    points2.add(Point(position.x, position.y + i))
                }
                position = Point(position.x, position.y + it.value)
            }
        }
    }

    val intersect = points1.intersect(points2)
    println(intersect.map { abs(it.x) + abs(it.y) }.min()!!)

    intersect.forEach { el ->
        var position1 = 0
        var position2 = 0

        points1.forEachIndexed { i, p ->
            if (p == el) {
                println(p)
                println(i)
                position1 = i
            }
        }

        points2.forEachIndexed { i, p ->
            if (p == el) {
                println(p)
                println(i)
                position2 = i
            }
        }

        positions.add(position1 + position2 + 2)
    }

    println(positions.min()!!)
}


