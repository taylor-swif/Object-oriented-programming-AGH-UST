package model

data class Vector2d(val x: Int, val y: Int) {
    fun precedes(other: Vector2d): Boolean {
        return this.x <= other.x && this.y <= other.y
    }

    fun follows(other: Vector2d): Boolean {
        return this.x >= other.x && this.y >= other.y
    }

    operator fun plus(other: Vector2d): Vector2d {
        val newX = this.x + other.x
        val newY = this.y + other.y
        return Vector2d(newX, newY)
    }

    operator fun minus(other: Vector2d): Vector2d {
        val newX = this.x - other.x
        val newY = this.y - other.y
        return Vector2d(newX, newY)
    }

    override fun toString(): String {
        return "($x,$y)"
    }

}
fun MapDirection.toUnitVector(): Vector2d {
    return when (this) {
        MapDirection.NORTH -> Vector2d(0, 1)
        MapDirection.SOUTH -> Vector2d(0, -1)
        MapDirection.WEST -> Vector2d(-1, 0)
        MapDirection.EAST -> Vector2d(1, 0)
    }
}