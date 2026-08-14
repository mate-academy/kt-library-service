package mate.academy

class LibraryService {
    private val allBooks = mutableListOf<Book>()
    fun addBook(book: Book) {
        allBooks.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return allBooks.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return allBooks.filter {
            it.authors.any() { author ->
                author.name.contains(authorName, ignoreCase = true)
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return if (genre.isBlank()) emptyList() else allBooks.filter {
            it.genre.contains(genre, ignoreCase = true)
        }
    }
}
