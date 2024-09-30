package mate.academy

class LibraryService {
    private val allBooks: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        allBooks.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return allBooks.filter { it.title.lowercase().contains(title.lowercase()) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return allBooks.filter { book -> book.authors.any {it.name.lowercase().contains(authorName.lowercase())} }
    }

    fun searchByGenre(genre: String): List<Book> {
        return allBooks.filter { it.genre.lowercase() == genre.lowercase() }
    }
}
