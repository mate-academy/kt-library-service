package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val library: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) = library.add(book)

    fun searchByTitle(title: String): List<Book> = if (title.isEmpty())
        library
    else library.filter { it.title.contains(title, true) }


    fun searchByAuthor(authorName: String): List<Book> = library
        .filter { it.authors.find { author -> author.name.contains(authorName, true) } != null }


    fun searchByGenre(genre: String): List<Book> = library
        .filter { it.genre.equals(genre, true) }

}
