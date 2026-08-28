package mate.academy

class LibraryService {
    private var library = mutableListOf<Book>()
    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> = library.filter { it.title.contains(title, ignoreCase = true) }

    fun searchByAuthor(authorName: String): List<Book> {
        return library.filter { book ->
            book.authors.any { author -> author.name.contains(authorName, ignoreCase = true) }
        }
    }

    fun searchByGenre(genre: String): List<Book> = library.filter { it.genre.equals(genre, ignoreCase = true) }
}
