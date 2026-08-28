package mate.academy

class LibraryService {

    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> = books.filter { it.title.contains(title, ignoreCase = true) }


    fun searchByAuthor(authorName: String): List<Book> =
        books.filter {
            it.authors.any { author ->
                author.name.contains(authorName, ignoreCase = true)
            }
        }

    fun searchByGenre(genre: String): List<Book> = books.filter { it.genre.equals(genre, ignoreCase = true) }

}
