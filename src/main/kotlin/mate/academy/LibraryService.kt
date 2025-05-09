package mate.academy

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { book: Book -> book.title.lowercase().contains(title.lowercase()) }
            .toList()
    }


    fun searchByAuthor(authorName: String): List<Book> {
        val booksFromAuthor: MutableList<Book> = mutableListOf()
        for (book in books) {
            for (author in book.authors) {
                if (author.name.lowercase().contains(authorName.lowercase())) {
                    booksFromAuthor.add(book)
                }
            }
        }
        return booksFromAuthor.toList()
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { book: Book -> book.genre.lowercase() == genre.lowercase() }
            .toList()
    }
}
