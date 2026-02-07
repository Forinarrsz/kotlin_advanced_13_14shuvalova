class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)
val cookies = listOf(
Cookie(
name = "Печенье с шоколадом",
softBaked = false,
hasFilling = false,
price = 1.69
),
Cookie(
name = "Нуга ореховая",
softBaked = true,
hasFilling = false,
price = 1.49
),
Cookie(
name = "Ванильный крем",
softBaked = false,
hasFilling = true,
price = 1.59
),
Cookie(
name = "Шоколадно-арахисовое масло",
softBaked = false,
hasFilling = true,
price = 1.49
),
Cookie(
name = "Сникерс",
softBaked = true,
hasFilling = false,
price = 1.39
),
Cookie(
name = "Черничный пирог",
softBaked = true,
hasFilling = true,
price = 1.79
),
Cookie(
name = "Сахар и посыпка",
softBaked = false,
hasFilling = false,
price = 1.39
)
)
fun main(){
    cookies.forEach {
        println("Пункт меню ${it.name}")
    }

    val fullmenu = cookies.map {
        "${it.name} - ${it.price}"
    }
    println("Полное меню: ")
    fullmenu.forEach {
        println(it)
    }

    val sortedmenu = cookies.filter {
        it.softBaked
    }
    println("Мягкое печенье")
    sortedmenu.forEach {
        println("${it.name} - ${it.price}")
    }


    val groupedmenu = cookies.groupBy { it.softBaked }
    val softbakedmenu = groupedmenu[true] ?: emptyList()
    val crunchymenu = groupedmenu[false] ?: emptyList()
    println("soft cookies")
    softbakedmenu.forEach {
        println("${it.name} - ${it.price}")
    }
    println("crunchy cookies:")
    crunchymenu.forEach {
        println("${it.name} - ${it.price}")
    }
}