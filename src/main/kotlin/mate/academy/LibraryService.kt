package mate.academy

class LibraryService {

    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        val query = title.lowercase()
        return books.filter { book -> book.title.lowercase().contains(query)
        }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        val query = authorName.lowercase()
        return books.filter { book -> book.authors.any { author ->
            author.name.lowercase().contains(query)
           }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        val query = genre.lowercase()
        return books.filter { book -> book.genre.lowercase() == query
        }
    }
}
