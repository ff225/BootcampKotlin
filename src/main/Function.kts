import java.util.Random

val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    /*
    feedTheFish()
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed = "turtle-like")
     */

    //println(decorations.filter { it[0].equals('p') })
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    var dirtywater = 20

    /**
     * Lambda function
     * 1- val n_variabile = { n_var : <data_type> -> funzione}
     * -> val waterFilter = {dirty: Int -> dirty / 2}
     *
     * 2- val n_variabile: (data_type) -> data_type = {n_var -> funzione}
     * -> val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
     *
     */

    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter(dirtywater))

    println("updateDirty: " + updateDirty(30, waterFilter))

    /**
     * La funzione può anche non essere di tipo lamba.
     * Per specificarlo utilizziamo ::
     */

    println("increase dirty: "+ updateDirty(10, ::increaseDirty))
}

main()

/**
 * Il vero potere dei lambda è usarli per creare funzioni di ordine superiore,
 * dove l'argomento di una funzione è un'altra funzione
 */

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun increaseDirty(dirty: Int) = dirty + 1

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)

    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun randomDay(): String {
    val week = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    )

    return week[Random().nextInt(week.size)]
}

/**
 * è possibile settare un valore di default al parametro
 */
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

/**
 * se non inseriamo valori di default, il parametro è obbligatorio.
 *
 */

/*
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day.equals("Sunday") -> true
        else -> false
    }
}
 */

/**
 * è possibile scompattare la funzione precedente in tre singole funzioni
 * queste sono dette funzioni compatte (single-expression function)
 */

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day.equals("Sunday")

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}



