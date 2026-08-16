package mate.academy

class LibraryService {
    val library: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        if (title == "")
            return library

        return library.filter { it.title.contains(title, true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
       return library.filter { book -> book.authors.any { it.name.contains(authorName, true) } }
    }

    fun searchByGenre(genre: String): List<Book> {
        return library.filter { it.genre.equals(genre, ignoreCase = true) }
    }
}

data class Author(val name: String)
data class Book(val title: String, val authors: List<Author>, val publicationYear: Int,
                val genre: String, val isbn: String)
