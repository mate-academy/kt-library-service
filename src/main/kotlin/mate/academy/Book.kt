package mate.academy

data class Book(
    val title : String,
    val authors : List<Author>,
    val publicationYear : Int,
    val genre : String,
    val isbn : String
)