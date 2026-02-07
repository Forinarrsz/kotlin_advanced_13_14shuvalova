## Описание и примеры тем, изученных в лабораторной работе

В данной лабораторной работе мы рассмотрели ряд важных концепций Kotlin, необходимых для разработки современных Android-приложений:

### 1. Обобщённые типы (Generics)
- Позволяют писать универсальный код, который работает с разными типами данных.
- Позволяют избегать дублирования кода и повышают его безопасность.
- Пример использования:

```kotlin
// Обобщённый класс вопроса
class Question<T>(
    val text: String,
    val answer: T,
    val difficulty: Difficulty
)

// Создание вопросов с разными типами ответа
val q1 = Question<String>("Что такое Kotlin?", "Язык программирования", Difficulty.MEDIUM)
val q2 = Question<Boolean>("Истина ли 2+2=4?", true, Difficulty.EASY)
val q3 = Question<Int>("Рассчитайте 5+3", 8, Difficulty.HARD)
```
2. Enum классы (Перечисления)
Используются для задания ограниченного набора возможных значений.
В примере — уровень сложности вопроса:
```kotlin

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
```
Обеспечивают удобство и читаемость кода.
3. Коллекции Kotlin
Включают массивы, списки (List, MutableList), множества (Set), карты (Map).
Позволяют эффективно обрабатывать и фильтровать данные.
Примеры:
```kotlin

val questions = listOf(q1, q2, q3)
val difficultQuestions = questions.filter { it.difficulty == Difficulty.HARD }
difficultQuestions.forEach { it.printQuestion() }
```
4. Функции высшего порядка
Функции, принимающие или возвращающие функции.
Используются для обработки коллекций, реализации различных логик.
Например:
```kotlin

fun processQuestions(questions: List<Question<*>>, action: (Question<*>) -> Unit) {
    questions.forEach { action(it) }
}
```
5. Расширения (Extension функции и свойства)
Позволяют добавлять новые функции или свойства к существующим классам без наследования.
Пример:
```kotlin

fun Question<*>.printQuestion() {
    println("Вопрос: $text, Ответ: $answer, Уровень: $difficulty")
}
```
6. Объекты-синглтоны и companion objects
Используются для хранения единственного экземпляра класса или статических методов.
Полезны для настроек, менеджеров и других глобальных данных.



## Зачем нужны extension-свойства и функции

Когда создаёте свой класс, вы не знаете, как он будет применяться, в каком контексте, или какие дополнительные возможности могут понадобиться.  
Добавлять «на всякий случай» лишние методы — плохая практика.  

Kotlin предлагает механизм расширений — extensions — они позволяют:
- добавлять новые свойства и функции к существующим типам без изменения их исходного кода;
- использовать их через точечную нотацию как будто они часть класса;
- не изменять реальный исходный код класса.

**Важно:** расширения не изменяют класс, а добавляют удобный синтаксис поверх него.


## Extension-свойства (extension properties)

Для объявления extension-свойства пишут тип, который расширяется, и точку перед именем свойства:

```kotlin
val <Тип>.название_свойства: Тип_свойства
    get() = ... // логика получения значения
```

Пример: чтобы вывести прогресс в тесте, расширим класс `Quiz.StudentProgress`.

---

## Создание extension-свойства `progressText`

Объявите его перед классом `Quiz`, например:

```kotlin
val Quiz.StudentProgress.progressText: String
    get() = "Прогресс: $answered/$total вопросов"
```

*Обратите внимание:* extension-свойства могут иметь только getter, потому что не могут хранить состояние.

---

## Использование extension-свойства

Замените в `main()` старый код:

```kotlin
println("Прогресс: ${quiz.studentProgress.answered} вопросов из ${quiz.studentProgress.total}")
```

на:

```kotlin
println(quiz.studentProgress.progressText)
```

---

## Extension-функции (extension functions)

Объявляются подобно свойствам, с указанием типа и точки перед именем:

```kotlin
fun <Тип>.название_функции() { ... }
```

Добавим функцию вывода прогресс-бара:

---

## Создание extension-функции `printProgressBar()`

```kotlin
fun Quiz.StudentProgress.printProgressBar() {
    val answeredSymbols = "▓".repeat(answered)
    val remainingSymbols = "▒".repeat(total - answered)
    println("$answeredSymbols$remainingSymbols")
    println(progressText)
}
```

---

## Использование extension-функции

В `main()`:

```kotlin
quiz.studentProgress.printProgressBar()
```

