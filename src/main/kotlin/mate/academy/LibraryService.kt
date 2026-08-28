package mate.academy

class LibraryService {

    private val bookStorage: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        bookStorage.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return bookStorage.filter { it.title.uppercase()
                .contains(title.uppercase())
        }
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return bookStorage.filter { it.authors.any { author ->
                author.name.uppercase()
                    .contains(authorName.uppercase())
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return bookStorage.filter { it.genre.uppercase() == genre.uppercase() }
    }
}
