package com.sitelu.studios.stasisbreak;

public class ChoiceResult {
    private final int oldHealth;
    private final int appliedDamage;
    private final int oldXP;
    private final int appliedXP;
    private final String effectMessage;
    private final String itemReward;
    private final String itemDestroy;

    public ChoiceResult(
            int oldHealth, int appliedDamage,
            int oldXP, int appliedXP,
            String effectMessage, String itemReward, String itemDestroy) {
        this.oldHealth = oldHealth;
        this.appliedDamage = appliedDamage;
        this.oldXP = oldXP;
        this.appliedXP = appliedXP;
        this.effectMessage = effectMessage;
        this.itemReward = itemReward;
        this.itemDestroy = itemDestroy;
    }

    public ChoiceResult(
            int oldHealth, int appliedDamage,
            int oldXP, int appliedXP,
            String effectMessage) {
        this(oldHealth, appliedDamage, oldXP, appliedXP, effectMessage, null, null);
    }

    public int getOldHealth() {
        return oldHealth;
    }

    public int getAppliedDamage() {
        return appliedDamage;
    }

    public int getOldXP() {
        return oldXP;
    }

    public int getAppliedXP() {
        return appliedXP;
    }

    public String getEffectMessage() {
        return effectMessage;
    }

    public String getItemReward() {
        return itemReward;
    }

    public String getItemDestory() {
        return itemDestroy;
    }
}
