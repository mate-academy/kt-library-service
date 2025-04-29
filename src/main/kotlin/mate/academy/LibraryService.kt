package mate.academy

class LibraryService {
    val library: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        if (title.isBlank()) {
            return library
        }
        return library.filter { it.title.trim().contains(title.trim(), ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        if (authorName.isBlank()) {
            return emptyList()
        }
        return library.filter { book ->
            book.authors.any {it.name.trim().contains(authorName.trim(), ignoreCase = true)}
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) {
            return emptyList()
        }
        return library.filter { it.genre.trim().contains(genre.trim(), ignoreCase = true) }
    }
}
