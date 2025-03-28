package com.sitelu.studios.stasisbreak;

public class Scene {
    private String description;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private Scene nextSceneA;
    private Scene nextSceneB;
    private Scene nextSceneC;
    private int damageA;
    private int damageB;
    private int damageC;
    private int XPA;
    private int XPB;
    private int XPC;

    public String getDescription() {
        return description;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public Scene getNextSceneA() {
        return nextSceneA;
    }

    public Scene getNextSceneB() {
        return nextSceneB;
    }

    public Scene getNextSceneC() {
        return nextSceneC;
    }

    public int getDamageA() {
        return damageA;
    }

    public int getDamageB() {
        return damageB;
    }

    public int getDamageC() {
        return damageC;
    }

    public int getXPA() {
        return XPA;
    }

    public int getXPB() {
        return XPB;
    }

    public int getXPC() {
        return XPC;
    }

    public Scene(String description, String choiceA, Scene nexSceneA, int damageA, int XPA, String choiceB,
            Scene nexSceneB, int damageB, int XPB, String choiceC, Scene nexSceneC, int damageC, int XPC) {
        this.description = description;
        this.choiceA = choiceA;
        this.nextSceneA = nexSceneA;
        this.damageA = damageA;
        this.XPA = XPA;
        this.choiceB = choiceB;
        this.nextSceneB = nexSceneB;
        this.damageB = damageB;
        this.XPB = XPB;
        this.choiceC = choiceC;
        this.nextSceneC = nexSceneC;
        this.damageC = damageC;
        this.XPC = XPC;
    }

    public void displayScene() {
        System.out.println(this.description + "\n");
        System.out.println("1: " + this.choiceA);
        System.out.println("2: " + this.choiceB);
        System.out.println("3: " + this.choiceC);
    }

    public Scene makeChoice(String choice, Character player) {

        if (choice == null) {
            return null;
        }

        switch (choice.toUpperCase()) {
            case "A":
                player.takeDamage(damageA);
                player.addXP(XPA);
                return this.nextSceneA;
            case "B":
                player.takeDamage(damageB);
                player.addXP(XPB);
                return this.nextSceneB;
            case "C":
                player.takeDamage(damageC);
                player.addXP(XPC);
                return this.nextSceneC;
            default:
                return null;
        }
    }

}
