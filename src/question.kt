class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
enum class Difficulty{
    EASY,
    MEDIUM,
    HARD
}
fun main(){
    val qst1 = Question<String>(
        "речка спятила с ума - по домам пошла сама","водопад",Difficulty.MEDIUM
    )
    val qst2 = Question<Boolean>(
        "небо зеленое. правда или ложь", false, Difficulty.EASY
    )
    val qst3 = Question<Int>(
        "сколько дней между полнолуниями?",28,Difficulty.HARD
    )

    println(qst1.answer)
    println(qst2.answer)
    println(qst3.answer)
}