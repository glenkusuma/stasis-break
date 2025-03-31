package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class ChoiceResultTest {

    @Test
    public void testChoiceResultGetters() {
        int expectedOldHealth = 100;
        int expectedAppliedDamage = 20;
        int expectedOldXP = 50;
        int expectedAppliedXP = 10;
        String expectedEffectMessage = "Damage applied and XP gained";
        String expectedRewardItem = "Sword";
        String expectedDestroyItem = null;

        int expectedRequiredHealth = 30;
        int expectedRequiredXP = 5;
        String expectedRequiredTool = "Key";
        Map<String, Boolean> expectedRequiredFlagCondition = Map.of("Flag1", true, "Flag2", false);
        String expectedRequiredMessage = "You need a key to proceed.";
        Map<String, Boolean> expectedSetFlagCondition = Map.of("Flag3", true);

        ChoiceResult result = new ChoiceResult(
                expectedOldHealth, expectedAppliedDamage, expectedOldXP, expectedAppliedXP,
                expectedEffectMessage, expectedRewardItem, expectedDestroyItem,
                expectedRequiredHealth, expectedRequiredXP, expectedRequiredTool,
                expectedRequiredFlagCondition, expectedRequiredMessage, expectedSetFlagCondition);

        assertEquals(expectedOldHealth, result.getOldHealth(), "Old health should match the value passed to the constructor");
        assertEquals(expectedAppliedDamage, result.getAppliedDamage(), "Applied damage should match the value passed to the constructor");
        assertEquals(expectedOldXP, result.getOldXP(), "Old XP should match the value passed to the constructor");
        assertEquals(expectedAppliedXP, result.getAppliedXP(), "Applied XP should match the value passed to the constructor");
        assertEquals(expectedEffectMessage, result.getEffectMessage(), "Effect message should match the value passed to the constructor");
        assertEquals(expectedRewardItem, result.getItemReward(), "Item Reward should match the value passed to the constructor");
        assertNull(result.getItemDestory(), "Item Destroy should match the value passed to the constructor");

        assertEquals(expectedRequiredHealth, result.getRequiredHealth(), "Required health should match the value passed to the constructor");
        assertEquals(expectedRequiredXP, result.getRequiredXP(), "Required XP should match the value passed to the constructor");
        assertEquals(expectedRequiredTool, result.getRequiredTool(), "Required tool should match the value passed to the constructor");
        assertEquals(expectedRequiredMessage, result.getRequiredMessage(), "Required message should match the value passed to the constructor");

        assertEquals(expectedRequiredFlagCondition.size(), result.getRequiredFlagCondition().size(), "Required flag condition size should match");
        assertTrue(result.getRequiredFlagCondition().entrySet().containsAll(expectedRequiredFlagCondition.entrySet()), "Required flag condition should match");

        assertEquals(expectedSetFlagCondition.size(), result.getSetFlagCondition().size(), "Set flag condition size should match");
        assertTrue(result.getSetFlagCondition().entrySet().containsAll(expectedSetFlagCondition.entrySet()), "Set flag condition should match");
    }

    @Test
    public void testChoiceResultGettersWithoutOptionalFields() {
        int expectedOldHealth = 100;
        int expectedAppliedDamage = 20;
        int expectedOldXP = 50;
        int expectedAppliedXP = 10;
        String expectedEffectMessage = "Damage applied and XP gained";

        ChoiceResult result = new ChoiceResult(expectedOldHealth, expectedAppliedDamage, expectedOldXP,
                expectedAppliedXP, expectedEffectMessage);

        assertEquals(expectedOldHealth, result.getOldHealth(), "Old health should match the value passed to the constructor");
        assertEquals(expectedAppliedDamage, result.getAppliedDamage(), "Applied damage should match the value passed to the constructor");
        assertEquals(expectedOldXP, result.getOldXP(), "Old XP should match the value passed to the constructor");
        assertEquals(expectedAppliedXP, result.getAppliedXP(), "Applied XP should match the value passed to the constructor");
        assertEquals(expectedEffectMessage, result.getEffectMessage(), "Effect message should match the value passed to the constructor");

        assertNull(result.getItemReward(), "Item Reward should be null");
        assertNull(result.getItemDestory(), "Item Destroy should be null");
        assertEquals(0, result.getRequiredHealth(), "Required health should default to 0");
        assertEquals(0, result.getRequiredXP(), "Required XP should default to 0");
        assertNull(result.getRequiredTool(), "Required tool should default to null");
        assertTrue(result.getRequiredFlagCondition().isEmpty(), "Required flag condition should default to empty");
        assertNull(result.getRequiredMessage(), "Required message should default to null");
        assertTrue(result.getSetFlagCondition().isEmpty(), "Set flag condition should default to empty");
    }
}