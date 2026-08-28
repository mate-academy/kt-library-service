package mate.academy

data class Book(
    val title: String,
    val authors: List<Author>,
    val publicationYear: Int,
    val genre: String,
    val isbn: String
)

data class Author(val name: String)

class LibraryService {
    private val dataBase = mutableListOf<Book>()

    fun addBook(book: Book) {
        dataBase.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        if (title.isBlank()) return dataBase.toList()
        return dataBase.filter { it.title.lowercase().contains(title.lowercase()) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        if (authorName.isBlank()) return emptyList()
        return dataBase.filter {
            it.authors.map { a -> a.name }.any { n -> n.lowercase().contains(authorName.lowercase()) }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) return emptyList()
        return dataBase.filter { it.genre.lowercase().contains(genre.lowercase()) }
    }
}
