import java.util.*;

public class Item {
    private final String name;
    private Rarity rarity;
    private int count;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.count = 0;
    }

    public String getName() {
        return name;
    }
    public Rarity getRarity() {
        return rarity;
    }

    public int getCount() {
        return count;
    }

    public boolean upgrade(Inventory items) {
        int requiredItems;
        Rarity rarity1 = getRarity();

        if (rarity == Rarity.COMMON || rarity == Rarity.GREAT || rarity == Rarity.RARE) {
            requiredItems = 2;
        } else if (rarity == Rarity.EPIC) {
            if(count==2) {
                requiredItems = 2;
            } else{
                requiredItems = 1;
            }
        } else {
            System.out.println("Cannot upgrade!");
            return false;
        }

        int availableItems = countItemsOfSameType(items);
        if (availableItems < requiredItems + 1) {
            System.out.println("Not enough items to upgrade.");
            return false;
        }

        if (rarity == Rarity.COMMON) {
            rarity = Rarity.GREAT;
        } else if (rarity == Rarity.GREAT) {
            rarity = Rarity.RARE;
        } else if (rarity == Rarity.RARE) {
            rarity = Rarity.EPIC;
        } else if (rarity == Rarity.EPIC) {
            if(count < 2){
                count ++;
                removeUsedItems(items,rarity1, requiredItems);
                return true;
            } else{
                rarity = Rarity.LEGENDARY;
                System.out.println("Congratulations!!! You've reached Legendary!");
            }
        }
        count = 0;
        removeUsedItems(items, rarity1, requiredItems);
        return true;
    }

    private int countItemsOfSameType(Inventory inventory) {
        int count1 = 0;
        for (Item item : inventory) {
            if(this.rarity == Rarity.EPIC && count<2) {
                if (item.getRarity() == this.rarity) {
                    count1++;
                }
            } else{
                if (item.getName().equals(this.name) && item.getRarity() == this.rarity) {
                    count1++;
                }
            }
        }
        return count1;
    }

    private void removeUsedItems(Inventory items,Rarity rarity, int requiredItems) {
        int num = 0;
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext() && num < requiredItems) {
            Item item = iterator.next();
            if(this.rarity == rarity && this.count ==2) {
                if(item.getRarity()==rarity && item.getCount()!=2){
                    iterator.remove();
                }
            }
            else if(item.getRarity() == Rarity.EPIC && this.count!=item.getCount() ) {
                iterator.remove();
                num++;
            }
            else if (item.getName().equals(this.name) && item.getRarity() == rarity) {
                iterator.remove();
                num++;
            }
        }
    }

    @Override
    public String toString() {
        return name + " (" + rarity + (rarity == Rarity.EPIC && count>0 ? " " + count : "" ) + ")";
    }

}
