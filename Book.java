package librarymanagement;

public class Book {
    public String  title;
    public String author;
    public String ISBN;
    public int publicationYear;
    public boolean available;

public Book(String title, String author, String ISBN, int publicationYear, boolean available) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.publicationYear = publicationYear;
    this.available = available;
}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}
    public String getISBN() {return ISBN;}
    public int getPublicationYear() {return publicationYear;}
    public void setPublicationYear(int publicationYear) {this.publicationYear = publicationYear;}
    public boolean getAvailable() {return available;}


    public void checkout()
    {
      this.available = false;
    }
    public void returnBook()
    {
        this.available = true;
    }



}