Ожидаемый вывод:

```
▓▓▓░░░
Прогресс: 3 вопросов из 6
```

---

## Переписываем extension-функции с интерфейсами

Иногда лучше использовать интерфейсы, особенно если:

- есть доступ к исходному коду класса;
- необходимо, чтобы разные классы реализовали одни и те же методы или свойства;
- хочется обеспечить более строгий контракт.

### Создание интерфейса

```kotlin
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
```

### Реализация в классе `Quiz`

```kotlin
class Quiz(...) : ProgressPrintable {
    override val progressText: String
        get() = "Прогресс: $answered/$total вопросов"
    
    override fun printProgressBar() {
        val answeredSymbols = "▓".repeat(answered)
        val remainingSymbols = "▒".repeat(total - answered)
        println("$answeredSymbols$remainingSymbols")
        println(progressText)
    }
}
```

### Обновление `main()`

```kotlin
val quiz = Quiz(...)
quiz.printProgressBar()
```

---

## Scope-functions: доступ к свойствам и методам объекта

Kotlin предлагает функции высшего порядка: `let`, `apply`, `also`, `run`, `with`. Они помогают писать лаконичный код.

### Устранение повторений с помощью `let()`

```kotlin
questions.forEach { question ->
    println(question.text)
}
```

или с `let()`:

```kotlin
question?.let {
    println(it.text)
}
```

---

### Использование `apply()`

```kotlin
val quiz = Quiz().apply {
    // настройки объекта
}
```

---

## Массивы в Kotlin

Массив (`Array`) — это упорядоченное хранилище элементов одного типа, доступное по индексу.

### 14.1. Создание массива

```kotlin
val planets = arrayOf("Меркурий", "Венера", "Земля")
```

Массивы можно объединять `+`:

```kotlin
val morePlanets = planets + "Марс"
```

### Доступ к элементам

```kotlin
println(planets[0]) // Меркурий
```

### Изменение элемента

```kotlin
planets[2] = "Земля (наш дом)"
```

### Ограничения

Размер массива фиксирован — изменить нельзя. Для динамических коллекций используйте `MutableList`.

## Коллекции в Kotlin

### Списки (Lists)
- Упорядоченная коллекция с изменяемым размером.
- Создание списков с помощью `listOf()` и `mutableListOf()`.
- Доступ к элементам по индексу, перебор элементов с помощью цикла.
- Добавление, обновление и удаление элементов.
- Примеры:
  ```kotlin
  val readOnlyList = listOf("Mercury", "Venus", "Earth")
  val mutableList = mutableListOf("Mars", "Jupiter")
  
  // Добавление
  mutableList.add("Saturn")
  
  // Обновление
  mutableList[0] = "Mercury (Updated)"
  
  // Удаление
  mutableList.remove("Jupiter")
  ```

### Множества (Sets)
- Неупорядоченная коллекция без дублирующихся элементов.
- Использование `mutableSetOf()`.
- Быстрый поиск и гарантия уникальности.
- Примеры:
  ```kotlin
  val planets = mutableSetOf("Earth", "Mars", "Venus")
  planets.add("Jupiter")
  planets.add("Earth") // дубли не добавится
  ```

### Карты (Maps)
- Коллекция пар ключ-значение.
- Создание через `mapOf()` и `mutableMapOf()`.
- Быстрый доступ по ключу.
- Примеры:
  ```kotlin
  val planetDistances = mutableMapOf("Mercury" to 57.9, "Venus" to 108.2)
  planetDistances["Earth"] = 149.6
  val distanceToVenus = planetDistances["Venus"]
  ```

## Функции высокого порядка (High-order functions)
- Функции, которые принимают или возвращают функции.
- Примеры:
  ```kotlin
  fun displayMessage(message: () -> Unit) {
      message()
  }

  displayMessage(::morning)
  
  fun selectAction(key: Int): (Int, Int) -> Int {
      return when (key) {
          1 -> ::sum
          2 -> ::multiply
          else -> ::subtract
      }
  }
  
  val action = selectAction(1)
  println(action(5, 3)) // результат сложения
  ```

## Работа с коллекциями и функциями высокого порядка
- Методы для работы с коллекциями:
  - `forEach()`
  - `map()`
  - `filter()`
  - `groupBy()`
  - `fold()`
  - `sortedBy()`

## Общие выводы
- Коллекции помогают удобно организовывать и обрабатывать данные.
- Высокоуровневые функции позволяют писать лаконичный и выразительный код.


