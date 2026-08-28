package mate.academy

class LibraryService {
    private val storage: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        storage.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return storage.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return storage.filter { book ->
            book.authors.any { author ->
                author.name.contains(authorName, ignoreCase = true)
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return storage.filter { it.genre.equals(genre, ignoreCase = true) }
    }
}
