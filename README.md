# Library Service

In this task, you are to enhance a basic library management system in Kotlin by implementing several functions in the `LibraryService` class. 
This system allows for adding books to a library and searching them by title, author, or genre.

The `LibraryService` class already contains skeleton methods that you need to fill in. 
Additionally, you are provided with two data classes: `Book` and `Author`. A `Book` has a title, a list of authors, a publication year, a genre, and an ISBN number. An `Author` has a name.

Your task includes:

1. Create an `Author` class with a single field `name` of type String
2. Create a `Book` class with the following fields. Please put them in the order as described below: 
   - `title` of type `String`
   - `authors` of type `List<Author>`
   - `publicationYear` of type `Int`
   - `genre` of type `String`
   - `isbn` of type `String`
3. Implementing the `addBook(book: Book)` method to add a new book to the library. HINT: use some collection here. Book duplicates are allowed.
4. Implementing the `searchByTitle(title: String): List<Book>` method to return a list of books that contain the given title. The search should be case-insensitive.
5. Implementing the `searchByAuthor(authorName: String): List<Book>` method to return a list of books written by authors whose names contain the given string. This search should also be case-insensitive.
6. Implementing the `searchByGenre(genre: String): List<Book>` method to return a list of books that match the given genre exactly, with case-insensitivity.
