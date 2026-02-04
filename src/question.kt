data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {

    val qst1 = Question<String>(
        "речка спятила с ума - по домам пошла сама", "водопад", Difficulty.MEDIUM
    )
    val qst2 = Question<Boolean>(
        "небо зеленое. правда или ложь", false, Difficulty.EASY
    )
    val qst3 = Question<Int>(
        "сколько дней между полнолуниями?", 28, Difficulty.HARD
  )
fun printQuiz() {
qst1.let {
    println(it.questionText)
    println(it.answer)
    println(it.difficulty)
}
    println()
    qst2.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()

    qst3.let {
        println(it.questionText)
        println(it.answer)
        println(it.difficulty)
    }
    println()
}
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { println("▓") }
        repeat(Quiz.total - Quiz.answered) { println("▓") }
        println()
        println(progressText)
    }
}


enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

fun main() {
    //Quiz().printProgressBar()
    /* println(qst1.answer)
     println(qst2.answer)
     println(qst3.answer)
     println(qst1.toString())
     println("========")*/
    //println("${Quiz.answered} of ${Quiz.total} answered")
val quiz = Quiz().apply { printQuiz() }


}
