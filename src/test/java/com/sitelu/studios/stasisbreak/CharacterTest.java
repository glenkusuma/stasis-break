package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    private Character character;

    @BeforeEach
    public void setUp() {
        character = new Character("TestCharacter", 100);
    }

    /**
     * Test constructor
     * Verify that the name and health are set correctly,
     * and ensure XP is initialize to 0 and item is null.
     */
    @Test
    public void testConstructorInit(){
        assertEquals("TestCharacter", character.getName(), "Name should be initialize as provided");
        assertEquals(100, character.getHealth(), "Health should be initialize as provided");
        
        assertEquals(0, character.getXP(), "Xp should be 0 initially");
        assertNull(character.getItem(), "Item should null initially");
    }

    /**
     * Test takeDamage method
     * Calling takeDamage should reduce the health by the correct amount,
     * Also testing edge cases like damage exceeding current health.
     */
    @Test
    public void testTakeDamage(){
        int HelathAfterDamage = character.takeDamage(20);
        assertEquals(80, HelathAfterDamage, "Health should be reduced by the damage amount.");
        assertEquals(80, character.getHealth(), "getHealth should return the updated value.");

        int HelathAfterOverDamage = character.takeDamage(100);
        assertEquals(0, HelathAfterOverDamage, "Health should be 0 when damage exxeeds current helath");
        assertTrue(character.getHealth() >= 0, "Health should never be negative");
    }

    /**
     * Test addXP method
     * calling addXP should increase XP to the correct amount 
     */
    @Test
    public void testAddXP(){
        character.addXP(10);
        assertEquals(10, character.getXP(), "XP should increase by the added amount");

        character.addXP(25);
        assertEquals(35, character.getXP(), "XP should be cumulative");
    }

    /**
     * Test setItem & getItem method
     * calling addXP should increase XP to the correct amount 
     */
    @Test
    public void testSetAndGetItem(){
        character.setItem("Toolkit");
        assertEquals("Toolkit", character.getItem(), "getItem should Return the item set by setItem");
    }

}
