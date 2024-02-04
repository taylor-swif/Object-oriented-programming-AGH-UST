package model.utils

import model.Vector2d
import model.WorldMap

class MapVisualizer(private val map: WorldMap) {

    companion object {
        private const val EMPTY_CELL = " "
        private const val FRAME_SEGMENT = "-"
        private const val CELL_SEGMENT = "|"
    }

    fun draw(lowerLeft: Vector2d, upperRight: Vector2d): String {
        val builder = StringBuilder()
        for (i in upperRight.y + 1 downTo lowerLeft.y - 1) {
            if (i == upperRight.y + 1) {
                builder.append(drawHeader(lowerLeft, upperRight))
            }
            builder.append(String.format("%3d: ", i))
            for (j in lowerLeft.x..upperRight.x + 1) {
                if (i < lowerLeft.y || i > upperRight.y) {
                    builder.append(drawFrame(j <= upperRight.x))
                } else {
                    builder.append(CELL_SEGMENT)
                    if (j <= upperRight.x) {
                        builder.append(drawObject(Vector2d(j, i)))
                    }
                }
            }
            builder.append(System.lineSeparator())
        }
        return builder.toString()
    }

    private fun drawFrame(innerSegment: Boolean): String {
        return if (innerSegment) {
            "$FRAME_SEGMENT$FRAME_SEGMENT"
        } else {
            FRAME_SEGMENT
        }
    }

    private fun drawHeader(lowerLeft: Vector2d, upperRight: Vector2d): String {
        val builder = StringBuilder()
        builder.append(" y\\x ")
        for (j in lowerLeft.x until upperRight.x + 1) {
            builder.append(String.format("%2d", j))
        }
        builder.append(System.lineSeparator())
        return builder.toString()
    }

    private fun drawObject(currentPosition: Vector2d): String {
        if (map.isOccupied(currentPosition)) {
            val element = map.objectAt(currentPosition)
            return element?.toString() ?: EMPTY_CELL
        }
        return EMPTY_CELL
    }
}
