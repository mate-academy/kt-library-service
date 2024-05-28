package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val libraryDB: MutableList<Book> = emptyList<Book>().toMutableList()

    fun addBook(book: Book) {
        libraryDB.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return libraryDB
            .filter { it.title.contains(title, true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        val result = libraryDB
            .filter { it.authors.any { author -> author.name.contains(authorName, true) } }
        return result
    }

    fun searchByGenre(genre: String): List<Book> {
        return libraryDB
            .filter { it.genre.equals(genre, true) }
    }
}
