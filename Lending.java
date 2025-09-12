package librarymanagement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lending {
   private LibraryManagement library;
   private ReservationSystem reservationSystem;
   private BookNotifier notifier;
   public Lending(LibraryManagement library) {}
   public Lending(LibraryManagement library, ReservationSystem reservationSystem, BookNotifier notifier)
    {
        this.library = library;
        this.reservationSystem = reservationSystem;
        this.notifier = notifier;

    }
    public void CheckOutBook(Book book ,Patron patron)
    {
        Patron p = library.searchPatronById(patron.getId());
        Book bk = library.searchBookByISBN((book.getISBN()));
        if(bk.getAvailable())
        {
            book.checkout();
            patron.borrowBook(book);
        }
        else
        {
            System.out.println("Book Not Available : Placing reservation for " + p.getName());
            reservationSystem.reserveBook(book.getISBN(), p);
            notifier.addObserver(p);
        }



    }

    public void returnBook(Book book,Patron patron)
    {
        Patron p = library.searchPatronById(patron.getId());
        Book book1 = library.searchBookByISBN((book.getISBN()));
        if(p != null && p.getBorrowedBooks().contains(book1))
        {
            book1.returnBook();
            p.returnborrowedBook(book1);
        }

        if(reservationSystem.hasReservations(book1.getISBN())) {
            Patron next = reservationSystem.getNextReservation(book1.getISBN());
            if(next != null) {
                notifier.notifyObservers("Book Returned" + book.getISBN() + " " + book.getTitle());
            }
        }
    }
}
