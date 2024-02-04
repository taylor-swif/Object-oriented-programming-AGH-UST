package model

class Animal(initialPosition: Vector2d, private var orientation : MapDirection = MapDirection.random()) {
    var position: Vector2d = initialPosition
    override fun toString(): String {
        return orientation.toString()

    }

    fun move(direction: MoveDirection, validator: MoveValidator) {
        when (direction) {
            MoveDirection.RIGHT -> orientation = orientation.next()
            MoveDirection.LEFT -> orientation = orientation.previous()
            else -> {}
        }

        val newPosition = when (direction) {
            MoveDirection.FORWARD -> position + orientation.toUnitVector()
            MoveDirection.BACKWARD -> position - orientation.toUnitVector()
            else -> position
        }

        if (validator.canMoveTo(newPosition)) {
            position = newPosition
        }

    }
}