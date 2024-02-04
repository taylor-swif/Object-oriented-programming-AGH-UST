package model

enum class MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    override fun toString(): String {
        return when (this) {
            NORTH -> "N"
            EAST -> "E"
            SOUTH -> "S"
            WEST -> "W"
        }
    }

    fun next(): MapDirection {
        val nextOrdinal = (this.ordinal + 1) % entries.size
        return entries[nextOrdinal]
    }

    fun previous(): MapDirection {
        val previousOrdinal = (this.ordinal + entries.size - 1) % entries.size
        return entries[previousOrdinal]
    }

    companion object {
        fun random(): MapDirection {
            val randomOrdinal = (0..<entries.size).random()
            return entries[randomOrdinal]
        }
    }

}
