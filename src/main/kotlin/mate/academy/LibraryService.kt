package mate.academy

class LibraryService {
    private val books = mutableListOf<Book>()

    data class Author(val name: String)

    data class Book(
        val title: String,
        val authors: List<Author>,
        val publicationYear: Int,
        val genre: String,
        val isbn: String
    )

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter { book ->
            book.authors.any { author -> author.name.contains(authorName, ignoreCase = true) }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isEmpty()) {
            return emptyList()
        }
        return books.filter { it.genre.contains(genre, ignoreCase = true) }
    }
}
