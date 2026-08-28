package mate.academy

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        val searchLower = title.lowercase()
        return books.filter { book ->
            book.title.lowercase().contains(searchLower)
        }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        val searchLower = authorName.lowercase()
        return books.filter { book ->
            book.authors.any { author ->
                author.name.lowercase().contains(searchLower)
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        val searchLower = genre.lowercase()
        return books.filter { book ->
            book.genre.lowercase() == searchLower
        }
    }
}
