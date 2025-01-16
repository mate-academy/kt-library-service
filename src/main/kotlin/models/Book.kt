package models

data class Book(private var title: String,
           private var authors: List<Author>,
           private var publicationYear: Int,
           private var genre: String,
           private var isbn: String) {
    fun getTitle(): String {
        return title
    }

    fun getAuthors(): List<Author> {
        return authors
    }

    fun getPublicationYear(): Int {
        return publicationYear
    }

    fun getGenre(): String {
        return genre
    }

    fun getIsbn(): String {
        return isbn
    }

    fun setTitle(newTitle: String) {
        title = newTitle
    }

    fun setAuthors(newAuthors: List<Author>) {
        authors = newAuthors
    }

    fun setPublicationYear(newPublicationYear: Int) {
        publicationYear = newPublicationYear
    }

    fun setGenre(newGenre: String) {
        genre = newGenre
    }

    fun setIsbn(newIsbn: String) {
        isbn = newIsbn
    }
}
