package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
private List<Book> books;
private List<Patron> patrons;

public LibraryManagement(List<Book> books, List<Patron> patrons) {
    this.books = new ArrayList<Book>();
    this.patrons = new ArrayList<Patron>();
}

    public List<Book> getBooks() {
        return books;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    // -------------------------------Book Management Start------------------------------------------------
public void addBook(Book book) {
    this.books.add(book);
}
public void removeBook(Book book) {
    Book existingBook = searchBookByISBN(book.getISBN());
      if(existingBook!=null)
        {
            books.remove(existingBook);
        }


}
public void updateBook(Book updatedbook)
{
    Book existingBook = searchBookByISBN(updatedbook.getISBN());

        if(existingBook != null)
        {
            existingBook.setTitle(updatedbook.getTitle());
            existingBook.setAuthor(updatedbook.getAuthor());
            existingBook.setPublicationYear(updatedbook.getPublicationYear());

        }


}

public Book searchBookByISBN(String ISBN) {
    for (Book bk :books)
    {
        if (bk.getISBN() == ISBN)
        {
            return bk;
        }
    }
    return null;
}
public  List<Book> searchBooksByTitle(String title) {

List<Book> existingbooks = new ArrayList<>();

    for (Book bk :books)
{
    if (bk.getTitle() == title)
    {
        existingbooks.add(bk);
    }

}

    return existingbooks;
}
public List<Book> searchBooksByAuthor(String author) {
    List<Book> existingbooks = new ArrayList<>();


    for (Book bk : books) {
        if (bk.getAuthor() == author) {
            existingbooks.add(bk);
        }

    }
    return existingbooks;
}
// ------------------------------------------Book Management End ----------------------------------------
//--------------------------------------------Patron Management Start -----------------------------------
public void addPatron(Patron patron) {
this.patrons.add(patron);
}
public void removePatron(Patron patron) {
    Patron p = searchPatronById(patron.getId());
    if(p!=null)
    {
        patrons.remove(p);
    }

}

public void updatePatron(Patron updatedpatron) {
    Patron existingP = searchPatronById(updatedpatron.getId());
    if(existingP!=null)
    {
        existingP.setName(updatedpatron.getName());
        existingP.setEmail(updatedpatron.getEmail());
    }
}
public Patron searchPatronById(String Id) {
    for(Patron patron : patrons)
    {
        if (patron.getId() == Id)
        {
            return patron;
        }

    }
    return null;

}
}

