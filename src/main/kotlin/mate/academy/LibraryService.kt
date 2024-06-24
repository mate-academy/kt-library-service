package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return library.filter { it.title.contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return library.filter { book -> book.authors.any { it.name.contains(authorName, ignoreCase = true) } }
    }

    fun searchByGenre(genre: String): List<Book> {
        return if (genre.isBlank()) emptyList() else library.filter { it.genre.contains(genre, ignoreCase = true) }
    }
}
