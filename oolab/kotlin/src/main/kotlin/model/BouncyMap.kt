package model

class BouncyMap(private var upperRight: Vector2d) : AbstractWorldMap() {
    private val lowerLeft = Vector2d(0, 0)
    override fun toString(): String {
        return map.draw(lowerLeft, upperRight)
    }

    override fun canMoveTo(position: Vector2d): Boolean {

        return  position.follows(lowerLeft) && position.precedes(upperRight) && !isOccupied(position)
    }

    override fun objectAt(position: Vector2d): Animal? {
        return animals[position]
    }

    @Throws(NoMoreSpaceException::class)
    override fun place(animal: Animal): Boolean {
        val currentPosition = animal.position

        if (this.isOccupied(currentPosition)) {
            val array = intArrayOf(0, 1, 2, 3).also { it.shuffle() }

            for (i in array) {
                val reflectedPosition = currentPosition + MapDirection.entries[i].toUnitVector()
                if (!this.isOccupied(reflectedPosition) && this.canMoveTo(reflectedPosition)) {
                    animal.position = reflectedPosition
                    animals[reflectedPosition] = animal
                    return true
                }
            }
            val freePositions = animals.randomFreePosition(upperRight)
            if (freePositions != null) {
                animal.position = freePositions
                animals[freePositions] = animal
                return true
            }
            else {
                throw NoMoreSpaceException()
            }

        }
        if (this.canMoveTo(currentPosition)) {
            animals[currentPosition] = animal
            return true
        }
        throw NoMoreSpaceException()
    }

}
