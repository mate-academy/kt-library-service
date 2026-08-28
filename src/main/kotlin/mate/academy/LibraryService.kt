package mate.academy

class LibraryService {
    val books = arrayListOf<Book>()

    fun addBook(book: Book) = books.add(book)

    fun searchByTitle(title: String): List<Book> {
        val titles = mutableListOf<Book>()
        for (t in books) {
            if (t.title.contains(title, ignoreCase = true)) {
                titles.add(t)
            }
        }
        return titles
    }

    fun searchByAuthor(authorName: String): List<Book> {
        val names = mutableListOf<Book>()
        for (n in books) {
            for (name in n.authors) {
                if (name.name.contains(authorName, ignoreCase = true)) {
                    names.add(n)
                }
            }
        }
        return names
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) {
            return emptyList()
        }
        val genres = mutableListOf<Book>()
        for (g in books) {
            if (g.genre.contains(genre, ignoreCase = true)) {
                genres.add(g)
            }
        }
        return genres
    }
}
