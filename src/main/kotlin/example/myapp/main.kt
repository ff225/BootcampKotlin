package example.myapp

fun BuildAcquarium() {
    val myAcquarium = Aquarium()
    myAcquarium.printSize()

    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

    /*
    val myAcquarium1 = Aquarium(numberOfFish = 29)
    myAcquarium1.printSize()
    myAcquarium1.volume=70
    myAcquarium1.printSize()
    //println("Volume: ${myAcquarium1.width * myAcquarium1.length * myAcquarium1.height / 1000} l")
     */
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main() {
    BuildAcquarium()
    makeFish()
}