# Library Management System

This repository contains a command-line based Library Management System written in Java. It provides functionalities for managing books and patrons, handling borrowing and returning processes, and a reservation system for unavailable books. The system demonstrates the use of several key design patterns, including the Factory and Observer patterns.

## Features

*   **Book Management**: Add, remove, update, and search for books by ISBN, title, or author.
*   **Patron Management**: Register new patrons, update their information, and manage their records.
*   **Inventory Control**: View lists of all available and currently borrowed books.
*   **Lending Operations**: Facilitates the process of checking out and returning books.
*   **Reservation System**: Allows patrons to place a hold on books that are currently checked out.
*   **Notification System**: Automatically notifies the next patron in the reservation queue when a book is returned.

## Design Patterns Used

*   **Factory Pattern**: The `BookFactory` class is used to abstract the creation of `Book` objects, providing a centralized point for creating book instances.
*   **Observer Pattern**: The system uses `Subject` and `Observer` interfaces to create a notification mechanism. The `BookNotifier` acts as the subject, and `Patron`s act as observers, allowing them to be notified when a reserved book becomes available.

## Core Components

*   `LibraryMain`: The main entry point for the application. It provides a text-based user interface to interact with the library system.
*   `LibraryManagement`: A central class that manages the collections of books and patrons. It provides methods for adding, removing, updating, and searching for books and patrons.
*   `Book`: Represents a book with properties like ISBN, title, author, and availability status.
*   `Patron`: Represents a library member. Each patron has an ID, name, and a list of borrowed books. Implements the `Observer` interface to receive notifications.
*   `Lending`: Contains the business logic for checking out and returning books, integrating with the reservation and notification systems.
*   `Inventory`: Provides methods to query the library's collection and generate lists of available or borrowed books.
*   `ReservationSystem`: Manages reservation queues for books. When a book is unavailable, patrons are added to a waiting list for that book's ISBN.
*   `BookFactory`: A simple factory for creating `Book` objects.
*   `BookNotifier`: The concrete implementation of the `Subject` interface. It maintains a list of `Observer`s (patrons) and notifies them when a book's status changes.
*   `Observer`/`Subject`: Interfaces defining the contract for the Observer design pattern.

## How to Run

### Prerequisites

*   Java Development Kit (JDK) 8 or higher.

### Compilation and Execution

1.  Navigate to the root directory of the project in your terminal.
2.  Compile all the Java source files:
    ```sh
    javac librarymanagement/*.java
    ```
3.  Run the main application:
    ```sh
    java librarymanagement.LibraryMain
    ```

## Usage Example

Once the application is running, you will be presented with a menu. Here is a sample workflow:

1.  **Add a Book**:
    *   Select option `1`.
    *   Enter the ISBN, title, author, and publication year for a new book.

2.  **Add a Patron**:
    *   Select option `2`.
    *   Enter the ID, name, and email for a new patron.

3.  **List Available Books**:
    *   Select option `3` to see the newly added book in the list of available books.

4.  **Borrow a Book**:
    *   Select option `5`.
    *   Enter the Patron ID and the ISBN of the book you want to borrow.
    *   If the book is available, it will be checked out to the patron.

5.  **List Borrowed Books**:
    *   Select option `4` to confirm the book is now listed as borrowed.

6.  **Return a Book**:
    *   Select option `6`.
    *   Enter the Patron ID and the ISBN of the book to be returned.
    *   The book's status will be updated to available. If other patrons have reserved it, the notification system will inform the next person in the queue.

7.  **Exit**:
    *   Select option `7` to close the application.




<img width="2400" height="1389" alt="diagram" src="https://github.com/user-attachments/assets/8489f96e-fb2d-454f-8e44-15bd305caaf8" />
