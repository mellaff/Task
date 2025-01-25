# Inventory Upgrade System

This program simulates an inventory system where items can be upgraded through a series of rarity levels (from **COMMON** to **LEGENDARY**). Items are grouped by their name and rarity, and upgrades are performed when enough items of the same type and rarity are available.

## Assumptions and Design Choices

*   **Item Rarity Levels:** Each item has a rarity (COMMON, GREAT, RARE, EPIC, LEGENDARY). Items can be upgraded based on their rarity. A COMMON item requires two items to upgrade to GREAT, GREAT requires two to upgrade to RARE, and so on.
*   **Item Count:** Each item has a count (e.g., for EPIC items) that tracks how many items of the same type and rarity are available for upgrading.
*   **Upgrade Logic:** When an upgrade is successful, the items used for the upgrade are removed from the inventory.
*   **Grouping Items:** Items are grouped by their **name** and **rarity** in the inventory. This is helpful for displaying and managing the items by categories.

## Features

1.  **Add Items to Inventory:** You can add items of various rarities to the inventory.
2.  **Item Upgrade:** Items can be upgraded to the next rarity if the required amount of items are present.
3.  **Item Grouping:** Items can be grouped by their name and rarity for easier tracking.
4.  **Display Inventory:** The current state of the inventory can be displayed.
