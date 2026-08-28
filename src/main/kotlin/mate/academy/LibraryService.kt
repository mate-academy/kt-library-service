package mate.academy

class LibraryService {
    private var books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, true)}
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter {
            it.authors.any {
                author -> author.name.contains(authorName, true)
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, true) }
    }
}
