package mate.academy

class LibraryService {
    val books: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        val booksTitle: MutableList<Book> = mutableListOf()
        for (book in books) {
            if (book.title.lowercase().contains(title.lowercase())) {
                booksTitle.add(book)
            }
        }
        return booksTitle
    }


    fun searchByAuthor(authorName: String): List<Book> {
        val booksAuthor: MutableList<Book> = mutableListOf()
        for (book in books) {
            for (author in book.authors) {
                if (author.name.lowercase().contains(authorName.lowercase())) {
                    booksAuthor.add(book)
                }
            }
        }
        return booksAuthor
    }

    fun searchByGenre(genre: String): List<Book> {
        val booksGenre: MutableList<Book> = mutableListOf()
        for (book in books) {
            if (book.genre.lowercase() == genre.lowercase()) {
                booksGenre.add(book)
            }
        }
        return booksGenre
    }
}
