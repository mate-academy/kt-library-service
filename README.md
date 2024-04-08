
# Library Service

In this task, you will enhance a basic library management system in **Kotlin** by implementing several functions in the `LibraryService` class.

This system allows users to add books to their libraries and search for them by title, author, or genre. The `LibraryService` class already contains skeleton methods you must fill out.

Additionally, you are provided with two data classes: `Book` and `Author`.

 - A `Book` contains a **title, list of authors, publication date, genre,** and **ISBN** fields.
 - An `Author` data class has only one field, **name**.

##Instructions

1. Create an `Author` class with a single field `name` of type `String`.

2. Create a `Book` class with the fields described below. Please put them in the order as follows:

   - `title` of type `String`

   - `authors` of type `List<Author>`

   - `publicationYear` of type `Int`

   - `genre` of type `String`

   - `isbn` of type `String`

3. Implement the `addBook(book: Book)` method to add a new book to the library. 

💡**HINT:** use some collection here. Book duplicates are allowed.

4. Implement the `searchByTitle(title: String): List<Book>` method to return a list of books that contain the given title. The search should be case-insensitive.

5. Implement the `searchByAuthor(authorName: String): List<Book>` method to return a list of books written by authors whose names contain the given string. This search should also be case-insensitive.

6. Implement the `searchByGenre(genre: String): List<Book>` method to return a list of books that match the given genre exactly, with case-insensitivity.
