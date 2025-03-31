package com.sitelu.studios.stasisbreak;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RequiredChoiceEffectTest {

    @Test
    public void testConstructorAndGetters() {
        int requiredHealth = 50;
        int requiredXP = 10;
        String requiredTool = "Key";
        Map<String, Boolean> requiredFlagCondition = Map.of("Flag1", true, "Flag2", false);
        String requiredMessage = "You need a key to proceed";

        RequiredChoiceEffect effect = new RequiredChoiceEffect(
                requiredHealth, requiredXP, requiredTool, requiredFlagCondition, requiredMessage);

        assertEquals(requiredHealth, effect.getRequiredHealth(),
                "Required health should match value passed to constructor");
        assertEquals(requiredXP, effect.getRequiredXP(),
                "Required XP should match value passed to constructor");
        assertEquals(requiredTool, effect.getRequiredTool(),
                "Required tool should match value passed to constructor");
        assertEquals(requiredFlagCondition, effect.getRequiredFlagCondition(),
                "Required flag condition should match value passed to constructor");
        assertEquals(requiredMessage, effect.getRequiredMessage(),
                "Required message should match value passed to constructor");
    }

    @Test
    public void testSetters() {
        RequiredChoiceEffect effect = new RequiredChoiceEffect(0, 0, null, null, null);

        effect.setRequiredHealth(100);
        assertEquals(100, effect.getRequiredHealth(), "Required health should be updated");

        effect.setRequiredXP(20);
        assertEquals(20, effect.getRequiredXP(), "Required XP should be updated");

        effect.setRequiredTool("Hammer");
        assertEquals("Hammer", effect.getRequiredTool(), "Required tool should be updated");

        Map<String, Boolean> newFlagCondition = Map.of("Flag3", true);
        effect.setRequiredFlagCondition(newFlagCondition);
        assertEquals(newFlagCondition, effect.getRequiredFlagCondition(), "Required flag condition should be updated");

        effect.setRequiredMessage("New message");
        assertEquals("New message", effect.getRequiredMessage(), "Required message should be updated");
    }

    @Test
    public void testDefaultValues() {
        RequiredChoiceEffect effect = new RequiredChoiceEffect(0, 0, null, null, null);

        assertEquals(0, effect.getRequiredHealth(), "Default required health should be 0");
        assertEquals(0, effect.getRequiredXP(), "Default required XP should be 0");
        assertNull(effect.getRequiredTool(), "Default required tool should be null");
        assertNull(effect.getRequiredFlagCondition(), "Default required flag condition should be null");
        assertNull(effect.getRequiredMessage(), "Default required message should be null");
    }
}