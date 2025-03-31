package com.sitelu.studios.stasisbreak;

import java.util.HashMap;
import java.util.Map;

public class ChoiceResult {
    private final int oldHealth;
    private final int appliedDamage;
    private final int oldXP;
    private final int appliedXP;
    private final String effectMessage;
    private final String itemReward;
    private final String itemDestroy;

    private int requiredHealth = 0;
    private int requiredXP = 0;
    private String requiredTool = null;
    private Map<String, Boolean> requiredFlagCondition = new HashMap<>();
    private String requiredMessage = null;
    private Map<String, Boolean> setFlagCondition = new HashMap<>();

    public ChoiceResult(
            int oldHealth, int appliedDamage,
            int oldXP, int appliedXP,
            String effectMessage, String itemReward, String itemDestroy,
            int requiredHealth, int requiredXP, String requiredTool,
            Map<String, Boolean> requiredFlagCondition, String requiredMessage,
            Map<String, Boolean> setFlagCondition) {
        this.oldHealth = oldHealth;
        this.appliedDamage = appliedDamage;
        this.oldXP = oldXP;
        this.appliedXP = appliedXP;
        this.effectMessage = effectMessage;
        this.itemReward = itemReward;
        this.itemDestroy = itemDestroy;
        this.requiredHealth = requiredHealth;
        this.requiredXP = requiredXP;
        this.requiredTool = requiredTool;
        this.requiredFlagCondition = requiredFlagCondition;
        this.requiredMessage = requiredMessage;
        this.setFlagCondition = setFlagCondition;
    }

    public ChoiceResult(
            int oldHealth, int appliedDamage,
            int oldXP, int appliedXP,
            String effectMessage) {
        this(oldHealth, appliedDamage, oldXP, appliedXP, effectMessage, null, null, 0, 0, null, new HashMap<>(), null,
                new HashMap<>());
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

    public int getRequiredHealth() {
        return requiredHealth;
    }

    public int getRequiredXP() {
        return requiredXP;
    }

    public String getRequiredTool() {
        return requiredTool;
    }

    public Map<String, Boolean> getRequiredFlagCondition() {
        return requiredFlagCondition;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public Map<String, Boolean> getSetFlagCondition() {
        return setFlagCondition;
    }
}
