package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> = library.filter { it.title.contains(title, true) }

    fun searchByAuthor(authorName: String): List<Book> =
        library.filter { book ->
            book.authors.any { author -> author.name.contains(authorName, true) }
        }

    fun searchByGenre(genre: String): List<Book> = library.filter { it.genre.equals(genre, true) }
}
