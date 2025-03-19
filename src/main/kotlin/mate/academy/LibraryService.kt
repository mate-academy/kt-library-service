package mate.academy

class LibraryService {
    val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { e -> e.title.contains(title, true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter { b -> b.authors.filter { a -> a.name.contains(authorName, true) }.isNotEmpty() }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) {
            return listOf()
        }
        return books.filter { e -> e.genre.contains(genre, true) }
    }
}
