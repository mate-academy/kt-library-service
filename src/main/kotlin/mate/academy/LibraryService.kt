package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return library.filter { it.title.lowercase().contains(title.lowercase()) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return library.filter { book ->
            book.authors.joinToString { it.name.lowercase() }.contains(authorName.lowercase())
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return library.filter { it.genre.equals(genre, true) }
    }
}
