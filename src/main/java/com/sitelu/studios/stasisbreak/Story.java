package com.sitelu.studios.stasisbreak;

import java.util.Map;
import java.util.Scanner;

public class Story {
    private Scene startScene;
    private Character player;
    private Scanner scanner;
    private Scene currentScene;
    private Scene nextScene;
    private String input;
    private boolean flagInfo = false;
    private boolean flagHelp = false;
    private boolean flagDescription = true;
    private ChoiceResult result;
    private boolean isLastChoiceBlocked;
    private int maxStringLen = 100;

    public Story(Scene startScene, Character player) {
        this.startScene = startScene;
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.flagHelp = false;
        this.flagInfo = false;
    }

    public void start() {
        this.play();
    }

    public void play() {
        this.currentScene = this.startScene;

        PrintUtils.printBreak(maxStringLen, ' ');
        while (currentScene != null) {
            isLastChoiceBlocked = this.currentScene.isLastChoiceBlocked();

            if (this.player.getHealth() == 0)
                break;

            if (checkAllNextScene(this.currentScene) || checkAllChoice(currentScene))
                break;

            if (result != null && !isLastChoiceBlocked) {
                if (result.getEffectMessage() != null && !result.getEffectMessage().isBlank()) {
                    PrintUtils.printFormatted(result.getEffectMessage(), maxStringLen);
                }

                // notifikasi user when health or XP changed
                if (result.getAppliedDamage() > 0) {
                    PrintUtils.printFormatted("Kamu kehilangan " + result.getAppliedDamage() + " health!",
                            maxStringLen);
                }
                if (result.getAppliedXP() > 0) {
                    PrintUtils.printFormatted("Kamu mendapatkan " + result.getAppliedXP() + " XP!", maxStringLen);
                }

                // notifikasi user when item rewarded or destroyed
                if (result.getItemReward() != null) {
                    PrintUtils.printFormatted("Kamu mendapatkan item baru: " + result.getItemReward(), maxStringLen);
                }
                if (result.getItemDestory() != null) {
                    PrintUtils.printFormatted("Sebuah item telah dihancurkan: " + result.getItemDestory(),
                            maxStringLen);
                }
                // notifikasi setflag
                if (result.getSetFlagCondition() != null && !result.getSetFlagCondition().isEmpty()) {
                    for (Map.Entry<String, Boolean> entry : result.getSetFlagCondition().entrySet()) {
                        String flag = entry.getKey();
                        boolean value = entry.getValue();
                        PrintUtils.printFormatted(
                                "Flag '" + flag + "' telah diatur menjadi " + (value ? "aktif" : "tidak aktif") + ".",
                                maxStringLen);
                    }
                }
            }

            if (isLastChoiceBlocked) {
                RequiredChoiceEffect requiredEffect = this.currentScene.getRequiredEffect();
                if (requiredEffect != null) {
                    PrintUtils.printFormatted("Kamu TIDAK BISA MELILIH Opsi: " + input + " !\n", maxStringLen);

                    if (requiredEffect.getRequiredMessage() != null
                            && !requiredEffect.getRequiredMessage().isBlank()) {
                        PrintUtils.printFormatted(requiredEffect.getRequiredMessage(), maxStringLen);
                    }

                    PrintUtils.printFormatted("Syarat:", maxStringLen);

                    if (requiredEffect.getRequiredHealth() > 0) {
                        PrintUtils.printFormatted(
                                "- Minimum " + requiredEffect.getRequiredHealth()
                                        + " health",
                                maxStringLen);
                    }
                    if (requiredEffect.getRequiredXP() > 0) {
                        PrintUtils.printFormatted(
                                "- Minimum " + requiredEffect.getRequiredXP()
                                        + " XP",
                                maxStringLen);
                    }
                    if (requiredEffect.getRequiredTool() != null) {
                        PrintUtils.printFormatted(
                                "- Memiliki Alat '" + requiredEffect.getRequiredTool()
                                        + "'",
                                maxStringLen);
                    }

                    if (requiredEffect.getRequiredFlagCondition() != null
                            && !requiredEffect.getRequiredFlagCondition().isEmpty()) {
                        for (Map.Entry<String, Boolean> entry : requiredEffect.getRequiredFlagCondition()
                                .entrySet()) {
                            String flag = entry.getKey();
                            boolean condition = entry.getValue();
                            PrintUtils.printFormatted("- Kondisi flag '" + flag + "' harus "
                                    + (condition ? "aktif" : "tidak aktif"), maxStringLen);
                        }
                    }
                }
            }
            this.result = null;

            if (!flagHelp && !flagInfo) {
                this.currentScene.displayScene(flagDescription);
            }

            if (flagInfo) {
                printPlayerInfo();
                this.currentScene.displayScene(true);
                this.flagInfo = false;

            }

            if (flagHelp) {
                printHelp();
                this.flagHelp = false;
            }

            System.out.print("Enter your choice: ");
            this.input = scanner.nextLine().trim();
            PrintUtils.printBreak(maxStringLen, '=');

            // Casting 1,2,3 to A,B,C
            if (this.input.equals("1"))
                this.input = "A";
            if (this.input.equals("2"))
                this.input = "B";
            if (this.input.equals("3"))
                this.input = "C";
            if (this.input.equals("4"))
                this.input = "D";
            if (this.input.equals("5"))
                this.input = "E";

            if (this.input.equalsIgnoreCase("HELP") || this.input.equalsIgnoreCase("/HELP")
                    || this.input.equalsIgnoreCase("/H")) {
                this.flagHelp = true;
                continue;
            }

            if (this.input.equalsIgnoreCase("EXIT")) {
                currentScene = null;
                break;
            }

            if (this.input.equalsIgnoreCase("INFO")) {
                this.flagInfo = true;
                continue;
            }

            if (!this.input.matches("[1-5A-Ea-e]")) {
                System.out.println("\nInvalid choice, silahkan try again...");
                continue;
            }

            if (this.currentScene.getNextScene(this.input.toUpperCase(), false) == null) {
                System.out.println("\nInvalid choice, silahkan try again...");
                continue;
            }

            this.nextScene = this.currentScene.makeChoice(input, player);
            this.result = this.currentScene.getLastChoiceResult();
            this.isLastChoiceBlocked = this.currentScene.isLastChoiceBlocked();

            if (this.currentScene == this.nextScene) {
                if (!this.nextScene.isSceneUsed) {
                    this.flagDescription = false;
                }
            } else {
                this.currentScene.setSceneUsed(true);
            }
            this.currentScene = this.nextScene;
        }

        PrintUtils.printBreak(maxStringLen, '=', "GAME OVER");

        if (this.player.getHealth() == 0) {
            System.out.println("Wasted! kamu kehabisan Health!");
        } else {
            if (this.currentScene != null)
                printCurrentSceneDescription();
        }
    }

