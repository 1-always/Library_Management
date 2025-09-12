package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private LibraryManagement library;
    public Inventory(LibraryManagement library) {
        this.library = library;
    }
    public LibraryManagement getLibrary() {
        return library;
    }
    public List<Book> listOfAvailableBooks()
    {
        List<Book> availableBooks = new ArrayList<>();
        for (Book B : library.getBooks())
        {
            if(B.getAvailable())
            {
                availableBooks.add(B);
            }

        }
        return availableBooks;

    }
    public List<Book> listOfBorrowedBooks()
    {
        List<Book> borrowedBooks = new ArrayList<>();
        for (Book B : library.getBooks())
        {
            if(!B.getAvailable())
            {
                borrowedBooks.add(B);
            }

        }
        return borrowedBooks;

    }
}
