package mate.academy

class LibraryService {
    val lib = ArrayList<Book>()

    fun addBook(book: Book) {
        lib.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return lib.filter { it.title.contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return lib.filter { it.authors.any { it.name.contains(authorName, ignoreCase = true) } }
    }

    fun searchByGenre(genre: String): List<Book> {
        return lib.filter { it.genre.equals(genre, ignoreCase = true) }.toList()
    }
}
