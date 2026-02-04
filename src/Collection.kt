val rockPlanets = arrayOf<String>("mercury", "venus", "mars", "earth")
val gasPlanets = arrayOf("jupiter", "saturn", "uranus", "neptune")

val solarsystem = rockPlanets + gasPlanets
val newsolarsystem = arrayOf(
    "mercury", "venus", "mars", "earth","jupiter", "saturn", "uranus", "neptune", "pluto"
)
fun main(){
    /*println(solarsystem[0])
    println(solarsystem[1])
    println(solarsystem[2])
    println(solarsystem[3])
    println(solarsystem[4])
    println(solarsystem[5])
    println(solarsystem[6])
    println(solarsystem[7])

    solarsystem[3] = "Pandora"
    println(solarsystem[3])*/

    val solarsystemlist = listOf("mercury", "venus", "mars", "earth","jupiter", "saturn", "uranus", "neptune", "pluto")
    println(solarsystemlist.size)
    println(solarsystemlist[2])
    println(solarsystemlist.get(3))
    println(solarsystemlist.indexOf("mars"))
    println(solarsystemlist.indexOf("venus"))

    for (planet in solarsystemlist) {
        println(planet)
    }

    val solarsystemmutlist = mutableListOf("mercury", "venus", "mars", "earth","jupiter", "saturn", "uranus", "neptune", "pluto")
    solarsystemmutlist.add("Pandora")
    solarsystemmutlist.add(3, "theia")

    solarsystemmutlist[3] = "moon"
    println(solarsystemmutlist[3])
    println(solarsystemmutlist[9])
    solarsystemmutlist.removeAt(9)
    println(solarsystemmutlist.contains("mars"))
    println("Pandora" in solarsystemmutlist)

}