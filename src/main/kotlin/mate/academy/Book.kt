package mate.academy

data class Book(
    val authors: List<Author>,
    val genre: String,
    val isbn: String,
    val publicationYear: Int,
    val title: String
)
