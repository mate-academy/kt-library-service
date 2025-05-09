package mate.academy

data class Author(val name: String)

data class Book(
    val title: String,
    val authors: List<Author>,
    val publicationYear: Int,
    val genre: String,
    val isbn: String
)

class LibraryService {

    private val bookStorage: MutableList<Book> = ArrayList()

    fun addBook(book: Book) = bookStorage.add(book)

    fun searchByTitle(title: String): List<Book> = bookStorage
        .filter { it.title.lowercase().contains(title.lowercase()) }

    fun searchByAuthor(authorName: String): List<Book> = bookStorage
        .filter { book -> book.authors
            .map { it.name.lowercase() }
            .any { it.contains(authorName.lowercase()) } }

    fun searchByGenre(genre: String): List<Book> =
        if (genre != "")
            bookStorage.filter { it.genre.lowercase().contains(genre.lowercase()) }
        else emptyList()
}
