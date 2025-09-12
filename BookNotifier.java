package librarymanagement;

import java.util.ArrayList;
import java.util.List;

public class BookNotifier implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
   observers.remove(o);
    }

    @Override
    public void notifyObservers(String notification) {
      for(Observer o : observers){
          o.update(notification);
      }
    }
}
