package example.myapp

/**
 * NB: le classi astratte sono sempre open
 */
abstract class AquariumFish {
    abstract val color: String
}

interface FishAction {
    fun eat()
}

class Shark : AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus : AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("hunt and eat fish")
    }
}