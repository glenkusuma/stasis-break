package com.sitelu.studios.stasisbreak;

import java.util.Map;

public class RequiredChoiceEffect {
    private int requiredHealth;
    private int requiredXP;
    private String requiredTool;
    private Map<String, Boolean> requiredFlagCondition;
    private String requiredMessage;

    public RequiredChoiceEffect(int requiredHealth, int requiredXP, String requiredTool,
            Map<String, Boolean> requiredFlagCondition, String requiredMessage) {
        this.requiredHealth = requiredHealth;
        this.requiredXP = requiredXP;
        this.requiredTool = requiredTool;
        this.requiredFlagCondition = requiredFlagCondition;
        this.requiredMessage = requiredMessage;
    }

    public int getRequiredHealth() {
        return requiredHealth;
    }

    public void setRequiredHealth(int requiredHealth) {
        this.requiredHealth = requiredHealth;
    }

    public int getRequiredXP() {
        return requiredXP;
    }

    public void setRequiredXP(int requiredXP) {
        this.requiredXP = requiredXP;
    }

    public String getRequiredTool() {
        return requiredTool;
    }

    public void setRequiredTool(String requiredTool) {
        this.requiredTool = requiredTool;
    }

    public Map<String, Boolean> getRequiredFlagCondition() {
        return requiredFlagCondition;
    }

    public void setRequiredFlagCondition(Map<String, Boolean> requiredFlagCondition) {
        this.requiredFlagCondition = requiredFlagCondition;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public void setRequiredMessage(String requiredMessage) {
        this.requiredMessage = requiredMessage;
    }
}