package mate.academy

import mate.academy.data.Book

class LibraryService(val books: MutableList<Book> = mutableListOf<Book>()) {

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter {
            it.authors.any { a -> a.name.contains(authorName, true) }
        }
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter { it.genre.equals(genre, true) }
    }
}
