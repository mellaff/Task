import java.util.*;

public class Inventory implements Iterable<Item> {

    List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void inventoryDisplay() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Map<String, Map<Rarity, List<Item>>> groupItems() {
        Map<String, Map<Rarity, List<Item>>> groupedItems = new HashMap<>();

        for (Item item : items) {
            groupedItems
                    .computeIfAbsent(item.getName(), k -> new HashMap<>())
                    .computeIfAbsent(item.getRarity(), k -> new ArrayList<>())
                    .add(item);
        }

        return groupedItems;
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

}
