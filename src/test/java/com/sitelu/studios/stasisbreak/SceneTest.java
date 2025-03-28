package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SceneTest {

    private Scene scene;
    private Character character;
    private Scene dummySceneA, dummySceneB, dummySceneC;

    @BeforeEach
    public void setUp() {
        // Create dummy next scene
        dummySceneA = new Scene("Next Scene A", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        dummySceneB = new Scene("Next Scene B", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        dummySceneC = new Scene("Next Scene C", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);

        scene = new Scene("Test Scene Description",
                "Choice A", dummySceneA, 10, 5,
                "Choice B", dummySceneB, 0, 10,
                "Choice C", dummySceneC, 20, 0);

        character = new Character("TestCharacter", 100);
    }

    /**
     * Test the Scene constructor.
     * - Verify that all attributes are correctly set.
     */
    @Test
    public void testConstructor() {
        assertEquals("Test Scene Description", scene.getDescription(), "Description should be initialize as provided");
        assertEquals("Choice A", scene.getChoiceA(), "ChoiceA should be initialize as provided");
        assertEquals("Choice B", scene.getChoiceB(), "ChoiceB should be initialize as provided");
        assertEquals("Choice C", scene.getChoiceC(), "ChoiceC should be initialize as provided");
        assertEquals(dummySceneA, scene.getNextSceneA(), "NextSceneA should be initialize as provided");
        assertEquals(dummySceneB, scene.getNextSceneB(), "NextSceneB should be initialize as provided");
        assertEquals(dummySceneC, scene.getNextSceneC(), "NextSceneC should be initialize as provided");
        assertEquals(10, scene.getDamageA(), "DamageA should be initialize as provided");
        assertEquals(0, scene.getDamageB(), "DamageB should be initialize as provided");
        assertEquals(20, scene.getDamageC(), "DamageC should be initialize as provided");
        assertEquals(5, scene.getXPA(), "XPA should be initialize as provided");
        assertEquals(10, scene.getXPB(), "XPA should be initialize as provided");
        assertEquals(0, scene.getXPC(), "XPA should be initialize as provided");
    }

    /**
     * Test the displayScene() method
     * - Verify that the scene's description and choices are properly output
     */
    @Test
    public void testDisplayScene() {
        // capture the console's output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Call displayScene, which should print to System.out
        scene.displayScene();

        // Restore original System.out
        System.setOut(originalOut);

        // Check output contains expected description and choices
        String output = outContent.toString();
        assertTrue(output.contains("Test Scene Description"), "Output should contain the scene description");
        assertTrue(output.contains("Choice A"), "Output should contain Choice A");
        assertTrue(output.contains("Choice B"), "Output should contain Choice B");
        assertTrue(output.contains("Choice C"), "Output should contain Choice C");

    }

    /**
     * Test valid input "A" for makeChoice()
     * - Returns dummySceneA
     * - Reduces character's health by 10
     * - Increases character's XP by 5
     */
    @Test
    public void testMakeChoiceValidInputA() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        Scene returnedScene = scene.makeChoice("A", character);

        assertEquals(dummySceneA, returnedScene, "Choice A should return the correct next scene");
        assertEquals(initialHealth - 10, character.getHealth(), "Health should be reduced by 10 after choosing A");
        assertEquals(initialXP + 5, character.getXP(), "XP should be increased by 5 after choosing A");
    }

    /**
     * Test valid input "B" for makeChoice(
     * - Returns dummySceneB
     * - Reduces character's health by 0
     * - Increases character's XP by 10
     */
    @Test
    public void testMakeChoiceValidInputB() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        Scene returnedScene = scene.makeChoice("B", character);

        assertEquals(dummySceneB, returnedScene, "Choice B should return the correct next scene");
        assertEquals(initialHealth - 0, character.getHealth(), "Health should be reduced by 15 after choosing B");
        assertEquals(initialXP + 10, character.getXP(), "XP should be increased by 10 after choosing B");
    }

    /**
     * Test valid input "C" for makeChoice()
     * - Returns dummySceneC
     * - Reduces character's health by 20
     * - Increases character's XP by 0
     */
    @Test
    public void testMakeChoiceValidInputC() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        Scene returnedScene = scene.makeChoice("C", character);

        assertEquals(dummySceneC, returnedScene, "Choice C should return the correct next scene");
        assertEquals(initialHealth - 20, character.getHealth(), "Health should be reduced by 20 after choosing B");
        assertEquals(initialXP + 0, character.getXP(), "XP should be increased by 10 after choosing B");
    }

    /**
     * Test makeChoice() with an invalid input
     * - Returns null
     * - Character's health and XP remain unchanged
     */
    @Test
    public void testMakeChoiceInvalidInput() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        Scene returnedScene = scene.makeChoice("invalid", character);

        assertNull(returnedScene, "An invalid choice should return null");
        assertEquals(initialHealth, character.getHealth(), "Health should remain unchanged for invalid input");
        assertEquals(initialXP, character.getXP(), "XP should remain unchanged for invalid input");
    }

    /**
     * Test that makeChoice() handles case-insensitive input
     * - Lowercase 'a' should be treated the same as uppercase 'A'
     */
    @Test
    public void testMakeChoiceCaseInsensitive() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        // Use lowercase input "a"
        Scene returnedScene = scene.makeChoice("a", character);

        assertEquals(dummySceneA, returnedScene, "Lowercase 'a' should return the correct next scene as 'A'");
        assertEquals(initialHealth - 10, character.getHealth(), "Health should be reduced by 10 after choosing 'a'");
        assertEquals(initialXP + 5, character.getXP(), "XP should be increased by 5 after choosing 'a'");
    }

    /**
     * Test makeChoice() with null input
     * - Returns null
     * - Character's health and XP remain unchanged
     */
    @Test
    public void testMakeChoiceNullInput() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        Scene returnedScene = scene.makeChoice(null, character);

        assertNull(returnedScene, "Null input should return null");
        assertEquals(initialHealth, character.getHealth(), "Health should remain unchanged for null input");
        assertEquals(initialXP, character.getXP(), "XP should remain unchanged for null input");
    }

    /**
     * Test consecutive scene decisions in a chain of scenes
     *
     * Scenario:
     * - Scene1 ("Scene 1") offers Choice A: "Go to Scene 2"
     * - Consequence: damage = 5, XP gain = 2, next scene = Scene2
     *
     * - Scene2 ("Scene 2") offers Choice C: "Go to Scene 3"
     * - Consequence: damage = 10, XP gain = 3, next scene = Scene3
     *
     * - Scene3 ("Scene 3") is the final scene
     *
     * Expected:
     * - A character starting at 100 health and 0 XP will have
     * After Scene1: health = 95, XP = 2
     * After Scene2: health = 85, XP = 5
     * The chain should return Scene3 as the final scene
     */
    @Test
    public void testConsecutiveSceneDecisions() {
        // Create the final scene (Scene3) with no further choices
        Scene scene3 = new Scene(
                "Scene 3", 
                "Choice A", null, 0, 0,
                "Final Choice", null, 0, 0,
                "Choice C", null, 0, 0);

        // Create Scene2 which leads to Scene3 on choice C
        Scene scene2 = new Scene(
                "Scene 2", 
                "Choice A", null, 0, 0,
                "Choice B", null, 0, 0,
                "Go to Scene 3", scene3, 10, 3);

        // Create Scene1 which leads to Scene2 on choice A
        Scene scene1 = new Scene(
                "Scene 1", 
                "Go to Scene 2", scene2, 5, 2,
                "Choice B", null, 0, 0,
                "Choice C", null, 0, 0);

        // Create a test character starting with 100 health and 0 XP
        Character testCharacter = new Character("TestCharacter", 100);

        // Simulate decision in Scene1: choosing "A"
        Scene nextScene = scene1.makeChoice("A", testCharacter);

        // After Scene1 decision, expect health to be 95 and XP to be 2
        assertEquals(95, testCharacter.getHealth(), "After Scene1, health should be 95");
        assertEquals(2, testCharacter.getXP(), "After Scene1, XP should be 2");
        assertEquals(scene2, nextScene, "Scene1 choice A should lead to Scene2");

        // Simulate decision in Scene2: choosing "C"
        Scene finalScene = nextScene.makeChoice("C", testCharacter);

        // After Scene2 decision, expect health to be 85 and XP to be 5
        assertEquals(85, testCharacter.getHealth(), "After Scene2, health should be 85");
        assertEquals(5, testCharacter.getXP(), "After Scene2, XP should be 5");
        assertEquals(scene3, finalScene, "Scene2 choice A should lead to Scene3");
    }
}
