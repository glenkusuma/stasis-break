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

    private String effectMessageA;
    private String effectMessageB;
    private String effectMessageC;

    private ChoiceResult lastChoiceResult;

    public ChoiceResult getLastChoiceResult() {
        return lastChoiceResult;
    }

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

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA, String effectMessageA,
            String choiceB, Scene nextSceneB, int damageB, int XPB, String effectMessageB,
            String choiceC, Scene nextSceneC, int damageC, int XPC, String effectMessageC) {
        this.description = description;
        this.choiceA = choiceA;
        this.nextSceneA = nextSceneA;
        this.damageA = damageA;
        this.XPA = XPA;
        this.choiceB = choiceB;
        this.nextSceneB = nextSceneB;
        this.damageB = damageB;
        this.XPB = XPB;
        this.choiceC = choiceC;
        this.nextSceneC = nextSceneC;
        this.damageC = damageC;
        this.XPC = XPC;
        this.effectMessageA = effectMessageA;
        this.effectMessageB = effectMessageB;
        this.effectMessageC = effectMessageC;
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA,
            String choiceB, Scene nextSceneB, int damageB, int XPB,
            String choiceC, Scene nextSceneC, int damageC, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, "",
                choiceB, nextSceneB, damageB, XPB, "",
                choiceC, nextSceneC, damageC, XPC, "");
    }

    public Scene(
            String description,
            String choiceA, String choiceB, String choiceC,
            Scene nextSceneA, Scene nextSceneB, Scene nextSceneC,
            int damageA, int damageB, int damageC,
            int XPA, int XPB, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, "",
                choiceB, nextSceneB, damageB, XPB, "",
                choiceC, nextSceneC, damageC, XPC, "");
    }

    public void displayScene() {
        System.out.println(this.description + "\n");
        System.out.println("1: " + this.choiceA);
        System.out.println("2: " + this.choiceB);
        System.out.println("3: " + this.choiceC);
    }

    public Scene makeChoice(String choice, Character player) {

        if (choice == null || player == null) {
            return null;
        }

        // apply the choice effect and save the result
        ChoiceResult result = applyChoiceEffect(choice, player);
        if (result == null) {
            return null;
        }
        this.lastChoiceResult = result;

        return getNextScene(choice);
    }

    public ChoiceResult applyChoiceEffect(String choice, Character player) {
        if (choice == null || player == null) {
            return null;
        }

        int appliedDamage;
        int appliedXP;
        String effectMessage;

        switch (choice.toUpperCase()) {
            case "A":
                appliedDamage = damageA;
                appliedXP = XPA;
                effectMessage = effectMessageA;
                break;
            case "B":
                appliedDamage = damageB;
                appliedXP = XPB;
                effectMessage = effectMessageB;
                break;
            case "C":
                appliedDamage = damageC;
                appliedXP = XPC;
                effectMessage = effectMessageC;
                break;
            default:
                return null;
        }

        int oldHealth = player.getHealth();
        int oldXP = player.getXP();

        player.takeDamage(appliedDamage);
        player.addXP(appliedXP);

        return new ChoiceResult(oldHealth, appliedDamage, oldXP, appliedXP, effectMessage);
    }

    public Scene getNextScene(String choice) {
        switch (choice.toUpperCase()) {
            case "A":
                return this.nextSceneA;
            case "B":
                return this.nextSceneB;
            case "C":
                return this.nextSceneC;
            default:
                return null;
        }
    }

}
