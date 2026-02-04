class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main(){
    val qst1 = Question<String>(
        "речка спятила с ума - по домам пошла сама","водопад","medium"
    )
    val qst2 = Question<Boolean>(
        "небо зеленое. правда или ложь", false, "easy"
    )
    val qst3 = Question<Int>(
        "сколько дней между полнолуниями?",28,"hard"
    )

    println(qst1.answer)
    println(qst2.answer)
    println(qst3.answer)
}