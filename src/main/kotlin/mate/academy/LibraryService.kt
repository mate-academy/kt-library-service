package mate.academy

data class Book(
    val title: String, val authors: List<Author>,
    val publicationYear: Int, val genre: String, val isbn: String)

data class Author(val name: String)

class LibraryService {
    val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        if (title.isEmpty()) {
            return books
        }
        return books.filter { it.title.lowercase().contains(title.lowercase()) }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        if (authorName.isEmpty()) {
            return emptyList()
        }
        return books.filter { b
            -> b.authors.any {
                author -> author.name.lowercase().contains(authorName.lowercase())
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isEmpty()) {
            return emptyList()
        }
        return books.filter { it.genre.lowercase().contains(genre.lowercase()) }
    }
}
