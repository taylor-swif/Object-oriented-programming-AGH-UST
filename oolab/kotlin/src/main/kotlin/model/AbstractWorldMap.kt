package model

import model.utils.MapVisualizer

abstract class AbstractWorldMap() : WorldMap {
    protected val animals: MutableMap<Vector2d, Animal> = HashMap()
    protected var map: MapVisualizer = MapVisualizer(this)

    override fun isOccupied(position: Vector2d): Boolean {
        return objectAt(position) != null
    }

    override fun move(animal: Animal, direction: MoveDirection) {
        val oldPosition = animal.position
        animal.move(direction, this)

        if (oldPosition != animal.position) {
            val removedAnimal = animals.remove(oldPosition)
            if (removedAnimal != null) {
                animals[animal.position] = removedAnimal
            }
        }
    }

    override fun objectAt(position: Vector2d): Animal? {
        return animals[position]
    }

}
