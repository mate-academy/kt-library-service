package mate.academy

class LibraryService {
    private val ls = mutableListOf<Book>()

    fun addBook(book: Book) {
        ls.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return ls.filter { title.lowercase() in it.title.lowercase() }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return ls.filter { book ->
            book.authors.any { author -> authorName.lowercase() in author.name.lowercase()  }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return ls.filter { it.genre.lowercase() == genre.lowercase() }
    }
}
