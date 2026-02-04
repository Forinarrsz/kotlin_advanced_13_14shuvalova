data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
class Quiz {
    val qst1 = Question<String>(
        "речка спятила с ума - по домам пошла сама", "водопад", Difficulty.MEDIUM
    )
    val qst2 = Question<Boolean>(
        "небо зеленое. правда или ложь", false, Difficulty.EASY
    )
    val qst3 = Question<Int>(
        "сколько дней между полнолуниями?", 28, Difficulty.HARD
    )

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}
val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

enum class Difficulty{
    EASY,
    MEDIUM,
    HARD
}
fun Quiz.StudentProgress.printProgressBar(){
    repeat(Quiz.answered) { println("▓") }
    repeat(Quiz.total - Quiz.answered) { println("▓") }
    println()
    println(Quiz.progressText)
}

fun main(){
println(Quiz.progressText)
Quiz.printProgressBar()
   /* println(qst1.answer)
    println(qst2.answer)
    println(qst3.answer)
    println(qst1.toString())
    println("========")*/
    //println("${Quiz.answered} of ${Quiz.total} answered")
}