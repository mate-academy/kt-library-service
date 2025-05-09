package mate.academy.model

data class Book(
    var title: String,
    var authors: List<Author>,
    var publicationYear: Int,
    var genre: String,
    var isbn: String)
