package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val library: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) = library.add(book)

    fun searchByTitle(title: String): List<Book> = library.filter { it.title.contains(title,true) }


    fun searchByAuthor(authorName: String): List<Book> = library.filter {
        it.authors.any { it.name.contains(authorName, true) }
    }

    fun searchByGenre(genre: String): List<Book> = library.filter { it.genre.equals(genre, true) }
}
