package mate.academy

class LibraryService {
    val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        val result = mutableListOf<Book>()
        books.forEach { book ->
            if (book.title.contains(title, ignoreCase = true)) {
                result.add(book)
            }
        }
        return result
    }


    fun searchByAuthor(authorName: String): List<Book> {
        val result = mutableListOf<Book>()
        for (book in books) {
            book.authors.forEach { author ->
                if (author.name.contains(authorName, ignoreCase = true)) {
                    result.add(book)
                }
            }
        }
        return result
    }

    fun searchByGenre(genre: String): List<Book> {
        val result = mutableListOf<Book>()
        books.forEach { book ->
            if (book.genre.equals(genre, ignoreCase = true)) {
                result.add(book)
            }
        }
        return result
    }
}
