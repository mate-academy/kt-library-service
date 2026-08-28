package mate.academy

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.lowercase().contains(title.lowercase()) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (book in books) {
            for (author in book.authors)
                if (author.name.lowercase().contains(authorName.lowercase())) {
                    result.add(book)
                    break
                }
        }
        return result
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.lowercase() == genre.lowercase() }
    }
}
