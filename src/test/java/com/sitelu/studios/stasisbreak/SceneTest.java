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
     * Test Scene constructor
     * - Verify that all attributes are correctly set
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
     * Test displayScene() method
     * - Verify that scene's description & choices are properly output
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

        // Check output contains expected description & choices
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
     * - Character's health & XP remain unchanged
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
     * - Lowercase 'a' should be treated same as uppercase 'A'
     */
    @Test
    public void testMakeChoiceCaseInsensitive() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        // use lowercase input "a"
        Scene returnedScene = scene.makeChoice("a", character);

        assertEquals(dummySceneA, returnedScene, "Lowercase 'a' should return the correct next scene as 'A'");
        assertEquals(initialHealth - 10, character.getHealth(), "Health should be reduced by 10 after choosing 'a'");
        assertEquals(initialXP + 5, character.getXP(), "XP should be increased by 5 after choosing 'a'");
    }

    /**
     * Test makeChoice() with null input
     * - Returns null
     * - Character's health & XP remain unchanged
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
     * Test getLastChoiceResult after a valid choice
     * Expected: lastChoiceResult should reflect applied damage & XP
     */
    @Test
    public void testGetLastChoiceResult() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        // Make a valid choice (choice "A")
        scene.makeChoice("A", character);
        ChoiceResult result = scene.getLastChoiceResult();

        assertNotNull(result, "lastChoiceResult should not be null after a valid choice");
        assertEquals(initialHealth, result.getOldHealth(),
                "Old health should match character's health before applying damage");
        assertEquals(10, result.getAppliedDamage(), "Applied damage should match the damage for choice A");
        assertEquals(initialXP, result.getOldXP(), "Old XP should match character's XP before applying XP gain");
        assertEquals(5, result.getAppliedXP(), "Applied XP should match the XP gain for choice A");
        // Since effectMessage wasn't provided, expect an empty string.
        assertEquals("", result.getEffectMessage(), "Effect message should be empty as provided");
    }

    /**
     * Test applyChoiceEffect() method for a valid input "B"
     * Expected: returned ChoiceResult reflects correct applied damage & XP player's attributes are updated accordingly
     */
    @Test
    public void testApplyChoiceEffectValid() {
        // Reset character for a local test
        Character localCharacter = new Character("LocalTest", 100);
        ChoiceResult result = scene.applyChoiceEffect("B", localCharacter);

        assertNotNull(result, "ChoiceResult should not be null for valid input");
        assertEquals(0, result.getAppliedDamage(), "Damage for choice B should be 0");
        assertEquals(10, result.getAppliedXP(), "XP gain for choice B should be 10");
        // Check localCharacter is updated: health remains 100, XP becomes 10.
        assertEquals(100, localCharacter.getHealth(), "Health should remain unchanged after 0 damage");
        assertEquals(10, localCharacter.getXP(), "XP should be increased by 10");
    }

    /**
     * Test app lyChoiceEffect() method with an invalid input
     * Expected: Returns null & player's attributes should  remain unchanged
     */
    @Test
    public void testApplyChoiceEffectInvalid() {
        int initialHealth = character.getHealth();
        int initialXP = character.getXP();

        ChoiceResult result = scene.applyChoiceEffect("invalid", character);
        assertNull(result, "ChoiceResult should be null for an invalid choice");
        assertEquals(initialHealth, character.getHealth(), "Player's health should remain unchanged for invalid input");
        assertEquals(initialXP, character.getXP(), "Player's XP should remain unchanged for invalid input");
    }

    /**
     * Test getNextScene() method
     * Expected: Returns correct next scene for valid inputs & null for invalid input
     */
    @Test
    public void testGetNextScene() {
        assertEquals(dummySceneA, scene.getNextScene("A"), "getNextScene should return dummySceneA for input 'A'");
        assertEquals(dummySceneB, scene.getNextScene("B"), "getNextScene should return dummySceneB for input 'B'");
        assertEquals(dummySceneC, scene.getNextScene("C"), "getNextScene should return dummySceneC for input 'C'");
        assertNull(scene.getNextScene("invalid"), "getNextScene should return null for invalid input");
    }

    /**
     * Test makeChoice() & applyChoiceEffect() with a null player
     * Expected: Both should return null
     */
    @Test
    public void testNullPlayer() {
        Scene result1 = scene.makeChoice("A", null);
        assertNull(result1, "makeChoice should return null if the player is null");

        ChoiceResult result2 = scene.applyChoiceEffect("A", null);
        assertNull(result2, "applyChoiceEffect should return null if the player is null");
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
     * - After Scene1: health = 95, XP = 2
     * - After Scene2: health = 85, XP = 5
     * - The chain should return Scene3 as the final scene
     */
    @Test
    public void testConsecutiveSceneDecisions() {
        // Create final scene (Scene3) with no further choices
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

        Character testCharacter = new Character("TestCharacter", 100);

        Scene nextScene = scene1.makeChoice("A", testCharacter);

        // After Scene1 decision, expect health to be 95 & XP to be 2
        assertEquals(95, testCharacter.getHealth(), "After Scene1, health should be 95");
        assertEquals(2, testCharacter.getXP(), "After Scene1, XP should be 2");
        assertEquals(scene2, nextScene, "Scene1 choice A should lead to Scene2");

        // Simulate decision in Scene2: choosing "C"
        Scene finalScene = nextScene.makeChoice("C", testCharacter);

        // After Scene2 decision, expect health to be 85 & XP to be 5
        assertEquals(85, testCharacter.getHealth(), "After Scene2, health should be 85");
        assertEquals(5, testCharacter.getXP(), "After Scene2, XP should be 5");
        assertEquals(scene3, finalScene, "Scene2 choice C should lead to Scene3");
    }

    /**
     * Test overloaded constructor defaults with effect messages to an empty string
     * tet by simulate a valid choice ("A", "B", "C") 
     * verify returnedChoiceResult has an empty effect message
     */
    @Test
    public void testOverloadedConstructorDefaultEffectMessages() {

        Scene dummyA = new Scene("Dummy A", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        Scene dummyB = new Scene("Dummy B", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        Scene dummyC = new Scene("Dummy C", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);

        Scene sceneOverloaded = new Scene(
                "Overloaded Scene",
                "Choice A", "Choice B", "Choice C",
                dummyA, dummyB, dummyC,
                5, 10, 15,
                2, 4, 6);

        Character testCharacter = new Character("TestPlayer", 100);

        ChoiceResult resultA = sceneOverloaded.applyChoiceEffect("A", testCharacter);
        assertNotNull(resultA, "ChoiceResult should not be null for valid input");
        assertEquals("", resultA.getEffectMessage(), "Effect message for choice A should be empty by default");

        ChoiceResult resultB = sceneOverloaded.applyChoiceEffect("B", testCharacter);
        assertNotNull(resultB, "ChoiceResult should not be null for valid input");
        assertEquals("", resultB.getEffectMessage(), "Effect message for choice B should be empty by default");

        ChoiceResult resultC = sceneOverloaded.applyChoiceEffect("C", testCharacter);
        assertNotNull(resultC, "ChoiceResult should not be null for valid input");
        assertEquals("", resultC.getEffectMessage(), "Effect message for choice C should be empty by default");
    }

    /**
     * Test applyChoiceEffect() with as null choice
     * Expected: method should return null & not modify player's attributes
     */
    @Test
    public void testApplyChoiceEffectWithNullChoice() {

        Scene sampleScene = new Scene(
                "Sample Scene",
                "Choice A", null, 10, 5, "Effect A",
                "Choice B", null, 0, 10, "Effect B",
                "Choice C", null, 20, 0, "Effect C");
        Character testCharacter = new Character("TestPlayer", 100);

        ChoiceResult result = sampleScene.applyChoiceEffect(null, testCharacter);
        assertNull(result, "applyChoiceEffect should return null if the choice is null");

        assertEquals(100, testCharacter.getHealth(), "Player's health should remain unchanged for null choice");
        assertEquals(0, testCharacter.getXP(), "Player's XP should remain unchanged for null choice");
    }

    /**
     * Test applyChoiceEffect() with a null player
     * Expected: method should return null
     */
    @Test
    public void testApplyChoiceEffectWithNullPlayer() {

        Scene sampleScene = new Scene(
                "Sample Scene",
                "Choice A", null, 10, 5, "Effect A",
                "Choice B", null, 0, 10, "Effect B",
                "Choice C", null, 20, 0, "Effect C");
        ChoiceResult result = sampleScene.applyChoiceEffect("A", null);
        assertNull(result, "applyChoiceEffect should return null if the player is null");
    }
}
