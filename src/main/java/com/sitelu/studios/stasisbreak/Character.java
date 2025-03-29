package com.sitelu.studios.stasisbreak;

public class Character {

    private String name;
    private int XP;
    private int health;
    private String items;

    /**
     * @param name
     * @param health
     */
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.XP = 0;
        this.items = "";
    }

    public String getName() {
        return name;
    }

    public int getXP() {
        return XP;
    }

    public int getHealth() {
        return health;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getItems() {
        return items;
    }

    /**
     * Adds an item to character items list
     * If list is emptry, item added as is
     * else appends after comma
     * 
     * @param item to add
     */
    public void addItem(String item) {
        if (items.isEmpty()) {
            items = item.trim();
        } else {
            items += ", " + item.trim();
        }
    }

    /**
     * Remove specified item form character items list
     * ignore case, remove if the item is found
     * 
     * @param item to remove
     */
    public void removeItem(String item) {
        if (items.isEmpty()) {
            return;
        }
        String[] parts = items.split(",");
        StringBuilder newItems = new StringBuilder();
        for (String part : parts) {

            if (!part.trim().equalsIgnoreCase(item.trim())) {
                if (newItems.length() > 0) {
                    newItems.append(", ");
                }
                newItems.append(part.trim());
            }
        }
        items = newItems.toString();
    }

    public boolean hasItem(String itemName) {
        if (items.isEmpty())
            return false;

        String[] parts = items.split(",");
        for (String part : parts) {
            if (part.trim().equalsIgnoreCase(itemName.trim()))
                return true;
        }
        return this.items.equalsIgnoreCase(itemName);
    }

    /**
     * Reduce Health by damage amount
     * If damage exceeds Health, set Health to 0
     * 
     * @param damage
     * @return updated health after applying damage
     */
    public int takeDamage(int damage) {
        int newHelath = this.health - damage;
        this.health = (damage >= this.health) ? 0 : newHelath;
        return this.health;
    }

    /**
     * Add XP by set amount
     * 
     * @param xp
     * @return updated XP after adding gained XP
     */
    public int addXP(int xp) {
        this.XP += xp;
        return this.XP;
    }

}
