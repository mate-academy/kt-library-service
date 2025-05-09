package mate.academy

import mate.academy.model.Author
import mate.academy.model.Book
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals

class LibraryServiceTest {

    private lateinit var libraryService: LibraryService

    @BeforeEach
    fun setUp() {
        libraryService = LibraryService()
    }

    private fun createBook(title: String, authorName: String, publicationYear: Int, genre: String, isbn: String): Book {
        return Book(
            title = title,
            authors = listOf(Author(name = authorName)),
            publicationYear = publicationYear,
            genre = genre,
            isbn = isbn
        )
    }

    @Test
    fun addBook_InitialLibrary_Empty() {
        // given (setup is done in @BeforeEach)

        // when
        val books = libraryService.searchByTitle("")

        // then
        assertTrue(books.isEmpty(), "Expected the library to be initialized with an empty book list.")
    }

    @Test
    fun addBook_SingleBook_AddedSuccessfully() {
        // given
        val book = createBook("Test Book", "Author Name", 2020, "Fiction", "12345")

        // when
        libraryService.addBook(book)
        val books = libraryService.searchByTitle("Test Book")

        // then
        assertTrue(books.contains(book), "The book should be added to the library.")
    }

    @Test
    fun addBook_MultipleBooks_AddedSuccessfully() {
        // given
        val book1 = createBook("Test Book 1", "Author Name 1", 2020, "Fiction", "12345")
        val book2 = createBook("Test Book 2", "Author Name 2", 2021, "Non-Fiction", "67890")

        // when
        libraryService.addBook(book1)
        libraryService.addBook(book2)
        val books = libraryService.searchByTitle("Test Book")

        // then
        assertTrue(books.containsAll(listOf(book1, book2)), "All added books should be present in the library.")
    }

    @Test
    fun addBook_SameBookMultipleTimes_AddedSuccessfully() {
        // given
        val book = createBook("Duplicate Book", "Author Name", 2020, "Fiction", "12345")

        // when
        libraryService.addBook(book)
        libraryService.addBook(book) // Adding the same book again
        val books = libraryService.searchByTitle("Duplicate Book")

        // then
        assertEquals(2, books.size, "The same book added multiple times should be present.")
    }

    @Test
    fun searchByTitle_FullTitle_ReturnsCorrectBooks() {
        // given
        val book = createBook("Unique Title", "Author Name", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByTitle("Unique Title")

        // then
        assertTrue(books.contains(book), "Search by full title should return the correct book.")
    }

    @Test
    fun searchByTitle_PartialTitle_ReturnsCorrectBooks() {
        // given
        val book = createBook("A Very Unique Title", "Author Name", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByTitle("Unique")

        // then
        assertTrue(books.contains(book), "Search by partial title should return the correct book.")
    }

    @Test
    fun searchByTitle_DifferentCaseTitle_ReturnsCorrectBooks() {
        // given
        val book = createBook("Case Sensitive Title", "Author Name", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByTitle("case sensitive title")

        // then
        assertTrue(books.contains(book), "Search by title with different case should return the correct book.")
    }

    @Test
    fun searchByTitle_NonexistentTitle_ReturnsNoBooks() {
        // given
        val book = createBook("Nonexistent Book Title", "Author Name", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByTitle("This Title Does Not Exist")

        // then
        assertTrue(books.isEmpty(), "Searching for a nonexistent title should return no books.")
    }

    @Test
    fun searchByTitle_EmptyString_ReturnsAllBooks() {
        // given
        val book1 = createBook("First Book", "Author One", 2020, "Fiction", "12345")
        val book2 = createBook("Second Book", "Author Two", 2021, "Non-Fiction", "67890")
        libraryService.addBook(book1)
        libraryService.addBook(book2)

        // when
        val books = libraryService.searchByTitle("")

        // then
        assertTrue(books.size == 2, "Searching with an empty string should return all books.")
    }

    @Test
    fun searchByAuthor_ExactAuthorName_ReturnsCorrectBooks() {
        // given
        val book = createBook("Title", "Exact Author", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByAuthor("Exact Author")

        // then
        assertTrue(books.contains(book), "Searching by exact author name should return correct books.")
    }

    @Test
    fun searchByAuthor_PartialAuthorName_ReturnsCorrectBooks() {
        // given
        val book = createBook("Title", "Author Name", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByAuthor("Author")

        // then
        assertTrue(books.contains(book), "Searching by partial author name should return correct books.")
    }

    @Test
    fun searchByAuthor_DifferentCaseAuthorName_ReturnsCorrectBooks() {
        // given
        val book = createBook("Title", "Case Sensitive Author", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByAuthor("case sensitive author")

        // then
        assertTrue(books.contains(book), "Searching by author name with different case should return correct books.")
    }

    @Test
    fun searchByAuthor_NonexistentAuthorName_ReturnsNoBooks() {
        // given
        val book = createBook("Title", "Nonexistent Author", 2020, "Fiction", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByAuthor("Unknown Author")

        // then
        assertTrue(books.isEmpty(), "Searching for a nonexistent author name should return no books.")
    }

    @Test
    fun searchByAuthor_MultipleAuthorsIncludingSearchedOne_ReturnsCorrectBooks() {
        // given
        val book = Book(
            title = "Title",
            authors = listOf(Author("First Author"), Author("Second Author")),
            publicationYear = 2020,
            genre = "Fiction",
            isbn = "12345"
        )
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByAuthor("Second Author")

        // then
        assertTrue(books.contains(book), "Searching by one of multiple authors should return correct books.")
    }

    @Test
    fun searchByGenre_ExactGenre_ReturnsCorrectBooks() {
        // given
        val book = createBook("Title", "Author", 2020, "Exact Genre", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByGenre("Exact Genre")

        // then
        assertTrue(books.contains(book), "Searching by exact genre should return correct books.")
    }

    @Test
    fun searchByGenre_DifferentCaseGenre_ReturnsCorrectBooks() {
        // given
        val book = createBook("Title", "Author", 2020, "Case Sensitive Genre", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByGenre("case sensitive genre")

        // then
        assertTrue(books.contains(book), "Searching by genre with different case should return correct books.")
    }

    @Test
    fun searchByGenre_NonexistentGenre_ReturnsNoBooks() {
        // given
        val book = createBook("Title", "Author", 2020, "Nonexistent Genre", "12345")
        libraryService.addBook(book)

        // when
        val books = libraryService.searchByGenre("Unknown Genre")

        // then
        assertTrue(books.isEmpty(), "Searching for a nonexistent genre should return no books.")
    }

    @Test
    fun searchByGenre_EmptyStringBehavior_CheckExpectedResult() {
        // given
        val book1 = createBook("Title1", "Author1", 2020, "Genre1", "12345")
        val book2 = createBook("Title2", "Author2", 2021, "Genre2", "67890")
        libraryService.addBook(book1)
        libraryService.addBook(book2)

        // when
        val books = libraryService.searchByGenre("")

        // then
        // This test outcome depends on the expected behavior when searching by an empty string for genre
        assertTrue(books.isEmpty(), "Searching by an empty genre string should return no books.")
    }

    @Test
    fun bookClass_UsesDataClass_AssertsTrue() {
        val bookClass = Book::class
        assertTrue(bookClass.isData, "Book class should be a data class.")
    }

    @Test
    fun authorClass_UsesDataClass_AssertsTrue() {
        val authorClass = Author::class
        assertTrue(authorClass.isData, "Author class should be a data class.")
    }
}
