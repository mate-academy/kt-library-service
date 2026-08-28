package mate.academy

class LibraryService {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) = books.add(book)

    fun searchByTitle(title: String) = books.filter { it.title.contains(title, true) }

    fun searchByAuthor(authorName: String) =
        books.filter { it.authors.any {author ->  author.name.contains(authorName, true) } }

    fun searchByGenre(genre: String) = books.filter { it.genre.equals(genre, true) }
}
