package librarymanagement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lending {
   private LibraryManagement Library;
   public Lending(LibraryManagement Library)
    {
        this.Library = Library;

    }
    public void CheckOutBook(Book book ,Patron patron)
    {
        Patron p = Library.searchPatronById(patron.getId());
        Book bk = Library.searchBookByISBN((book.getISBN()));
        if(bk.getAvailable())
        {
            book.checkout();
            patron.borrowBook(book);
        }
        else
        {
            System.out.println("Book Not Available");
        }



    }

    public void returnBook(Book book,Patron patron)
    {
        Patron p = Library.searchPatronById(patron.getId());
        Book book1 = Library.searchBookByISBN((book.getISBN()));
        if(p.getBorrowedBooks().contains(book1));
        {
            book.returnBook();
            p.returnborrowedBook(book1);
        }
    }
}
