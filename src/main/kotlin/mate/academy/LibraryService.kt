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
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.lowercase().contains(title.lowercase()) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter { book ->
            book.authors.any { it.name.lowercase().contains(authorName.lowercase()) }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, ignoreCase = true) }
    }
}
