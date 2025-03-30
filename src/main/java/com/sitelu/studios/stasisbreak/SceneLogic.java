package com.sitelu.studios.stasisbreak;

public interface SceneLogic {
    /**
     * Middleware to process the current scene and player's choice 
     * applying special rules for certain scenes, and returning the next scene
     *
     * @param story The story context
     * @param currentScene The current scene
     * @param choice The player's choice
     * @return The next scene
     */
    Scene evaluate(Story story, Scene currentScene, String choice);
}
