package com.sitelu.studios.stasisbreak;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoryTest {

    private Scene startScene;
    private Scene secondScene;
    private Scene EndingScene;
    private Character testCharacter;

    @BeforeEach
    public void setUp() {
        /**
         * We'll create a small chain of scenes:
         *
         * StartScene -> (Choice A) -> secondScene
         * -> (Choice B) -> EndingScene
         * -> (Choice C) -> invalid (null), or we can define a third scene if you want
         *
         * secondScene -> (Choice A) -> EndingScene
         * -> (Choice B) -> invalid
         * -> (Choice C) -> invalid
         *
         * EndingScene -> no next scenes, ends game
         *
         * We'll give some effect messages & small damage/XP to show how it's tested
         */

        EndingScene = new Scene(
                "Ending Scene You've reached end of your journey!",
                null, null, 0, 0, "No more moves",
                null, null, 0, 0, "No more moves",
                null, null, 0, 0, "No more moves");

        secondScene = new Scene(
                "You are now in second scene!",
                "Fight a small monster", EndingScene, 5, 10, "You bravely defeat monster!",
                "Take a quick nap", null, 0, 0, "You nap... but nothing really happens",
                "Ignore everything", null, 0, 0, "You ignore your surroundings");

        startScene = new Scene(
                "This is start scene",
                "Go to second scene", secondScene, 2, 5, "You push onward bravely!",
                "Skip to ending", EndingScene, 10, 20, "You took a risky shortcut to end!",
                "Unknown path", secondScene, 0, 0, "It's too dark to proceed here");

        testCharacter = new Character("TestPlayer", 50);
    }

    /**
     * Basic flow test: "A" then "A"
     * - StartScene (A) -> secondScene
     * - secondScene (A) -> EndingScene
     * 
     * Expected:
     * - Health after first A: 50 - 2 = 48
     * - XP after first A: 0 + 5 = 5
     * - Health after second A: 48 - 5 = 43
     * - XP after second A: 5 + 10 = 15
     * - Reaches EndingScene
     */
    @Test
    public void testBasicFlow() {
        // simulated input: "A" -> choose first scene's A, then "A" -> secondScene's A
        String simulatedInput = "A\nA\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        // restore I/O
        System.setIn(originalIn);
        System.setOut(originalOut);

        // verify final state
        assertEquals(43, testCharacter.getHealth(), "Health should end at 43 after choosing (A, A)");
        assertEquals(15, testCharacter.getXP(), "XP should end at 15 after choosing (A, A)");

        // check that we ended on EndingScene
        assertTrue(outContent.toString().contains("Ending Scene"),
                "Output should show ending scene description");
    }

    /**
     * Invalid input test
     * - User enters something invalid first, then a valid choice
     * 
     * We'll do:
     * - Input: "Z" (invalid) then "C" (which leads nowhere)
     * 
     * Expected:
     * - Game should print "Invalid choice please try again..."
     * - Then accept "C", apply effect, show effect message, but we have nextScene =
     * null
     * - Game ends after startScene because nextScene is null
     */
    @Test
    public void testInvalidInput() {
        String simulatedInput = "Z\nC\nA\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();

        assertTrue(output.contains("Invalid choice, silahkan try again..."),
                "Output should contain message for invalid choice 'Z'");

        assertTrue(output.contains("Unknown path"),
                "Scene description for choice C effect message should appear (Unknown path)");

    }

    /**
     * Case Insensitivity test:
     * - We pass "a" in lowercase
     * - This should be treated same as "A"
     * - In startScene, "A" deals 2 damage, grants 5 XP, nextScene => secondScene
     *
     * Expected:
     * - Health: 50 - 2 = 48
     * - XP: 0 + 5 = 5
     * - We see effect message for choiceA ("You push onward bravely!")
     * - We end up in secondScene
     */
    @Test
    public void testCaseInsensitiveChoice() {
        String simulatedInput = "a\nEXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        assertEquals(48, testCharacter.getHealth(), "Health should be 48 after choice A");
        assertEquals(5, testCharacter.getXP(), "XP should be 5 after choice A");

        String output = outContent.toString();
        assertTrue(output.contains("push onward bravely"),
                "Effect message for choice A should appear in output");
        assertTrue(output.contains("second scene"),
                "We should transition to second scene after choice A");
    }

    /**
     * Test that effect messages are actually displayed
     * We'll pick "A" from startScene, which has effect message "You push onward
     * bravely!"
     * 
     * We confirm that output includes that message right after we make choice
     */
    @Test
    public void testEffectMessageDisplayed() {
        String simulatedInput = "A\nEXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("You push onward bravely!"),
                "Should display effect message for choice A in startScene");
    }

    /**
     * Test "INFO" command
     * - User types INFO first, verifying it prints player's stats,
     * then we pick "A" to proceed to secondScene
     */
    @Test
    public void testInfoCommand() {
        String simulatedInput = "INFO\nA\nEXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();

        assertTrue(output.contains("Health    : 50"), "INFO command should display player's health");
        assertTrue(output.contains("XP        : 0"), "INFO command should display player's XP");

        assertEquals(48, testCharacter.getHealth(), "Health should be 50 - 2 = 48 after choice A");
        assertEquals(5, testCharacter.getXP(), "XP should be 0 + 5 = 5 after choice A");
    }

    /**
     * Test "HELP" command
     * - User types HELP, verifying it prints help text
     * - Then chooses "C" to produce a quick game exit (null next scene)
     */
    @Test
    public void testHelpCommand() {
        String simulatedInput = "HELP\nC\nA\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("""
                =============================================== HELP ===============================================
                Welcome to Stasis Break!
                Dalam game ini, your choices determine your fate >:D

                Commands:
                  INFO   - Lihat status player saat ini (health, XP, items, dll)
                  HELP   - Tampilkan halaman help ini
                  EXIT   - Keluar dari game secara langsung
                  A/B/C  - Pilih opsi scene (input bersifat case-insensitive)

                Tips:
                  - Gunakan INFO kapan saja untuk mengecek status player
                  - Keputusanmu mempengruhi health & XP, so pilihlah dengan bijak!
                  - Explore semua opsi tuk temukan hidden outcomes & endings

                ====================================================================================================
                                """),
                "HELP command should print usage for help/info/exit");
        assertTrue(output.contains("Invalid choice, silahkan try again...") || output.contains("GAME OVER")
                || output.contains("Unknown path"),
                "After choosing 'C', we either see effect message or end game because nextScene is null");
    }

    /**
     * Test "EXIT" command:
     * - User types EXIT as first action
     * - Game should immediately stop & print "GAME OVER"
     * - No damage or XP is applied
     */
    @Test
    public void testExitCommand() {
        String simulatedInput = "EXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("GAME OVER"), "Should print 'GAME OVER' when player exits");
        assertEquals(50, testCharacter.getHealth(), "No damage is applied if we exit immediately");
        assertEquals(0, testCharacter.getXP(), "No XP is gained if we exit immediately");
    }

    /**
     * Test consecutive choices leading to end
     * (Scene transitions until no more next scenes)
     *
     * We'll do a simple path: StartScene(B) -> EndingScene
     * EndingScene has no next scenes, so game finishes
     */
    @Test
    public void testConsecutiveSceneDecisions() {

        String simulatedInput = "B\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        assertEquals(40, testCharacter.getHealth(), "Health should be 50 - 10 after picking 'B'");
        assertEquals(20, testCharacter.getXP(), "XP should be 0 + 20 after picking 'B'");

        String output = outContent.toString();
        assertTrue(output.contains("Ending Scene"), "Should display ending scene description");
        assertTrue(output.contains("GAME OVER"), "Game should end after ending scene with no next scene");
    }

    public static void main(String[] args) {
        Character player;
        Scene startScene, finalScene, EndingSceneA, EndingSceneB, EndingSceneC;

        EndingSceneA = new Scene("You've Got The Good Ending", "", null, 0, 0, "",
                null, 0, 0, "", null, 0, 0);
        EndingSceneB = new Scene("You've Got The BAD Ending", "", null, 0, 0, "",
                null, 0, 0, "", null, 0, 0);
        EndingSceneC = new Scene("You've Got The Meh Ending", "", null, 0, 0, "",
                null, 0, 0, "", null, 0, 0);

        finalScene = new Scene("Final Scene, choice wizely",
                "A EndingSceneA", EndingSceneA, 10, 5,
                "B EndingSceneB", EndingSceneB, 20, 10,
                "C EndingSceneC", EndingSceneC, 50, 20);

        startScene = new Scene(
                "Final Scene",
                "A finalScene", finalScene, 10, 0,
                "B finalScene", finalScene, 5, 5,
                "C finalScene", finalScene, 60, 30);

        player = new Character("TestCharacter", 100);

        Story story = new Story(startScene, player);

        story.start();
    }

    /**
     * Test a complete game flow where the user makes valid choices
     * 
     * Scenario:
     * - startScene: "Start Scene" with "Choice A" to finalScene -> inflicting 10
     * damage & granting 10 XP
     * - finalScene: "Final Scene" with "Choice B" to EndingScene -> inflicting 5
     * damage & granting 5 XP
     * - EndingScene: "Ending" with all nextScene set to null
     * 
     * Expected:
     * - startScene: character's health from 100 to 90, & XP from 0 to 10
     * - finalScene: character's health from 90 to 85, & XP from 10 to 15
     * - EndingScene: The game loop ends when the EndingScene all nextScene returns
     * null
     */
    @Test
    public void testPlayGameFlow() {
        Scene EndingScene = new Scene(
                "You Have Won! this is the Ending Description",
                "", null, 0, 0,
                "", null, 0, 0,
                "", null, 0, 0);

        Scene finalScene = new Scene(
                "Final Scene",
                "Choice A", null, 0, 0,
                "Choice B", EndingScene, 5, 5,
                "Choice C", null, 0, 0);

        Scene startScene = new Scene(
                "Start Scene",
                "Choice A", finalScene, 10, 10,
                "Choice B", null, 0, 0,
                "Choice C", null, 0, 0);

        Character testCharacter = new Character("TestPlayer", 100);

        String simulatedInput = "A\nB\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("Start Scene"), "Output should contain 'Start Scene' description");
        assertTrue(output.contains("Final Scene"), "Output should contain 'Final Scene' description");
        assertTrue(output.contains("You Have Won! this is the Ending Description"),
                "Output should contain 'You Have Won! this is the Ending Description' description");

        assertEquals(85, testCharacter.getHealth(), "Character's health should be 85 after game test flow");
        assertEquals(15, testCharacter.getXP(), "Character's XP should be 15 after game test flow");
    }

    /**
     * Test the game flow when the user enters "EXIT" to quit
     * 
     * - The game loop terminates, printing the "GAME OVER" message
     * - The character's attributes (health & XP) remain unchanged
     */
    @Test
    public void testExitGameFlow() {
        Scene EndingScene = new Scene(
                "You Have Won! this is the Ending Description",
                "", null, 0, 0,
                "", null, 0, 0,
                "", null, 0, 0);

        Scene startScene = new Scene(
                "Start Scene",
                "Choice A", EndingScene, 10, 10,
                "Choice B", null, 0, 0,
                "Choice C", null, 0, 0);

        Character testCharacter = new Character("TestPlayer", 100);

        String simulatedInput = "EXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(startScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("GAME OVER"), "Output should contain 'GAME OVER' when the game exits");

        assertEquals(100, testCharacter.getHealth(), "Character's health should remain unchanged on exit");
        assertEquals(0, testCharacter.getXP(), "Character's XP should remain unchanged on exit");
    }

    /**
     * Test that the overloaded constructor (which does not take effect messages)
     * defaults the effect messages to an empty string.
     * We simulate a valid choice ("A", "B", "C") & then verify that the returned
     * ChoiceResult has an empty effect message.
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
     * Test applyChoiceEffect() with a null choice.
     * Expected: The method should return null & not modify the player's
     * attributes.
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
     * Test applyChoiceEffect() with a null player.
     * Expected: The method should return null.
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

    @Test
    public void testGameEndsWhenPlayerHealthReachesZero() {
        Scene zeroHealthScene = new Scene(
                "Zero Health Scene",
                "Choice A", EndingScene, 100, 0, "You took fatal damage!",
                "Choice B", EndingScene, 100, 0, "You took fatal damage!",
                "Choice C", EndingScene, 100, 0, "You took fatal damage!");

        Character testCharacter = new Character("TestPlayer", 100);

        String simulatedInput = "A\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Story story = new Story(zeroHealthScene, testCharacter);
        story.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String output = outContent.toString();
        assertTrue(output.contains("GAME OVER"), "Output should contain 'GAME OVER' when health reaches zero");
        assertTrue(output.contains("Wasted! kamu kehabisan Health!"),
                "Output should contain 'You have Died' when health reaches zero");

        assertEquals(0, testCharacter.getHealth(), "Player's health should be zero after taking fatal damage");
    }

    @Test
    public void testEffectMessageHandling() {
        Scene nullEffectMessageScene = new Scene(
                "Null Effect Message Scene",
                "Choice A", startScene, 0, 0, null,
                "Choice B", startScene, 0, 0, null,
                "Choice C", startScene, 0, 0, null);

        Scene nonEmptyEffectMessageScene = new Scene(
                "Non-Empty Effect Message Scene",
                "Choice A", startScene, 0, 0, "You feel a sense of accomplishment",
                "Choice B", startScene, 0, 0, "You feel a sudden chill",
                "Choice C", startScene, 0, 0, "You hear a distant echo");

        Character testCharacter = new Character("TestPlayer", 100);

        // null effect message
        String simulatedInputNull = "A\nEXIT\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInputNull.getBytes()));

        ByteArrayOutputStream outContentNull = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContentNull));

        Story storyNull = new Story(nullEffectMessageScene, testCharacter);
        storyNull.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String outputNull = outContentNull.toString();
        assertFalse(outputNull.contains("null"), "Output should not contain 'null' for a null effect message");

        // non-empty effect message
        String simulatedInputNonEmpty = "A\nEXIT\n";
        System.setIn(new ByteArrayInputStream(simulatedInputNonEmpty.getBytes()));

        ByteArrayOutputStream outContentNonEmpty = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentNonEmpty));

        Story storyNonEmpty = new Story(nonEmptyEffectMessageScene, testCharacter);
        storyNonEmpty.start();

        System.setIn(originalIn);
        System.setOut(originalOut);

        String outputNonEmpty = outContentNonEmpty.toString();
        assertTrue(outputNonEmpty.contains("You feel a sense of accomplishment"),
                "Output should contain the non-empty effect message");
    }

    @Test
    public void testHelpCommandVariants() {
        String[] simulatedInputs = { "HELP\nEXIT\n", "/HELP\nEXIT\n", "/H\nEXIT\n" };
        String expectedHelpMessage = """
                =============================================== HELP ===============================================
                Welcome to Stasis Break!
                Dalam game ini, your choices determine your fate >:D

                Commands:
                  INFO   - Lihat status player saat ini (health, XP, items, dll)
                  HELP   - Tampilkan halaman help ini
                  EXIT   - Keluar dari game secara langsung
                  A/B/C  - Pilih opsi scene (input bersifat case-insensitive)

                Tips:
                  - Gunakan INFO kapan saja untuk mengecek status player
                  - Keputusanmu mempengruhi health & XP, so pilihlah dengan bijak!
                  - Explore semua opsi tuk temukan hidden outcomes & endings

                ====================================================================================================
                                """;

        for (String simulatedInput : simulatedInputs) {
            InputStream originalIn = System.in;
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outContent));

            Story story = new Story(startScene, testCharacter);
            story.start();

            System.setIn(originalIn);
            System.setOut(originalOut);

            String output = outContent.toString();
            assertTrue(output.contains(expectedHelpMessage), "Help message should be displayed for HELP variants");

            assertTrue(output.contains("GAME OVER"), "Game should continue & end properly after HELP commands");
        }
    }
}
