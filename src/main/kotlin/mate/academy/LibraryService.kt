package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val library = mutableListOf<Book>()
    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> = library.filter {
        it.title.contains(title, true)
    }.toList()

    fun searchByAuthor(authorName: String): List<Book> = library.filter { book ->
        book.authors.any { author -> author.name.contains(authorName, true) }
    }.toList()

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) {
            return emptyList()
        }
        return library.filter { book ->
            book.genre.contains(genre, true)
        }.toList()
    }
}
