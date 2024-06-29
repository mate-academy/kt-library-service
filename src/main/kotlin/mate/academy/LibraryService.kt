package mate.academy

class LibraryService(
    private val books: MutableList<Book> = mutableListOf()
) {
    fun addBook(book: Book) = books.add(book)

    fun searchByTitle(title: String) = books.filter { it.title.contains(title, ignoreCase = true) }

    fun searchByAuthor(authorName: String) = books.filter {
        book -> book.authors.any { it.name.contains(authorName, ignoreCase = true) }
    }

    fun searchByGenre(genre: String) = books.filter { it.genre.equals(genre, ignoreCase = true)  }
}
