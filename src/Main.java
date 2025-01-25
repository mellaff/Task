import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item sword1 = new Item("Iron Sword", Rarity.COMMON);
        Item sword2 = new Item("Iron Sword", Rarity.COMMON);
        Item sword3 = new Item("Iron Sword", Rarity.COMMON);

        inventory.addItem(sword1);
        inventory.addItem(sword2);
        inventory.addItem(sword3);

        inventory.inventoryDisplay();
        sword2.upgrade(inventory);
        inventory.inventoryDisplay();

        Item sword4 = new Item("Iron Sword", Rarity.GREAT);
        Item sword5 = new Item("Iron Sword", Rarity.GREAT);
        inventory.addItem(sword4);
        inventory.addItem(sword5);

        sword4.upgrade(inventory);
        inventory.inventoryDisplay();

        Item sword6 = new Item("Iron Sword", Rarity.EPIC);
        inventory.addItem(sword6);

        sword6.upgrade(inventory);
        inventory.inventoryDisplay();

        Item sword7 = new Item("Iron Sword", Rarity.EPIC);

        inventory.addItem(sword7);
        sword7.upgrade(inventory);
        inventory.inventoryDisplay();

        Item sword8 = new Item("Iron Sword", Rarity.EPIC);
        inventory.addItem(sword8);
        sword7.upgrade(inventory);
        inventory.inventoryDisplay();

   }
}
