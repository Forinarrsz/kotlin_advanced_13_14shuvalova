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

    val solarsystemset = mutableSetOf("mercury", "venus", "mars", "earth","jupiter", "saturn", "uranus", "neptune", "pluto")
    println(solarsystemset.size)
    println(solarsystemset.contains("mars"))
    println("mars" in solarsystemset)
    solarsystemset.add("pandora")
    println(solarsystemset.size)
    solarsystemset.remove("mars")
    println(solarsystemset.size)
    println(solarsystemset.contains("mars"))


    val solarsystemmutmap = mutableMapOf("mercury" to 0, "venus" to 0, "mars" to 2, "earth" to 1,"jupiter" to 79, "saturn" to 82, "uranus" to 27, "neptune" to 14, "pluto" to 29)
    println(solarsystemmutmap.size)
    solarsystemmutmap["mars"] = 5
    println(solarsystemmutmap.size)
    println(solarsystemmutmap["earth"])
   println(solarsystemmutmap.get("pandora"))
   solarsystemmutmap.remove("venus")
    println(solarsystemmutmap.size)
    solarsystemmutmap["saturn"] = 78
    println(solarsystemmutmap["saturn"])

}