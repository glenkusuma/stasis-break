package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

        ChoiceResult result = new ChoiceResult(expectedOldHealth, expectedAppliedDamage, expectedOldXP,
                expectedAppliedXP, expectedEffectMessage, expectedRewardItem, expectedDestroyItem);

        assertEquals(expectedOldHealth, result.getOldHealth(),
                "Old health should match the value passed to the constructor");
        assertEquals(expectedAppliedDamage, result.getAppliedDamage(),
                "Applied damage should match the value passed to the constructor");
        assertEquals(expectedOldXP, result.getOldXP(), "Old XP should match the value passed to the constructor");
        assertEquals(expectedAppliedXP, result.getAppliedXP(),
                "Applied XP should match the value passed to the constructor");
        assertEquals(expectedEffectMessage, result.getEffectMessage(),
                "Effect message should match the value passed to the constructor");
        assertEquals(expectedRewardItem, result.getItemReward(),
                "Item Reward should match the value passed to the constructor");
        assertNull(result.getItemDestory(), "Item Destory should match the value passed to the constructor");
    }

    @Test
    public void testChoiceResultGettersWithoutItem() {
        int expectedOldHealth = 100;
        int expectedAppliedDamage = 20;
        int expectedOldXP = 50;
        int expectedAppliedXP = 10;
        String expectedEffectMessage = "Damage applied and XP gained";

        ChoiceResult result = new ChoiceResult(expectedOldHealth, expectedAppliedDamage, expectedOldXP,
                expectedAppliedXP, expectedEffectMessage);

        assertEquals(expectedOldHealth, result.getOldHealth(),
                "Old health should match the value passed to the constructor");
        assertEquals(expectedAppliedDamage, result.getAppliedDamage(),
                "Applied damage should match the value passed to the constructor");
        assertEquals(expectedOldXP, result.getOldXP(), "Old XP should match the value passed to the constructor");
        assertEquals(expectedAppliedXP, result.getAppliedXP(),
                "Applied XP should match the value passed to the constructor");
        assertEquals(expectedEffectMessage, result.getEffectMessage(),
                "Effect message should match the value passed to the constructor");
        assertNull(result.getItemReward(), "Item Reward should be null");
    }
}
