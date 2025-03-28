package com.sitelu.studios.stasisbreak;

public class Character {

    private String name;
    private int XP;
    private int health;
    private String item;

    /**
     * @param name
     * @param health
     */
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.XP = 0;
        this.item = null;
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

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    /**
     * Reduce Health by damage amount
     * If damage exceeds Health, set Health to 0
     * 
     * @param damage
     * @return the updated health after applying the damage
     */
    public int takeDamage(int damage) {
        int newHelath = this.health - damage;
        this.health = (damage >= this.health) ? 0 : newHelath;
        return this.health;
    }

    /**
     * Add XP by the set amount
     * 
     * @param xp
     * @return theupdated XP after adding the gained xp
     */
    public int addXP(int xp) {
        this.XP += xp;
        return this.XP;
    }

}
