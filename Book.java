package librarymanagement;

public class Book {
    public String  title;
    public String author;
    public String ISBN;
    public String publicationYear;
    public boolean available;
    public BookType type;

public Book(String title, String author, String ISBN, String publicationYear, BookType type) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.publicationYear = publicationYear;
    this.type = type;
}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getISBN() {return ISBN;}
    public String getPublicationYear() {return publicationYear;}
    public void setPublicationYear(String publicationYear) {this.publicationYear = publicationYear;}
    public boolean getAvailable() {return available;}

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public void checkout() {
        if (!available) {
            throw new IllegalStateException("Book" + title + " is not available");
        }
        this.available = false;
    }
    public void returnBook()
    {   if(available) {
        throw new IllegalStateException("Book" + title + " is already available");
    }
        this.available = true;
    }



}
