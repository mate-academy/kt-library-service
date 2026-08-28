package mate.academy.model

data class Book(val title: String, val publicationYear: Int,
                    val genre: String, val isbn: String, val authors: List<Author>)
