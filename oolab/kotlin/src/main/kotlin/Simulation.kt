import model.*


class Simulation(
    initialPositions: List<Vector2d>,
    private val moves: List<MoveDirection>,
    private val worldMap: WorldMap
) : Runnable {

    private val animals: MutableList<Animal> = ArrayList()
    init {
        for (initialPosition in initialPositions) {
            val animal = Animal(initialPosition)
            try {
                worldMap.place(animal)
                animals.add(animal)
                print(worldMap)
            } catch (e: NoMoreSpaceException) {
                println(e.message)
            }
        }
    }

    override fun run() {
        val numberOfAnimals = animals.size
        var currentAnimalIndex = 0

        for (move in moves) {
            val currentAnimal = animals[currentAnimalIndex]
            worldMap.move(currentAnimal, move)
            println(worldMap)

            currentAnimalIndex = (currentAnimalIndex + 1) % numberOfAnimals
        }
    }
}
