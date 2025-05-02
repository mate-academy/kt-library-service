package mate.academy

import mate.academy.model.Book

class LibraryService {
    private val listOfBooks = mutableListOf<Book>()

    fun addBook(book: Book) {
        listOfBooks.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return listOfBooks.filter { it.title.contains(title, ignoreCase = true) }
    }


    fun searchByAuthor(authorName: String): List<Book> {
        return listOfBooks.filter {it.authors
                .any{it.name.contains(authorName, ignoreCase = true)} }
    }

    fun searchByGenre(genre: String): List<Book> {
        return listOfBooks.filter { it.genre.equals(genre, ignoreCase = true) }
    }
}