    private boolean checkAllChoice(Scene scene) {
        boolean isA = scene.getChoices("A", false) != null;
        boolean isB = scene.getChoices("B", false) != null;
        boolean isC = scene.getChoices("C", false) != null;
        boolean isD = scene.getChoices("D", false) != null;
        boolean isE = scene.getChoices("E", false) != null;
        int sum = (isA ? 1 : 0) + (isB ? 1 : 0) + (isC ? 1 : 0) + (isD ? 1 : 0) + (isE ? 1 : 0);
        return sum == 0;
    }

    private boolean checkAllNextScene(Scene scene) {
        boolean isA = scene.getNextScene("A", false) instanceof Scene;
        boolean isB = scene.getNextScene("B", false) instanceof Scene;
        boolean isC = scene.getNextScene("C", false) instanceof Scene;
        boolean isD = scene.getNextScene("D", false) instanceof Scene;
        boolean isE = scene.getNextScene("E", false) instanceof Scene;
        int sum = (isA ? 1 : 0) + (isB ? 1 : 0) + (isC ? 1 : 0) + (isD ? 1 : 0) + (isE ? 1 : 0);
        return sum == 0;
    }

    private void printPlayerInfo() {
        PrintUtils.printBreak(maxStringLen, '=', "Informasi Karakter");
        System.out.println(String.format("""
                Health    : %d
                XP        : %d
                Item      : %s
                """, this.player.getHealth(), this.player.getXP(), this.player.getItems()));
        if (this.player.getFlags() != null && !this.player.getFlags().isEmpty()) {
            System.out.println("Flags:");
            for (Map.Entry<String, Boolean> entry : this.player.getFlags().entrySet()) {
                String flag = entry.getKey();
                boolean value = entry.getValue();
                System.out.println(String.format("  - %s: %s", flag, value ? "aktif" : "tidak aktif"));
            }
        }
    }

    private void printCurrentSceneDescription() {
        System.out.println("\n" + this.currentScene.getDescription());
    }

    private void printHelp() {
        PrintUtils.printBreak(maxStringLen, '=', "HELP");
        System.out.println("""
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
                """);
        PrintUtils.printBreak(maxStringLen, '=');
    }

}
