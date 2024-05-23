package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val books : MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, true) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        val booksByAuthor : MutableList<Book> = mutableListOf()
        for (book in books) {
            val authorNames = book.authors.map { it.name }
            for (name in authorNames) {
                if (name.contains(authorName, true)) {
                    booksByAuthor.add(book)
                }
            }
        }
        return booksByAuthor
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, true) }
    }
}
