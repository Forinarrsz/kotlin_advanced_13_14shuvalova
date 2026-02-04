val rockPlanets = arrayOf<String>("mercury", "venus", "mars", "earth")
val gasPlanets = arrayOf("jupiter", "saturn", "uranus", "neptune")

val solarsystem = rockPlanets + gasPlanets
val newsolarsystem = arrayOf(
    "mercury", "venus", "mars", "earth","jupiter", "saturn", "uranus", "neptune", "pluto"
)
fun main(){
    println(solarsystem[0])
    println(solarsystem[1])
    println(solarsystem[2])
    println(solarsystem[3])
    println(solarsystem[4])
    println(solarsystem[5])
    println(solarsystem[6])
    println(solarsystem[7])

    solarsystem[3] = "Pandora"
    println(solarsystem[3])
}