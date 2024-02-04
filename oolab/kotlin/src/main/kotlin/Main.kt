import model.BouncyMap
import model.MoveDirection
import model.Vector2d

fun main(args: Array<String>) {
    println("Start")

    val initialPositions = listOf(Vector2d(2, 2), Vector2d(2, 3), Vector2d(2, 1), Vector2d(1, 2), Vector2d(3, 2), Vector2d(2,2))
    val moves = listOf(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT)
    val bouncyMap = BouncyMap(Vector2d(6, 6))

    val simulation = Simulation(initialPositions, moves, bouncyMap)
    simulation.run()
}