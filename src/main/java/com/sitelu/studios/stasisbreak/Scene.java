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

    private String itemRewardA;
    private String itemRewardB;
    private String itemRewardC;

    private String itemDestroyA;
    private String itemDestroyB;
    private String itemDestroyC;

    private ChoiceResult lastChoiceResult;

    public String getEffectMessageA() {
        return effectMessageA;
    }

    public void setEffectMessageA(String effectMessageA) {
        this.effectMessageA = effectMessageA;
    }

    public String getEffectMessageB() {
        return effectMessageB;
    }

    public void setEffectMessageB(String effectMessageB) {
        this.effectMessageB = effectMessageB;
    }

    public String getEffectMessageC() {
        return effectMessageC;
    }

    public void setEffectMessageC(String effectMessageC) {
        this.effectMessageC = effectMessageC;
    }

    public String getItemRewardA() {
        return itemRewardA;
    }

    public void setItemRewardA(String itemRewardA) {
        this.itemRewardA = itemRewardA;
    }

    public String getItemRewardB() {
        return itemRewardB;
    }

    public void setItemRewardB(String itemRewardB) {
        this.itemRewardB = itemRewardB;
    }

    public String getItemRewardC() {
        return itemRewardC;
    }

    public void setItemRewardC(String itemRewardC) {
        this.itemRewardC = itemRewardC;
    }

    public String getItemDestroyA() {
        return itemDestroyA;
    }

    public void setItemDestroyA(String itemDestroyA) {
        this.itemDestroyA = itemDestroyA;
    }

    public String getItemDestroyB() {
        return itemDestroyB;
    }

    public void setItemDestroyB(String itemDestroyB) {
        this.itemDestroyB = itemDestroyB;
    }

    public String getItemDestroyC() {
        return itemDestroyC;
    }

    public void setItemDestroyC(String itemDestroyC) {
        this.itemDestroyC = itemDestroyC;
    }

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

    public void setNextSceneA(Scene scene) {
        this.nextSceneA = scene;
    }

    public Scene getNextSceneB() {
        return nextSceneB;
    }

    public void setNextSceneB(Scene scene) {
        this.nextSceneB = scene;
    }

    public Scene getNextSceneC() {
        return nextSceneC;
    }

    public void setNextSceneC(Scene scene) {
        this.nextSceneC = scene;
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
            String choiceA, Scene nextSceneA, int damageA, int XPA, String effectMessageA, String itemRewardA,
            String itemDestroyA,
            String choiceB, Scene nextSceneB, int damageB, int XPB, String effectMessageB, String itemRewardB,
            String itemDestroyB,
            String choiceC, Scene nextSceneC, int damageC, int XPC, String effectMessageC, String itemRewardC,
            String itemDestroyC) {
        this.description = description;
        this.choiceA = choiceA;
        this.nextSceneA = nextSceneA;
        this.damageA = damageA;
        this.XPA = XPA;
        this.effectMessageA = effectMessageA;
        this.itemRewardA = itemRewardA;
        this.itemDestroyA = itemDestroyA;
        this.choiceB = choiceB;
        this.nextSceneB = nextSceneB;
        this.damageB = damageB;
        this.XPB = XPB;
        this.effectMessageB = effectMessageB;
        this.itemRewardB = itemRewardB;
        this.itemDestroyB = itemDestroyB;
        this.choiceC = choiceC;
        this.nextSceneC = nextSceneC;
        this.damageC = damageC;
        this.XPC = XPC;
        this.effectMessageC = effectMessageC;
        this.itemRewardC = itemRewardC;
        this.itemDestroyC = itemDestroyC;
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA, String effectMessageA,
            String choiceB, Scene nextSceneB, int damageB, int XPB, String effectMessageB,
            String choiceC, Scene nextSceneC, int damageC, int XPC, String effectMessageC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, effectMessageA, null, null,
                choiceB, nextSceneB, damageB, XPB, effectMessageB, null, null,
                choiceC, nextSceneC, damageC, XPC, effectMessageC, null, null);
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA,
            String choiceB, Scene nextSceneB, int damageB, int XPB,
            String choiceC, Scene nextSceneC, int damageC, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, null, null, null,
                choiceB, nextSceneB, damageB, XPB, null, null, null,
                choiceC, nextSceneC, damageC, XPC, null, null, null);
    }

    public Scene(
            String description,
            String choiceA, String choiceB, String choiceC,
            Scene nextSceneA, Scene nextSceneB, Scene nextSceneC,
            int damageA, int damageB, int damageC,
            int XPA, int XPB, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, null, null, null,
                choiceB, nextSceneB, damageB, XPB, null, null, null,
                choiceC, nextSceneC, damageC, XPC, null, null, null);
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
        String itemReward = null;
        String itemDestroy = null;

        switch (choice.toUpperCase()) {
            case "A":
                appliedDamage = damageA;
                appliedXP = XPA;
                effectMessage = effectMessageA;
                itemReward = itemRewardA;
                itemDestroy = itemDestroyA;
                break;
            case "B":
                appliedDamage = damageB;
                appliedXP = XPB;
                effectMessage = effectMessageB;
                itemReward = itemRewardB;
                itemDestroy = itemDestroyB;
                break;
            case "C":
                appliedDamage = damageC;
                appliedXP = XPC;
                effectMessage = effectMessageC;
                itemReward = itemRewardC;
                itemDestroy = itemDestroyC;
                break;
            default:
                return null;
        }

        int oldHealth = player.getHealth();
        int oldXP = player.getXP();

        player.takeDamage(appliedDamage);
        player.addXP(appliedXP);

        if (itemReward != null && !itemReward.isEmpty()) {
            // System.out.println("You received an item: " + itemReward);
            player.addItem(itemReward);
        }

        if (itemDestroy != null && !itemDestroy.isEmpty()) {
            // System.out.println("An item was destroyed: " + itemDestroy);
            player.removeItem(itemDestroy);
        }

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
