package model.utils

import model.Vector2d

class RandomPositionGenerator(private val maxWidth: Int, private val maxHeight: Int, private val grassCount: Int) :
    Iterable<Vector2d> {

    private val positions: List<Vector2d> by lazy { generateRandomPositions() }
    private var currentIndex = 0

    init {
        require(grassCount <= maxWidth * maxHeight) { "grassCount must be less than or equal to maxWidth * maxHeight" }
    }

    private fun generateRandomPositions(): List<Vector2d> {
        val allPositions = mutableListOf<Vector2d>()
        for (x in 0 until maxWidth) {
            for (y in 0 until maxHeight) {
                allPositions.add(Vector2d(x, y))
            }
        }

        allPositions.shuffle()
        return allPositions.subList(0, grassCount)
    }

    override fun iterator(): Iterator<Vector2d> {
        return object : Iterator<Vector2d> {
            override fun hasNext(): Boolean {
                return currentIndex < grassCount
            }

            override fun next(): Vector2d {
                if (!hasNext()) {
                    throw NoSuchElementException("No more positions to generate.")
                }
                return positions[currentIndex++]
            }
        }
    }
}
