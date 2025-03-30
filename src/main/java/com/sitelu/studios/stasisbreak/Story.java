package com.sitelu.studios.stasisbreak;

import java.util.Scanner;

public class Story {
    private Scene startScene;
    private Character player;
    private Scanner scanner;
    private Scene currentScene;
    private Scene nextScene;
    private String input;
    private boolean flagInfo;
    private boolean flagHelp;

    private SceneLogic sceneLogic;

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

        while (currentScene != null) {

            if (this.player.getHealth() == 0)
                break;

            if (checkAllNextScene(this.currentScene))
                break;

            if (!flagHelp && !flagInfo)
                this.currentScene.displayScene();

            if (flagHelp) {
                printHelp();
                this.flagHelp = false;

            }
            if (flagInfo) {
                printPlayerInfo();
                this.flagInfo = false;
            }
            System.out.print("Enter your choice: ");
            this.input = scanner.nextLine().trim();

            // casting 1,2,3 to A,B,C
            if (this.input.equals("1"))
                this.input = "A";
            if (this.input.equals("2"))
                this.input = "B";
            if (this.input.equals("3"))
                this.input = "C";

            if (this.input.equalsIgnoreCase("HELP") || this.input.equalsIgnoreCase("/HELP")
                    || this.input.equalsIgnoreCase("/H")) {
                this.flagHelp = true;
                continue;
            }

            if (this.input.equalsIgnoreCase("EXIT"))
                break;

            if (this.input.equalsIgnoreCase("INFO")) {
                this.flagInfo = true;
                continue;
            }

            ChoiceResult result = this.currentScene.applyChoiceEffect(input, player);
            if (result == null) {
                System.out.println("\nInvalid choice, silahkan try again...\n");
                continue;
            }

            System.out.println("\n==================================================================\n");

            // notify user wehn health or XP changed
            if (result.getAppliedDamage() > 0) {
                System.out.println("Kamu kehilangan " + result.getAppliedDamage() + " health!");
            }
            if (result.getAppliedXP() > 0) {
                System.out.println("Kamu mendapatkan " + result.getAppliedXP() + " XP!");
            }
            if (result.getEffectMessage() != null && !result.getEffectMessage().isBlank()) {
                System.out.println(result.getEffectMessage());
            }
            // notify user wehn item rewarded or destroyed
            if (result.getItemReward() != null) {
                System.out.println("Kamu mendapatkan item baru: " + result.getItemReward());
            }
            if (result.getItemDestory() != null) {
                System.out.println("Sebuah item telah dihancurkan: " + result.getItemDestory());
            }

            // scenelogic middleware / depedency injection
            if (sceneLogic != null) {
                this.nextScene = sceneLogic.evaluate(this, currentScene, input);
            } else {
                this.nextScene = this.currentScene.getNextScene(input);
            }

            this.currentScene = this.nextScene;
        }

        System.out.println("\n================================= GAME OVER =================================");

        if (this.player.getHealth() == 0) {
            System.out.println("Wasted! kamu kehabisan Health!");
        } else {

            if (this.currentScene != null)
                printCurrentSceneDescription();
        }
    }

    private boolean checkAllNextScene(Scene scene) {
        boolean isA = scene.getNextSceneA() instanceof Scene;
        boolean isB = scene.getNextSceneB() instanceof Scene;
        boolean isC = scene.getNextSceneC() instanceof Scene;
        int sum = (isA ? 1 : 0) + (isB ? 1 : 0) + (isC ? 1 : 0);
        return sum == 0;
    }

    private void printPlayerInfo() {
        System.out.println(String.format("""
                \n\n================================= Informasi Karakter =================================
                Health    : %d
                XP        : %d
                Item      : %s
                """, this.player.getHealth(), this.player.getXP(), this.player.getItems()));
    }

    private void printCurrentSceneDescription() {
        System.out.println("\n" + this.currentScene.getDescription());
    }

    private void printHelp() {
        System.out.println("""
                ================================ HELP =================================
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
                ========================================================================
                """);

    }

}
