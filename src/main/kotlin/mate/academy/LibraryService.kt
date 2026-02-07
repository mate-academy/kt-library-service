package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()


    data class Book(val title: String, val authors: List<Author>,
                    val publicationYear: Int, val genre: String, val isbn: String)

    data class Author(val name: String)

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return library.filter { it.title.lowercase().contains(title.lowercase()) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return library.filter{ book -> book.authors.
            any { author -> author.name.lowercase().contains(authorName.lowercase()) } }
    }

    fun searchByGenre(genre: String): List<Book> {
        return if (genre.isEmpty()) listOf() else
            library.filter{ it.genre.lowercase().contains(genre.lowercase()) }
    }
}
