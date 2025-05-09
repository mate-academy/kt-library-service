package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()
    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String) = library.filter { it.title.lowercase().contains(title.lowercase()) }


    fun searchByAuthor(authorName: String) = library.filter { book ->
        book.authors.joinToString { it.name.lowercase() }.contains(authorName.lowercase())
    }

    fun searchByGenre(genre: String) = library.filter { it.genre.equals(genre, true) }
}

data class Author(val name: String)

data class Book(
    val title: String,
    val authors: List<Author>,
    val publicationYear: Int,
    val genre: String,
    val isbn: String
)
