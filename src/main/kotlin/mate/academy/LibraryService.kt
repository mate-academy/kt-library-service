package mate.academy

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return findAllByTitle(title)
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return findAllByAuthor(authorName)
    }

    fun searchByGenre(genre: String): List<Book> {
        return findAllByGenre(genre)
    }

    private fun findAllByGenre(genre: String): List<Book> {
        return this.books.filter { it.genre.uppercase() == (genre.uppercase()) }.toList()
    }

    private fun findAllByAuthor(authorName: String): List<Book> {
        return this.books
            .filter { book: Book -> getListAuthorsName(book).contains(authorName.uppercase())
                    || getListAuthorsName(book).flatMap { it.split(" ")}.contains(authorName.uppercase()) }
            .toList()
    }

    private fun getListAuthorsName(book: Book): List<String> {
        return book.authors.map { it.name.uppercase() }
    }

    private fun findAllByTitle(title: String): List<Book> {
        return this.books.filter { it.title.uppercase().contains(title.uppercase()) }.toList()
    }
}
