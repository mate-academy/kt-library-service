package mate.academy

class LibraryService {
    private val bookList = mutableListOf<Book>()
    fun addBook(book: Book) {
        bookList.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return bookList.filter { it.title.contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return bookList.filter { book -> book.authors.any() { it.name.contains(authorName, ignoreCase = true)} }
    }

    fun searchByGenre(genre: String): List<Book> {
        return bookList.filter { it.genre.equals(genre, ignoreCase = true) }
    }
}
