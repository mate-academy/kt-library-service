package mate.academy

import java.util.concurrent.CopyOnWriteArrayList

class LibraryService {
    private val books: MutableList<Book> = CopyOnWriteArrayList()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        if (title.isBlank()) return books

        val normalizedTitle = title.trim().lowercase()

        return books.filter { book ->
            book.title.lowercase().contains(normalizedTitle)
        }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        if (authorName.isBlank()) return emptyList()

        val normalizedAuthorName = authorName.trim().lowercase()

        return books.filter { book ->
            book.authors.any { author ->
                author.name.lowercase().contains(normalizedAuthorName)
            }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        if (genre.isBlank()) return emptyList()

        val normalizedGenre = genre.trim().lowercase()

        return books.filter { book ->
            book.genre.lowercase() == normalizedGenre
        }
    }
}

