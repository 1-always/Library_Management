package librarymanagement;

import java.util.*;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Core components
        LibraryManagement library = new LibraryManagement(new ArrayList<>(), new ArrayList<>());
        ReservationSystem reservationSystem = new ReservationSystem();
        BookNotifier notifier = new BookNotifier();
        Lending lending = new Lending(library, reservationSystem, notifier);
        Inventory inventory = new Inventory(library);

        while (true) {
            System.out.println("\n====== Library Management Menu ======");
            System.out.println("1. Add Book");
            System.out.println("2. Add Patron");
            System.out.println("3. List Available Books");
            System.out.println("4. List Borrowed Books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Publication Year: ");
                    String year = sc.nextLine();

                    Book newBook = BookFactory.createBook(isbn, title, author, year, BookType.DEFAULT);
                    newBook.returnBook(); // make available by default
                    library.addBook(newBook);

                    System.out.println("Book added successfully.");
                    break;

                case 2: // Add Patron
                    System.out.print("Enter Patron ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Enter Patron Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Patron Email: ");
                    String pemail = sc.nextLine();

                    Patron newPatron = new Patron(pname, pid, pemail, new ArrayList<>());
                    library.addPatron(newPatron);
                    System.out.println("Patron added successfully.");
                    break;

                case 3: // List Available Books
                    List<Book> available = inventory.listOfAvailableBooks();
                    if (available.isEmpty()) {
                        System.out.println("No available books.");
                    } else {
                        System.out.println("Available Books:");
                        for (Book b : available) {
                            System.out.println(b.getISBN() + " - " + b.getTitle());
                        }
                    }
                    break;

                case 4: // List Borrowed Books
                    List<Book> borrowed = inventory.listOfBorrowedBooks();
                    if (borrowed.isEmpty()) {
                        System.out.println("No borrowed books.");
                    } else {
                        System.out.println("Borrowed Books:");
                        for (Book b : borrowed) {
                            System.out.println(b.getISBN() + " - " + b.getTitle());
                        }
                    }
                    break;

                case 5: // Borrow Book
                    System.out.print("Enter Patron ID: ");
                    String borrowPid = sc.nextLine();
                    Patron borrower = library.searchPatronById(borrowPid);
                    if (borrower == null) {
                        System.out.println("Patron not found!");
                        break;
                    }
                    System.out.print("Enter ISBN of book to borrow: ");
                    String borrowIsbn = sc.nextLine();
                    Book borrowBook = library.searchBookByISBN(borrowIsbn);
                    if (borrowBook == null) {
                        System.out.println("Book not found!");
                        break;
                    }
                    lending.CheckOutBook(borrowBook, borrower);
                    break;

                case 6: // Return Book
                    System.out.print("Enter Patron ID: ");
                    String returnPid = sc.nextLine();
                    Patron returner = library.searchPatronById(returnPid);
                    if (returner == null) {
                        System.out.println("Patron not found!");
                        break;
                    }
                    System.out.print("Enter ISBN of book to return: ");
                    String returnIsbn = sc.nextLine();
                    Book returnBook = library.searchBookByISBN(returnIsbn);
                    if (returnBook == null) {
                        System.out.println("Book not found!");
                        break;
                    }
                    lending.returnBook(returnBook, returner);
                    System.out.println("Book returned successfully.");
                    break;

                case 7: // Exit
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
