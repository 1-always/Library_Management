package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Patron implements Observer
{
private String name;
private String  Id;
private String email;
private List<Book> borrowedBooks;


public Patron(String name,String Id,String email,List<Book> borrowedBooks)

    {
    this.name=name;
    this.Id=Id;
    this.email=email;
    this.borrowedBooks= new ArrayList<>();
    }

    public String getName()
    {
    return this.name;
    }
    public void setName(String name)
    {
    this.name=name;
    }
    public String getId()
    {
    return this.Id;
    }
    public String getEmail()
    {
    return this.email;
    }
    public void setEmail(String email)
    {
    this.email=email;
    }
    public List<Book> getBorrowedBooks()
    {
    return this.borrowedBooks;
    }


    public void borrowBook(Book book) {
        if (borrowedBooks.contains(book)) {
            throw new IllegalStateException("Patron already borrowed this book.");
        }
        borrowedBooks.add(book);
    }

    public void returnBorrowedBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            throw new IllegalStateException("Patron cannot return a book they never borrowed.");
        }
        borrowedBooks.remove(book);
    }

    @Override
    public void update(String notification) {
        System.out.println(notification);
    }
}
