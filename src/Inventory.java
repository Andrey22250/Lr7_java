import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    //здесь для разнообразия использую связные списки
    private LinkedList<BuildComp> items = new LinkedList<>();

    public Inventory() { }

    public int getItemCount() {
        return items.size();
    }

    public void addItem(BuildComp item) {
        items.add(item);
    }

    public void deleteItem(String name) {
        items.remove(searchComponent(name));
    }

    public void sortByComponentName() {
        Collections.sort(items, Comparator.comparing(BuildComp::getObjectName));
    }

    public void sortByName() {
        Collections.sort(items, Comparator.comparing(BuildComp::getName));
    }

    public BuildComp searchComponent(String name) {
        for (BuildComp item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Компонент не найден!");
    }

    public void print() {
        System.out.println("Список компонентов:");
        for (BuildComp item : items) {
            System.out.println(item.getObjectName() + ": " + item.getName());
        }
    }

    public Set<String> getTypesOfComponents() {
        Set<String> uniqueNames = new HashSet<>();
        for (BuildComp item : items) {
            uniqueNames.add(item.getObjectName());
        }
        return uniqueNames;
    }
}
