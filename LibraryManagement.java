package librarymanagement;

import java.util.*;

public class LibraryManagement {
private List<Book> books;
private List<Patron> patrons;
private Map<String,Book> bookIndex = new HashMap<>();
private Map<String,Patron> patronIndex = new HashMap<>();

public LibraryManagement(List<Book> books, List<Patron> patrons) {
    this.books = new ArrayList<>(books);
    this.patrons = new ArrayList<>(patrons);
    for(Book book : books) {
        bookIndex.put(book.getISBN(),book);
    }
    for(Patron patron : patrons) {
        patronIndex.put(patron.getId(),patron);
    }


}

    public List<Book> getBooks() {
        return books;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    // -------------------------------Book Management Start------------------------------------------------
public void addBook(Book book) {
    if(bookIndex.containsKey(book.getISBN())) {
        throw new IllegalArgumentException("Book already with "+ book.getISBN()+ "exists");
    }
    this.books.add(book);
    bookIndex.put(book.getISBN(),book);

}
public void removeBook(Book book) {
    Book existingBook = searchBookByISBN(book.getISBN());
      if(existingBook!=null)
        {
            books.remove(existingBook);
            bookIndex.remove(existingBook.getISBN());
        }
      else{
          throw new IllegalArgumentException("Book does not found");
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
        else{
            throw new IllegalArgumentException("Book does not found");
        }


}

public Book searchBookByISBN(String ISBN) {
 return bookIndex.get(ISBN);
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

    if(patronIndex.containsKey(patron.getId())) {
    throw new IllegalArgumentException("Patron already exists");
    }
    patrons.add(patron);
    patronIndex.put(patron.getId(), patron);
}
public void removePatron(Patron patron) {
    Patron p = searchPatronById(patron.getId());
    if(p!=null)
    {
        patrons.remove(p);
        patronIndex.remove(p.getId());
    }
    else {
        throw new IllegalArgumentException("Patron does not exist");
    }

}

public void updatePatron(Patron updatedpatron) {
    Patron existingP = searchPatronById(updatedpatron.getId());
    if(existingP!=null)
    {
        existingP.setName(updatedpatron.getName());
        existingP.setEmail(updatedpatron.getEmail());
    }
    else {
        throw new IllegalArgumentException("Patron does not exist");
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

