import java.util.Random

fun main() {
    feedTheFish()
}

fun feedTheFish() {
    val day = "Tuesday"//randomDay()
    val food = fishFood(day)

    println("Today is $day and the fish eat $food")
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

main()
