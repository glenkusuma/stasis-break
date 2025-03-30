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
     * Verify that name and health are set correctly
     * and ensure XP is initialize to 0 and items is empty
     */
    @Test
    public void testConstructorInit() {
        assertEquals("TestCharacter", character.getName(), "Name should be initialized as provided");
        assertEquals(100, character.getHealth(), "Health should be initialized as provided");
        assertEquals(0, character.getXP(), "XP should be 0 initially");
        assertEquals("", character.getItems(), "Items should be empty initially");
    }

    /**
     * Test takeDamage method.
     * Calling takeDamage should reduce health by correct amount
     * and handle edge cases like damage exceeding current health
     */
    @Test
    public void testTakeDamage() {
        int HelathAfterDamage = character.takeDamage(20);
        assertEquals(80, HelathAfterDamage, "Health should be reduced by damage amount");
        assertEquals(80, character.getHealth(), "getHealth should return updated value");

        int HelathAfterOverDamage = character.takeDamage(100);
        assertEquals(0, HelathAfterOverDamage, "Health should be 0 when damage exxeeds current helath");
        assertTrue(character.getHealth() >= 0, "Health should never be negative");
    }

    /**
     * Test addXP method
     * calling addXP should increase XP to correct amount
     */
    @Test
    public void testAddXP() {
        character.addXP(10);
        assertEquals(10, character.getXP(), "XP should increase by added amount");

        character.addXP(25);
        assertEquals(35, character.getXP(), "XP should be cumulative");
    }

    /**
     * Test addItem & getItems method
     * Verify that adding an item correctly updates comma-separated items list
     */
    @Test
    public void testAddItemAndGetItems() {
        character.addItem("Toolkit");
        assertEquals("Toolkit", character.getItems(), "getItems should return item that was added");
    }

    /**
     * Test adding multiple items
     * Verify that items are stored as a comma-separated list
     */
    @Test
    public void testAddMultipleItems() {
        character.addItem("Sword");
        character.addItem("Shield");
        character.addItem("Potion");
        assertEquals("Sword, Shield, Potion", character.getItems(),
                "getItems should return all items as a comma-separated list");
    }

    /**
     * Test removeItem method
     * Verify that removing an item updates list correctly
     */
    @Test
    public void testRemoveItem() {
        character.addItem("Sword");
        character.addItem("Shield");
        character.addItem("Potion");

        character.removeItem("Shield");
        assertEquals("Sword, Potion", character.getItems(),
                "After removal, items should not contain removed item");

        character.removeItem("Bow");
        assertEquals("Sword, Potion", character.getItems(),
                "Removing a non-existent item should not alter items list");
    }

    /**
     * Test hasItem method
     * Verify that hasItem correctly identifies if an item exists (case insensitive)
     */
    @Test
    public void testHasItem() {
        character.addItem("Sword");
        character.addItem("Shield");

        assertTrue(character.hasItem("Sword"), "Character should have Sword");
        assertTrue(character.hasItem("shield"), "hasItem should be case insensitive");
        assertFalse(character.hasItem("Potion"), "Character should not have Potion");
    }

      /**
     * Test setItems correctly sets items field
     */
    @Test
    public void testSetItems() {
        character.setItems("Sword, Shield, Potion");
        assertEquals("Sword, Shield, Potion", character.getItems(), "setItems should correctly update items list");
    }

    /**
     * Test hasItem returns false when items is empty
     */
    @Test
    public void testHasItemWhenEmpty() {
        character.setItems("");
        assertFalse(character.hasItem("Sword"), "hasItem should return false when items list is empty");
    }

    /**
     * Test removeItem does nothing when items is empty
     */
    @Test
    public void testRemoveItemWhenEmpty() {
        character.setItems("");
        character.removeItem("Sword");
        assertEquals("", character.getItems(), "removeItem should not modify items when list is empty");
    }
}
