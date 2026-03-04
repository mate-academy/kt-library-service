package mate.academy

class LibraryService {
    val library = mutableListOf<Book>()

    fun addBook(book: Book) {
       library.add(book)
    }

    fun searchByTitle(title: String): List<Book> =
         library.filter { it.title.contains(title,
             ignoreCase = true) }.toList()



    fun searchByAuthor(authorName: String): List<Book> =
        library.filter { book -> book.authors.any {
            it.name.contains(authorName,
                ignoreCase = true) }
    }

    fun searchByGenre(genre: String): List<Book> =
        library.filter { it.genre.equals(genre,
        ignoreCase = true)}
}
