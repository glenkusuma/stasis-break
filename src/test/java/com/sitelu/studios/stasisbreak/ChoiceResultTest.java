package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ChoiceResultTest {

    @Test
    public void testChoiceResultGetters() {
        int expectedOldHealth = 100;
        int expectedAppliedDamage = 20;
        int expectedOldXP = 50;
        int expectedAppliedXP = 10;
        String expectedEffectMessage = "Damage applied and XP gained.";

        ChoiceResult result = new ChoiceResult(expectedOldHealth, expectedAppliedDamage, expectedOldXP, expectedAppliedXP, expectedEffectMessage);

        // verify that the getter methods return the expected values
        assertEquals(expectedOldHealth, result.getOldHealth(), "Old health should match the value passed to the constructor");
        assertEquals(expectedAppliedDamage, result.getAppliedDamage(), "Applied damage should match the value passed to the constructor");
        assertEquals(expectedOldXP, result.getOldXP(), "Old XP should match the value passed to the constructor");
        assertEquals(expectedAppliedXP, result.getAppliedXP(), "Applied XP should match the value passed to the constructor");
        assertEquals(expectedEffectMessage, result.getEffectMessage(), "Effect message should match the value passed to the constructor");
    }
}
