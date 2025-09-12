package librarymanagement;



public class BookFactory {
    public static Book createBook(String ISBN, String title, String author, String publicationYear, BookType type) {
        return new Book(title,author,ISBN,publicationYear,type);
    }
}
