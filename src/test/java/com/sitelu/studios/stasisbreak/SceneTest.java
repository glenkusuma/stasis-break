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
        assertEquals("Choice A", scene.getChoice("A", false), "ChoiceA should be initialize as provided");
        assertEquals("Choice B", scene.getChoice("B", false), "ChoiceB should be initialize as provided");
        assertEquals("Choice C", scene.getChoice("C", false), "ChoiceC should be initialize as provided");
        assertEquals(dummySceneA, scene.getNextScene("A", false), "NextSceneA should be initialize as provided");
        assertEquals(dummySceneB, scene.getNextScene("B", false), "NextSceneB should be initialize as provided");
        assertEquals(dummySceneC, scene.getNextScene("C", false), "NextSceneC should be initialize as provided");
        assertEquals(10, scene.getDamage("A", false), "DamageA should be initialize as provided");
        assertEquals(0, scene.getDamage("B", false), "DamageB should be initialize as provided");
        assertEquals(20, scene.getDamage("C", false), "DamageC should be initialize as provided");
        assertEquals(5, scene.getXP("A", false), "XPA should be initialize as provided");
        assertEquals(10, scene.getXP("B", false), "XPA should be initialize as provided");
        assertEquals(0, scene.getXP("C", false), "XPA should be initialize as provided");
    }

    /**
     * Test overloaded constructor with effect messages
     * - Verify that effect messages are correctly set
     */
    @Test
    public void testOverloadedConstructorWithEffectMessages() {
        Scene sceneWithEffects = new Scene(
                "Scene with Effects",
                "Choice A", dummySceneA, 10, 5, "Effect A",
                "Choice B", dummySceneB, 0, 10, "Effect B",
                "Choice C", dummySceneC, 20, 0, "Effect C");

        assertEquals("Effect A", sceneWithEffects.getEffectMessage("A", false),
                "Effect message for Choice A should be set correctly");
        assertEquals("Effect B", sceneWithEffects.getEffectMessage("B", false),
                "Effect message for Choice B should be set correctly");
        assertEquals("Effect C", sceneWithEffects.getEffectMessage("C", false),
                "Effect message for Choice C should be set correctly");
    }

    /**
     * Test overloaded constructor with item rewards
     * - Verify that item rewards are correctly set
     */
    @Test
    public void testOverloadedConstructorWithItemRewards() {
        Scene sceneWithItems = new Scene(
                "Scene with Items",
                "Choice A", dummySceneA, 10, 5, "Effect A", "Reward A", null,
                "Choice B", dummySceneB, 0, 10, "Effect B", "Reward B", null,
                "Choice C", dummySceneC, 20, 0, "Effect C", "Reward C", null);

        assertEquals("Reward A", sceneWithItems.getItemReward("A", false),
                "Item reward for Choice A should be set correctly");
        assertEquals("Reward B", sceneWithItems.getItemReward("B", false),
                "Item reward for Choice B should be set correctly");
        assertEquals("Reward C", sceneWithItems.getItemReward("C", false),
                "Item reward for Choice C should be set correctly");
    }

    /**
     * Test overloaded constructor with destroyable items
     * - Verify that destroyable items are correctly set
     */
    @Test
    public void testOverloadedConstructorWithDestroyableItems() {
        Scene sceneWithDestroyableItems = new Scene(
                "Scene with Destroyable Items",
                "Choice A", dummySceneA, 10, 5, "Effect A", "Reward A", "Destroy A",
                "Choice B", dummySceneB, 0, 10, "Effect B", "Reward B", "Destroy B",
                "Choice C", dummySceneC, 20, 0, "Effect C", "Reward C", "Destroy C");

        assertEquals("Destroy A", sceneWithDestroyableItems.getItemDestroy("A", false),
                "Destroy item for Choice A should be set correctly");
        assertEquals("Destroy B", sceneWithDestroyableItems.getItemDestroy("B", false),
                "Destroy item for Choice B should be set correctly");
        assertEquals("Destroy C", sceneWithDestroyableItems.getItemDestroy("C", false),
                "Destroy item for Choice C should be set correctly");
    }

    /**
     * Test getters & setters for effectMessageA, effectMessageB, effectMessageC
     */
    @Test
    public void testEffectMessageGettersAndSetters() {
        scene.setEffectMessage("A", false, "New Effect A");
        assertEquals("New Effect A", scene.getEffectMessage("A", false),
                "EffectMessageA should be set & retrieved correctly");

        scene.setEffectMessage("B", false, "New Effect B");
        assertEquals("New Effect B", scene.getEffectMessage("B", false),
                "EffectMessageB should be set & retrieved correctly");

        scene.setEffectMessage("C", false, "New Effect C");
        assertEquals("New Effect C", scene.getEffectMessage("C", false),
                "EffectMessageC should be set & retrieved correctly");
    }

    /**
     * Test getters & setters for itemRewardA, itemRewardB, itemRewardC
     */
    @Test
    public void testItemRewardGettersAndSetters() {
        scene.setItemReward("A", false, "Reward A");
        assertEquals("Reward A", scene.getItemReward("A", false), "ItemRewardA should be set & retrieved correctly");

        scene.setItemReward("B", false, "Reward B");
        assertEquals("Reward B", scene.getItemReward("B", false), "ItemRewardB should be set & retrieved correctly");

        scene.setItemReward("C", false, "Reward C");
        assertEquals("Reward C", scene.getItemReward("C", false), "ItemRewardC should be set & retrieved correctly");
    }

    /**
     * Test getters & setters for itemDestroyA, itemDestroyB, itemDestroyC
     */
    @Test
    public void testItemDestroyGettersAndSetters() {
        scene.setItemDestroy("A", false, "Destroy A");
        assertEquals("Destroy A", scene.getItemDestroy("A", false), "ItemDestroyA should be set & retrieved correctly");

        scene.setItemDestroy("B", false, "Destroy B");
        assertEquals("Destroy B", scene.getItemDestroy("B", false), "ItemDestroyB should be set & retrieved correctly");

        scene.setItemDestroy("C", false, "Destroy C");
        assertEquals("Destroy C", scene.getItemDestroy("C", false), "ItemDestroyC should be set & retrieved correctly");
    }

    /**
     * Test getters & setters for nextSceneA, nextSceneB, nextSceneC
     */
    @Test
    public void testNextSceneGettersAndSetters() {
        Scene newSceneA = new Scene("New Scene A", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        Scene newSceneB = new Scene("New Scene B", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);
        Scene newSceneC = new Scene("New Scene C", "", null, 0, 0, "", null, 0, 0, "", null, 0, 0);

        scene.setNextScene("A", false, newSceneA);
        assertEquals(newSceneA, scene.getNextScene("A", false), "NextSceneA should be set & retrieved correctly");

        scene.setNextScene("B", false, newSceneB);
        assertEquals(newSceneB, scene.getNextScene("B", false), "NextSceneB should be set & retrieved correctly");

        scene.setNextScene("C", false, newSceneC);
        assertEquals(newSceneC, scene.getNextScene("C", false), "NextSceneC should be set & retrieved correctly");
    }

    /**
     * Test displayScene() method
     * - Verify that scene's description & choices are properly output
     */
    @Test
    public void testDisplayScene() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        scene.displayScene(true);

        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Test Scene Description"), "Output should contain scene description");
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

        assertEquals(dummySceneA, returnedScene, "Choice A should return correct next scene");
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

        assertEquals(dummySceneB, returnedScene, "Choice B should return correct next scene");
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

        assertEquals(dummySceneC, returnedScene, "Choice C should return correct next scene");
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

        Scene returnedScene = scene.makeChoice("a", character);

        assertEquals(dummySceneA, returnedScene, "Lowercase 'a' should return correct next scene as 'A'");
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

        scene.makeChoice("A", character);
        ChoiceResult result = scene.getLastChoiceResult();

        assertNotNull(result, "lastChoiceResult should not be null after a valid choice");
        assertEquals(initialHealth, result.getOldHealth(),
                "Old health should match character's health before applying damage");
        assertEquals(10, result.getAppliedDamage(), "Applied damage should match damage for choice A");
        assertEquals(initialXP, result.getOldXP(), "Old XP should match character's XP before applying XP gain");
        assertEquals(5, result.getAppliedXP(), "Applied XP should match XP gain for choice A");

        assertNull(result.getEffectMessage(), "Effect message should be null as default");
    }

    /**
     * Test applyChoiceEffect() method for a valid input "B"
     * Expected: returned ChoiceResult reflects correct applied damage & XP player's
     * attributes are updated accordingly
     */
    @Test
    public void testApplyChoiceEffectValid() {

        Character localCharacter = new Character("LocalTest", 100);
        ChoiceResult result = scene.applyChoiceEffect("B", localCharacter);

        assertNotNull(result, "ChoiceResult should not be null for valid input");
        assertEquals(0, result.getAppliedDamage(), "Damage for choice B should be 0");
        assertEquals(10, result.getAppliedXP(), "XP gain for choice B should be 10");

        assertEquals(100, localCharacter.getHealth(), "Health should remain unchanged after 0 damage");
        assertEquals(10, localCharacter.getXP(), "XP should be increased by 10");
    }

    /**
     * Test app lyChoiceEffect() method with an invalid input
     * Expected: Returns null & player's attributes should remain unchanged
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
     * Expected: Returns correct next scene for valid inputs & null for invalid
     * input
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
        assertNull(result1, "makeChoice should return null if player is null");

        ChoiceResult result2 = scene.applyChoiceEffect("A", null);
        assertNull(result2, "applyChoiceEffect should return null if player is null");
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
     * - Scene3 ("Scene 3") is final scene
     *
     * Expected:
     * - After Scene1: health = 95, XP = 2
     * - After Scene2: health = 85, XP = 5
     * - The chain should return Scene3 as final scene
     */
    @Test
    public void testConsecutiveSceneDecisions() {
        Scene scene3 = new Scene(
                "Scene 3",
                "Choice A", null, 0, 0,
                "Final Choice", null, 0, 0,
                "Choice C", null, 0, 0);

        Scene scene2 = new Scene(
                "Scene 2",
                "Choice A", null, 0, 0,
                "Choice B", null, 0, 0,
                "Go to Scene 3", scene3, 10, 3);

        Scene scene1 = new Scene(
                "Scene 1",
                "Go to Scene 2", scene2, 5, 2,
                "Choice B", null, 0, 0,
                "Choice C", null, 0, 0);

        Character testCharacter = new Character("TestCharacter", 100);

        Scene nextScene = scene1.makeChoice("A", testCharacter);

        assertEquals(95, testCharacter.getHealth(), "After Scene1, health should be 95");
        assertEquals(2, testCharacter.getXP(), "After Scene1, XP should be 2");
        assertEquals(scene2, nextScene, "Scene1 choice A should lead to Scene2");

        Scene finalScene = nextScene.makeChoice("C", testCharacter);

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
        assertNull(resultA.getEffectMessage(), "Effect message for choice A should be null by default");

        ChoiceResult resultB = sceneOverloaded.applyChoiceEffect("B", testCharacter);
        assertNotNull(resultB, "ChoiceResult should not be null for valid input");
        assertNull(resultB.getEffectMessage(), "Effect message for choice B should be null by default");

        ChoiceResult resultC = sceneOverloaded.applyChoiceEffect("C", testCharacter);
        assertNotNull(resultC, "ChoiceResult should not be null for valid input");
        assertNull(resultC.getEffectMessage(), "Effect message for choice C should be null by default");
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
        assertNull(result, "applyChoiceEffect should return null if choice is null");

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
        assertNull(result, "applyChoiceEffect should return null if player is null");
    }

    @Test
    public void testItemRewardAndDestroyIntegration() {
        Scene sceneWithItems = new Scene(
                "Scene with Items",
                "Choice A", dummySceneA, 0, 0, "Effect A", "RewardItemA", "DestroyItemA",
                "Choice B", dummySceneB, 0, 0, "Effect B", "RewardItemB", "DestroyItemB",
                "Choice C", dummySceneC, 0, 0, "Effect C", "RewardItemC", "DestroyItemC");

        Character player = new Character("TestPlayer", 100);
        player.addItem("DestroyItemA");

        ChoiceResult result = sceneWithItems.applyChoiceEffect("A", player);

        assertTrue(player.getItems().contains("RewardItemA"), "RewardItemA should be added to inventory");
        assertFalse(player.getItems().contains("DestroyItemA"), "DestroyItemA should be removed from inventory");
        assertEquals("Effect A", result.getEffectMessage(), "Effect message should match one for Choice A");
        assertEquals(100, player.getHealth(), "Player's health should remain unchanged");
        assertEquals(0, player.getXP(), "Player's XP should remain unchanged");
    }
}
