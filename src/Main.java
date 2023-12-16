import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new CPU("Intel Core i7-10700K"));
        inventory.addItem(new GPU("RTX 2070"));
        inventory.addItem(new CPU("AMD Ryzen 5 5600"));
        inventory.print();
        System.out.println();

        inventory.sortByComponentName();
        inventory.print();
        System.out.println();

        inventory.deleteItem("RTX 2070");
        inventory.sortByName();
        inventory.print();
        System.out.println();

        System.out.println(inventory.searchComponent("AMD Ryzen 5 5600"));
        System.out.println();

        Set<String> uniqueComponents = inventory.getTypesOfComponents();
        System.out.println("Виды компонентов:");
        for (String component : uniqueComponents) {
            System.out.println(component);
        }
    }
}