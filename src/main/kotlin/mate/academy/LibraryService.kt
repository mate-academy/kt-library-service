package mate.academy

private const val TEST_PUBLISH_YEAR = 2020

fun main() {
    val libraryService = LibraryService()
    libraryService.addBook(Book("Book1", listOf(Author("Author1")), TEST_PUBLISH_YEAR, "Detective", "123456789"))
    libraryService.addBook(
        Book(
            "Title not for search",
            listOf(Author("Author2")),
            TEST_PUBLISH_YEAR,
            "Fantasy",
            "123456789"
        )
    )
    libraryService.addBook(Book("Book2", listOf(Author("Wrong")), TEST_PUBLISH_YEAR, "Fantasy", "123456789"))
    println(libraryService.searchByAuthor("Author"))
    println(libraryService.searchByTitle("Book"))
    println(libraryService.searchByGenre("Fantasy"))
}

class LibraryService {
    private val books: MutableList<Book> = mutableListOf()
    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { book: Book -> book.title.lowercase().contains(title.lowercase()) }
            .toList()
    }


    fun searchByAuthor(authorName: String): List<Book> {
        val booksFromAuthor: MutableList<Book> = mutableListOf()
        for (book in books) {
            for (author in book.authors) {
                if (author.name.contains(authorName)) {
                    booksFromAuthor.add(book)
                }
            }
        }
        return booksFromAuthor.toList()
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { book: Book -> book.genre.lowercase() == genre.lowercase() }
            .toList()
    }
}
