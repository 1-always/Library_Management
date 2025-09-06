package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private LibraryManagement Library;
    public Inventory(LibraryManagement Library) {
        this.Library = Library;
    }
    public LibraryManagement getLibrary() {
        return Library;
    }
    public List<Book> listofAvailableBooks()
    {
        List<Book> availableBooks = new ArrayList<>();
        for (Book B : Library.getBooks())
        {
            if(B.getAvailable() == true)
            {
               availableBooks.add(B);
            }

        }
        return availableBooks;

    }
    public List<Book> listofBowrroedBooks()
    {
        List<Book> bowrroedBooks = new ArrayList<>();
        for (Book B : Library.getBooks())
        {
            if(B.getAvailable() == false)
            {
                bowrroedBooks.add(B);
            }

        }
        return  bowrroedBooks;

    }
}
