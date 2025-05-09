package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> = books.asSequence()
        .filter { it.title.contains(title, true) }
        .toList()

    fun searchByAuthor(authorName: String): List<Book> = books.asSequence()
        .filter { it.authors.any { it.name.contains(authorName, true) } }
        .toList()

    fun searchByGenre(genre: String): List<Book> = if(genre.isBlank()) emptyList()
        else books.asSequence()
            .filter { it.genre.contains(genre, true) }
            .toList()
}
