class Library<T> {
    private val items: MutableList<T> = mutableListOf()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }
}
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)
sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}
fun filterByYear(library: Library<LibraryItem>, year: Int): List<Book> {
    return library.getAll()
        .filterIsInstance<LibraryItem.BookItem>()
        .map { it.book }
        .filter { it.year == year }
}

fun sortByTitle(library: Library<LibraryItem>): List<LibraryItem> {
    return library.getAll().sortedBy {
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }
}

fun groupByAuthor(library: Library<LibraryItem>): Map<String, List<Book>> {
    return library.getAll()
        .filterIsInstance<LibraryItem.BookItem>()
        .map { it.book }
        .groupBy { it.author }
}

fun calculateTotalDuration(library: Library<LibraryItem>): Int {
    return library.getAll()
        .filterIsInstance<LibraryItem.DVDItem>()
        .sumOf { it.dvd.duration }
}
fun main() {
    val library = Library<LibraryItem>()

    library.add(LibraryItem.BookItem(Book("1984", "George Orwell", 1949, "1234567890")))
    library.add(LibraryItem.BookItem(Book("Brave New World", "Aldous Huxley", 1932, "0987654321")))


    library.add(LibraryItem.MagazineItem(Magazine("National Geographic", 1, "January")))


    library.add(LibraryItem.DVDItem(DVD("Inception", "Christopher Nolan", 148)))

    val booksFrom1949 = filterByYear(library, 1949)
    println("Books from 1949: $booksFrom1949")

    val sortedItems = sortByTitle(library)
    println("Sorted items by title: $sortedItems")

    val groupedByAuthor = groupByAuthor(library)
    println("Grouped by author: $groupedByAuthor")

    val totalDuration = calculateTotalDuration(library)
    println("Total duration of DVDs: $totalDuration minutes")
}
