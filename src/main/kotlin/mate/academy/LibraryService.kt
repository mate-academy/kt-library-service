package mate.academy

import models.Author
import models.Book



class LibraryService(private val books: MutableList<Book> = mutableListOf()) {

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.getTitle().contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter { book ->
            book.getAuthors().any { author -> author.getName().contains(authorName, ignoreCase = true) }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.getGenre().equals(genre, ignoreCase = true) }
    }
}
