import java.util.*;

public class Inventory {
    private Map<String, Integer> items = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        notifyObservers(item);
    }

    public void removeItem(String item, int quantity) {
        if (items.containsKey(item) && items.get(item) >= quantity) {
            items.put(item, items.get(item) - quantity);
            if (items.get(item) == 0) {
                items.remove(item);
            }
            notifyObservers(item);
        }
    }

    private void notifyObservers(String item) {
        for (Observer observer : observers) {
            observer.update(item, items.getOrDefault(item, 0));
        }
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public int getItemQuantity(String item) {
        return items.getOrDefault(item, 0);
    }
}