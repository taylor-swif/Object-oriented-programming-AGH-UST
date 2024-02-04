package model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PlacementTests : StringSpec({

    "placing an animal on an empty map should succeed" {
        val bouncyMap = BouncyMap(Vector2d(5, 5))
        val animal = Animal(Vector2d(2, 2))

        bouncyMap.place(animal) shouldBe true
    }

    "placing an animal in a full map should throw NoMoreSpaceException" {
        val bouncyMap = BouncyMap(Vector2d(0, 0))
        val animal1 = Animal(Vector2d(0, 0))
        val animal2 = Animal(Vector2d(0, 0))

        bouncyMap.place(animal1)
        val exception = shouldThrow<NoMoreSpaceException> {
            bouncyMap.place(animal2)
        }
        exception.message shouldBe "There is no more space on the map!"
    }
})

class MovementTests : StringSpec({

    "moving an animal within the map should update its position" {
        val bouncyMap = BouncyMap(Vector2d(5, 5))
        val animal = Animal(Vector2d(2, 2), MapDirection.NORTH)

        bouncyMap.place(animal)
        bouncyMap.move(animal, MoveDirection.FORWARD)

        animal.position shouldBe Vector2d(2, 3)
    }
})

class BoundaryChecks : StringSpec({

    "animal cannot move outside the upper-right boundary" {
        val bouncyMap = BouncyMap(Vector2d(5, 5))
        val animal = Animal(Vector2d(5, 5), MapDirection.NORTH)

        bouncyMap.place(animal)
        bouncyMap.move(animal, MoveDirection.FORWARD)

        animal.position shouldBe Vector2d(5, 5)
    }

    "animal cannot move outside the lower-left boundary" {
        val bouncyMap = BouncyMap(Vector2d(5, 5))
        val animal = Animal(Vector2d(0, 0), MapDirection.NORTH)

        bouncyMap.place(animal)
        bouncyMap.move(animal, MoveDirection.BACKWARD)

        animal.position shouldBe Vector2d(0, 0)
    }
})
