package com.sitelu.studios.stasisbreak;

public class ChoiceResult {
    private final int oldHealth;
    private final int appliedDamage;
    private final int oldXP;
    private final int appliedXP;
    private final String effectMessage;

    public ChoiceResult(int oldHealth, int appliedDamage, int oldXP, int appliedXP, String effectMessage) {
        this.oldHealth = oldHealth;
        this.appliedDamage = appliedDamage;
        this.oldXP = oldXP;
        this.appliedXP = appliedXP;
        this.effectMessage = effectMessage;
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
}
