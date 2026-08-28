package mate.academy

class LibraryService {
    private val library = mutableListOf<Book>()

    fun addBook(book: Book) {
        library.add(book)
    }

    fun searchByTitle(title: String) = library.filter { it.title.contains(title, true) }

    fun searchByAuthor(authorName: String) =
        library.filter { it.authors.any() { it.name.contains(authorName, true) } }

    fun searchByGenre(genre: String) = library.filter { it.genre.equals(genre, true) }
}

data class Book(
    val title: String,
    val authors: List<Author>,
    val publicationYear: Int,
    val genre: String,
    val isbn: String
)

data class Author(val name: String)
