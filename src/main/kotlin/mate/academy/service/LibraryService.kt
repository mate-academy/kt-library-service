package mate.academy.service

import mate.academy.model.Book

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { book -> book.title.contains(title, ignoreCase = true) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        var result: MutableList<Book> = mutableListOf()
        for (book in books) {
            for (author in book.authors) {
                if (author.name.contains(authorName, ignoreCase = true)) {
                    result.add(book)
                }
            }
        }
        return result
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.length === 0) {
            return listOf()
        }
        return books.filter { book -> book.genre.contains(genre, ignoreCase = true) }
    }
}
