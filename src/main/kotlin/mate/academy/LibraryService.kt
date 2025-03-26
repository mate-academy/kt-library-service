package mate.academy

import mate.academy.model.Book

class LibraryService {
    var books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter{
            it.title.lowercase()
                .contains(title.lowercase())}
            .toList()
    }

    fun searchByAuthor(authorName: String): List<Book> {
        return books.filter{
            book -> book.authors.any{
                it.name.lowercase()
                    .contains(authorName.lowercase())}}
            .toList()
    }

    fun searchByGenre(genre: String): List<Book> {
        return books.filter{
            it.genre.lowercase() == genre.lowercase()}
            .toList()
    }
}
