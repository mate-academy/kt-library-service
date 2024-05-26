package mate.academy

class LibraryService {
    private var books = mutableListOf<Book>()
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter { book ->
            book.authors.any { author -> author.name.contains(authorName, ignoreCase = true)}
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.lowercase() == genre.lowercase() }
    }
}
