package librarymanagement;
import java.util.*;

public class ReservationSystem {

        private Map<String, Queue<Patron>> reservations = new HashMap<>();


    public void reserveBook(String ISBN, Patron patron) {
        if (!reservations.containsKey(ISBN)) {
            reservations.put(ISBN, new LinkedList<>());
        }
        reservations.get(ISBN).add(patron);
        System.out.println(patron.getName() + " reserved book " + ISBN);
    }



    public Patron getNextReservation(String ISBN) {
            Queue<Patron> queue = reservations.get(ISBN);
            if (queue != null && !queue.isEmpty()) {
                return queue.poll();
            }
            return null;
        }

        // Check if book has reservations
        public boolean hasReservations(String ISBN) {
            Queue<Patron> queue = reservations.get(ISBN);
            return queue != null && !queue.isEmpty();
        }
    }
