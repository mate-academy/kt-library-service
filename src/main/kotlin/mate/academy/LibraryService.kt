package mate.academy

class LibraryService {
    private val books: MutableList<Book> = mutableListOf();

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.lowercase().contains(title.lowercase())}
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter {
            book: Book -> book.authors.any {
                author: Author -> author.name.lowercase().contains(authorName.lowercase())
                && authorName.isNotEmpty()
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.lowercase().contains(genre.lowercase())
                && genre.isNotEmpty() }
    }
}

