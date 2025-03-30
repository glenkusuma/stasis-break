package com.sitelu.studios.stasisbreak;

import java.util.HashMap;
import java.util.Map;

public class Scene {

    private String title = null, description = null, type = null;
    private String titleUsed = null, descriptionUsed = null, typeUsed = null;
    boolean isSceneUsed = false;

    private String choiceA = null, choiceB = null, choiceC = null, choiceD = null, choiceE = null;
    private String choiceAUsed = null, choiceBUsed = null, choiceCUsed = null, choiceDUsed = null, choiceEUsed = null;

    private Scene nextSceneA = null, nextSceneB = null, nextSceneC = null, nextSceneD = null, nextSceneE = null;
    private Scene nextSceneAUsed = null, nextSceneBUsed = null, nextSceneCUsed = null, nextSceneDUsed = null,
            nextSceneEUsed = null;

    private int damageA = 0, damageB = 0, damageC = 0, damageD = 0, damageE = 0;
    private int damageAUsed = 0, damageBUsed = 0, damageCUsed = 0, damageDUsed = 0, damageEUsed = 0;

    private int XPA = 0, XPB = 0, XPC = 0, XPD = 0, XPE = 0;
    private int XPAUsed = 0, XPBUsed = 0, XPCUsed = 0, XPDUsed = 0, XPEUsed = 0;

    private String effectMessageA = null, effectMessageB = null, effectMessageC = null, effectMessageD = null,
            effectMessageE = null;
    private String effectMessageAUsed = null, effectMessageBUsed = null, effectMessageCUsed = null,
            effectMessageDUsed = null, effectMessageEUsed = null;

    private String itemRewardA = null, itemRewardB = null, itemRewardC = null, itemRewardD = null, itemRewardE = null;
    private String itemRewardAUsed = null, itemRewardBUsed = null, itemRewardCUsed = null, itemRewardDUsed = null,
            itemRewardEUsed = null;

    private String itemDestroyA = null, itemDestroyB = null, itemDestroyC = null, itemDestroyD = null,
            itemDestroyE = null;
    private String itemDestroyAUsed = null, itemDestroyBUsed = null, itemDestroyCUsed = null, itemDestroyDUsed = null,
            itemDestroyEUsed = null;

    private boolean isChoiceAUsed = false, isChoiceBUsed = false, isChoiceCUsed = false, isChoiceDUsed = false,
            isChoiceEUsed = false;

    private ChoiceResult lastChoiceResult = null;

    public Scene(String title, String description, String type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA, String effectMessageA, String itemRewardA,
            String itemDestroyA,
            String choiceB, Scene nextSceneB, int damageB, int XPB, String effectMessageB, String itemRewardB,
            String itemDestroyB,
            String choiceC, Scene nextSceneC, int damageC, int XPC, String effectMessageC, String itemRewardC,
            String itemDestroyC) {
        this.description = description;
        this.choiceA = choiceA;
        this.nextSceneA = nextSceneA;
        this.damageA = damageA;
        this.XPA = XPA;
        this.effectMessageA = effectMessageA;
        this.itemRewardA = itemRewardA;
        this.itemDestroyA = itemDestroyA;
        this.choiceB = choiceB;
        this.nextSceneB = nextSceneB;
        this.damageB = damageB;
        this.XPB = XPB;
        this.effectMessageB = effectMessageB;
        this.itemRewardB = itemRewardB;
        this.itemDestroyB = itemDestroyB;
        this.choiceC = choiceC;
        this.nextSceneC = nextSceneC;
        this.damageC = damageC;
        this.XPC = XPC;
        this.effectMessageC = effectMessageC;
        this.itemRewardC = itemRewardC;
        this.itemDestroyC = itemDestroyC;
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA, String effectMessageA,
            String choiceB, Scene nextSceneB, int damageB, int XPB, String effectMessageB,
            String choiceC, Scene nextSceneC, int damageC, int XPC, String effectMessageC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, effectMessageA, null, null,
                choiceB, nextSceneB, damageB, XPB, effectMessageB, null, null,
                choiceC, nextSceneC, damageC, XPC, effectMessageC, null, null);
    }

    public Scene(
            String description,
            String choiceA, Scene nextSceneA, int damageA, int XPA,
            String choiceB, Scene nextSceneB, int damageB, int XPB,
            String choiceC, Scene nextSceneC, int damageC, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, null, null, null,
                choiceB, nextSceneB, damageB, XPB, null, null, null,
                choiceC, nextSceneC, damageC, XPC, null, null, null);
    }

    public Scene(
            String description,
            String choiceA, String choiceB, String choiceC,
            Scene nextSceneA, Scene nextSceneB, Scene nextSceneC,
            int damageA, int damageB, int damageC,
            int XPA, int XPB, int XPC) {
        this(
                description,
                choiceA, nextSceneA, damageA, XPA, null, null, null,
                choiceB, nextSceneB, damageB, XPB, null, null, null,
                choiceC, nextSceneC, damageC, XPC, null, null, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitleUsed() {
        return titleUsed;
    }

    public void setTitleUsed(String titleUsed) {
        this.titleUsed = titleUsed;
    }

    public String getDescriptionUsed() {
        return descriptionUsed;
    }

    public void setDescriptionUsed(String descriptionUsed) {
        this.descriptionUsed = descriptionUsed;
    }

    public String getTypeUsed() {
        return typeUsed;
    }

    public void setTypeUsed(String typeUsed) {
        this.typeUsed = typeUsed;
    }

    public boolean isSceneUsed() {
        return isSceneUsed;
    }

    public void setSceneUsed(boolean isSceneUsed) {
        this.isSceneUsed = isSceneUsed;
    }

    /**
     * Updates the scene's title, description, and type
     * based on whether the scene is marked as used.
     *
     * @param isSceneUsed whether the scene is in the "used" state
     * @param title       the title of the scene
     * @param description the description of the scene
     * @param type        the type of the scene
     */
    public void setScene(boolean isSceneUsed, String title, String description, String type) {
        if (isSceneUsed) {
            this.titleUsed = title;
            this.descriptionUsed = description;
            this.typeUsed = type;
        } else {
            this.title = title;
            this.description = description;
            this.type = type;
        }
    }

    /**
     * Sets all parameters for a specific choice key
     *
     * @param choiceKey   choice key ("A", "B", "C", "D", "E")
     * @param isUsed      whether this is "used" state
     * @param choice      choice description
     * @param nextScene   next scene for this choice
     * @param damage      damage value for this choice
     * @param XP          XP value for this choice
     * @param effect      effect message for this choice
     * @param itemReward  item reward for this choice
     * @param itemDestroy item to be destroyed for this choice
     */
    public void setChoices(String choiceKey, boolean isUsed, String choice, Scene nextScene, int damage, int XP,
            String effect, String itemReward, String itemDestroy) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed) {
                    this.choiceAUsed = choice;
                    this.nextSceneAUsed = nextScene;
                    this.damageAUsed = damage;
                    this.XPAUsed = XP;
                    this.effectMessageAUsed = effect;
                    this.itemRewardAUsed = itemReward;
                    this.itemDestroyAUsed = itemDestroy;
                } else {
                    this.choiceA = choice;
                    this.nextSceneA = nextScene;
                    this.damageA = damage;
                    this.XPA = XP;
                    this.effectMessageA = effect;
                    this.itemRewardA = itemReward;
                    this.itemDestroyA = itemDestroy;
                }
                break;
            case "B":
                if (isUsed) {
                    this.choiceBUsed = choice;
                    this.nextSceneBUsed = nextScene;
                    this.damageBUsed = damage;
                    this.XPBUsed = XP;
                    this.effectMessageBUsed = effect;
                    this.itemRewardBUsed = itemReward;
                    this.itemDestroyBUsed = itemDestroy;
                } else {
                    this.choiceB = choice;
                    this.nextSceneB = nextScene;
                    this.damageB = damage;
                    this.XPB = XP;
                    this.effectMessageB = effect;
                    this.itemRewardB = itemReward;
                    this.itemDestroyB = itemDestroy;
                }
                break;
            case "C":
                if (isUsed) {
                    this.choiceCUsed = choice;
                    this.nextSceneCUsed = nextScene;
                    this.damageCUsed = damage;
                    this.XPCUsed = XP;
                    this.effectMessageCUsed = effect;
                    this.itemRewardCUsed = itemReward;
                    this.itemDestroyCUsed = itemDestroy;
                } else {
                    this.choiceC = choice;
                    this.nextSceneC = nextScene;
                    this.damageC = damage;
                    this.XPC = XP;
                    this.effectMessageC = effect;
                    this.itemRewardC = itemReward;
                    this.itemDestroyC = itemDestroy;
                }
                break;
            case "D":
                if (isUsed) {
                    this.choiceDUsed = choice;
                    this.nextSceneDUsed = nextScene;
                    this.damageDUsed = damage;
                    this.XPDUsed = XP;
                    this.effectMessageDUsed = effect;
                    this.itemRewardDUsed = itemReward;
                    this.itemDestroyDUsed = itemDestroy;
                } else {
                    this.choiceD = choice;
                    this.nextSceneD = nextScene;
                    this.damageD = damage;
                    this.XPD = XP;
                    this.effectMessageD = effect;
                    this.itemRewardD = itemReward;
                    this.itemDestroyD = itemDestroy;
                }
                break;
            case "E":
                if (isUsed) {
                    this.choiceEUsed = choice;
                    this.nextSceneEUsed = nextScene;
                    this.damageEUsed = damage;
                    this.XPEUsed = XP;
                    this.effectMessageEUsed = effect;
                    this.itemRewardEUsed = itemReward;
                    this.itemDestroyEUsed = itemDestroy;
                } else {
                    this.choiceE = choice;
                    this.nextSceneE = nextScene;
                    this.damageE = damage;
                    this.XPE = XP;
                    this.effectMessageE = effect;
                    this.itemRewardE = itemReward;
                    this.itemDestroyE = itemDestroy;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    /**
     * Gets all parameters for a specific choice key as a Map
     *
     * @param choiceKey choice key ("A", "B", "C", "D", "E")
     * @param isUsed    whether this is "used" state
     * @return A map containing all parameters for choice
     */
    public Map<String, Object> getChoices(String choiceKey, boolean isUsed) {
        Map<String, Object> choiceMap = new HashMap<>();
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed) {
                    choiceMap.put("choice", choiceAUsed);
                    choiceMap.put("nextScene", nextSceneAUsed);
                    choiceMap.put("damage", damageAUsed);
                    choiceMap.put("XP", XPAUsed);
                    choiceMap.put("effect", effectMessageAUsed);
                    choiceMap.put("itemReward", itemRewardAUsed);
                    choiceMap.put("itemDestroy", itemDestroyAUsed);
                } else {
                    choiceMap.put("choice", choiceA);
                    choiceMap.put("nextScene", nextSceneA);
                    choiceMap.put("damage", damageA);
                    choiceMap.put("XP", XPA);
                    choiceMap.put("effect", effectMessageA);
                    choiceMap.put("itemReward", itemRewardA);
                    choiceMap.put("itemDestroy", itemDestroyA);
                }
                break;
            case "B":
                if (isUsed) {
                    choiceMap.put("choice", choiceBUsed);
                    choiceMap.put("nextScene", nextSceneBUsed);
                    choiceMap.put("damage", damageBUsed);
                    choiceMap.put("XP", XPBUsed);
                    choiceMap.put("effect", effectMessageBUsed);
                    choiceMap.put("itemReward", itemRewardBUsed);
                    choiceMap.put("itemDestroy", itemDestroyBUsed);
                } else {
                    choiceMap.put("choice", choiceB);
                    choiceMap.put("nextScene", nextSceneB);
                    choiceMap.put("damage", damageB);
                    choiceMap.put("XP", XPB);
                    choiceMap.put("effect", effectMessageB);
                    choiceMap.put("itemReward", itemRewardB);
                    choiceMap.put("itemDestroy", itemDestroyB);
                }
                break;
            case "C":
                if (isUsed) {
                    choiceMap.put("choice", choiceCUsed);
                    choiceMap.put("nextScene", nextSceneCUsed);
                    choiceMap.put("damage", damageCUsed);
                    choiceMap.put("XP", XPCUsed);
                    choiceMap.put("effect", effectMessageCUsed);
                    choiceMap.put("itemReward", itemRewardCUsed);
                    choiceMap.put("itemDestroy", itemDestroyCUsed);
                } else {
                    choiceMap.put("choice", choiceC);
                    choiceMap.put("nextScene", nextSceneC);
                    choiceMap.put("damage", damageC);
                    choiceMap.put("XP", XPC);
                    choiceMap.put("effect", effectMessageC);
                    choiceMap.put("itemReward", itemRewardC);
                    choiceMap.put("itemDestroy", itemDestroyC);
                }
                break;
            case "D":
                if (isUsed) {
                    choiceMap.put("choice", choiceDUsed);
                    choiceMap.put("nextScene", nextSceneDUsed);
                    choiceMap.put("damage", damageDUsed);
                    choiceMap.put("XP", XPDUsed);
                    choiceMap.put("effect", effectMessageDUsed);
                    choiceMap.put("itemReward", itemRewardDUsed);
                    choiceMap.put("itemDestroy", itemDestroyDUsed);
                } else {
                    choiceMap.put("choice", choiceD);
                    choiceMap.put("nextScene", nextSceneD);
                    choiceMap.put("damage", damageD);
                    choiceMap.put("XP", XPD);
                    choiceMap.put("effect", effectMessageD);
                    choiceMap.put("itemReward", itemRewardD);
                    choiceMap.put("itemDestroy", itemDestroyD);
                }
                break;
            case "E":
                if (isUsed) {
                    choiceMap.put("choice", choiceEUsed);
                    choiceMap.put("nextScene", nextSceneEUsed);
                    choiceMap.put("damage", damageEUsed);
                    choiceMap.put("XP", XPEUsed);
                    choiceMap.put("effect", effectMessageEUsed);
                    choiceMap.put("itemReward", itemRewardEUsed);
                    choiceMap.put("itemDestroy", itemDestroyEUsed);
                } else {
                    choiceMap.put("choice", choiceE);
                    choiceMap.put("nextScene", nextSceneE);
                    choiceMap.put("damage", damageE);
                    choiceMap.put("XP", XPE);
                    choiceMap.put("effect", effectMessageE);
                    choiceMap.put("itemReward", itemRewardE);
                    choiceMap.put("itemDestroy", itemDestroyE);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
        return choiceMap;
    }

    public String getChoice(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? choiceAUsed : choiceA;
            case "B":
                return isUsed ? choiceBUsed : choiceB;
            case "C":
                return isUsed ? choiceCUsed : choiceC;
            case "D":
                return isUsed ? choiceDUsed : choiceD;
            case "E":
                return isUsed ? choiceEUsed : choiceE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setChoice(String choiceKey, boolean isUsed, String value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    choiceAUsed = value;
                else
                    choiceA = value;
                break;
            case "B":
                if (isUsed)
                    choiceBUsed = value;
                else
                    choiceB = value;
                break;
            case "C":
                if (isUsed)
                    choiceCUsed = value;
                else
                    choiceC = value;
                break;
            case "D":
                if (isUsed)
                    choiceDUsed = value;
                else
                    choiceD = value;
                break;
            case "E":
                if (isUsed)
                    choiceEUsed = value;
                else
                    choiceE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public Scene getNextScene(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? nextSceneAUsed : nextSceneA;
            case "B":
                return isUsed ? nextSceneBUsed : nextSceneB;
            case "C":
                return isUsed ? nextSceneCUsed : nextSceneC;
            case "D":
                return isUsed ? nextSceneDUsed : nextSceneD;
            case "E":
                return isUsed ? nextSceneEUsed : nextSceneE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public Scene getNextScene(String choiceKey) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isChoiceAUsed ? nextSceneAUsed : nextSceneA;
            case "B":
                return isChoiceBUsed ? nextSceneBUsed : nextSceneB;
            case "C":
                return isChoiceCUsed ? nextSceneCUsed : nextSceneC;
            case "D":
                return isChoiceDUsed ? nextSceneDUsed : nextSceneD;
            case "E":
                return isChoiceEUsed ? nextSceneEUsed : nextSceneE;
            default:
                return null;
        }
    }

    public void setNextScene(String choiceKey, boolean isUsed, Scene value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    nextSceneAUsed = value;
                else
                    nextSceneA = value;
                break;
            case "B":
                if (isUsed)
                    nextSceneBUsed = value;
                else
                    nextSceneB = value;
                break;
            case "C":
                if (isUsed)
                    nextSceneCUsed = value;
                else
                    nextSceneC = value;
                break;
            case "D":
                if (isUsed)
                    nextSceneDUsed = value;
                else
                    nextSceneD = value;
                break;
            case "E":
                if (isUsed)
                    nextSceneEUsed = value;
                else
                    nextSceneE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public int getDamage(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? damageAUsed : damageA;
            case "B":
                return isUsed ? damageBUsed : damageB;
            case "C":
                return isUsed ? damageCUsed : damageC;
            case "D":
                return isUsed ? damageDUsed : damageD;
            case "E":
                return isUsed ? damageEUsed : damageE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setDamage(String choiceKey, boolean isUsed, int value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    damageAUsed = value;
                else
                    damageA = value;
                break;
            case "B":
                if (isUsed)
                    damageBUsed = value;
                else
                    damageB = value;
                break;
            case "C":
                if (isUsed)
                    damageCUsed = value;
                else
                    damageC = value;
                break;
            case "D":
                if (isUsed)
                    damageDUsed = value;
                else
                    damageD = value;
                break;
            case "E":
                if (isUsed)
                    damageEUsed = value;
                else
                    damageE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public int getXP(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? XPAUsed : XPA;
            case "B":
                return isUsed ? XPBUsed : XPB;
            case "C":
                return isUsed ? XPCUsed : XPC;
            case "D":
                return isUsed ? XPDUsed : XPD;
            case "E":
                return isUsed ? XPEUsed : XPE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setXP(String choiceKey, boolean isUsed, int value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    XPAUsed = value;
                else
                    XPA = value;
                break;
            case "B":
                if (isUsed)
                    XPBUsed = value;
                else
                    XPB = value;
                break;
            case "C":
                if (isUsed)
                    XPCUsed = value;
                else
                    XPC = value;
                break;
            case "D":
                if (isUsed)
                    XPDUsed = value;
                else
                    XPD = value;
                break;
            case "E":
                if (isUsed)
                    XPEUsed = value;
                else
                    XPE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public String getEffectMessage(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? effectMessageAUsed : effectMessageA;
            case "B":
                return isUsed ? effectMessageBUsed : effectMessageB;
            case "C":
                return isUsed ? effectMessageCUsed : effectMessageC;
            case "D":
                return isUsed ? effectMessageDUsed : effectMessageD;
            case "E":
                return isUsed ? effectMessageEUsed : effectMessageE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setEffectMessage(String choiceKey, boolean isUsed, String value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    effectMessageAUsed = value;
                else
                    effectMessageA = value;
                break;
            case "B":
                if (isUsed)
                    effectMessageBUsed = value;
                else
                    effectMessageB = value;
                break;
            case "C":
                if (isUsed)
                    effectMessageCUsed = value;
                else
                    effectMessageC = value;
                break;
            case "D":
                if (isUsed)
                    effectMessageDUsed = value;
                else
                    effectMessageD = value;
                break;
            case "E":
                if (isUsed)
                    effectMessageEUsed = value;
                else
                    effectMessageE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public String getItemReward(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? itemRewardAUsed : itemRewardA;
            case "B":
                return isUsed ? itemRewardBUsed : itemRewardB;
            case "C":
                return isUsed ? itemRewardCUsed : itemRewardC;
            case "D":
                return isUsed ? itemRewardDUsed : itemRewardD;
            case "E":
                return isUsed ? itemRewardEUsed : itemRewardE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setItemReward(String choiceKey, boolean isUsed, String value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    itemRewardAUsed = value;
                else
                    itemRewardA = value;
                break;
            case "B":
                if (isUsed)
                    itemRewardBUsed = value;
                else
                    itemRewardB = value;
                break;
            case "C":
                if (isUsed)
                    itemRewardCUsed = value;
                else
                    itemRewardC = value;
                break;
            case "D":
                if (isUsed)
                    itemRewardDUsed = value;
                else
                    itemRewardD = value;
                break;
            case "E":
                if (isUsed)
                    itemRewardEUsed = value;
                else
                    itemRewardE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public String getItemDestroy(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isUsed ? itemDestroyAUsed : itemDestroyA;
            case "B":
                return isUsed ? itemDestroyBUsed : itemDestroyB;
            case "C":
                return isUsed ? itemDestroyCUsed : itemDestroyC;
            case "D":
                return isUsed ? itemDestroyDUsed : itemDestroyD;
            case "E":
                return isUsed ? itemDestroyEUsed : itemDestroyE;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setItemDestroy(String choiceKey, boolean isUsed, String value) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                if (isUsed)
                    itemDestroyAUsed = value;
                else
                    itemDestroyA = value;
                break;
            case "B":
                if (isUsed)
                    itemDestroyBUsed = value;
                else
                    itemDestroyB = value;
                break;
            case "C":
                if (isUsed)
                    itemDestroyCUsed = value;
                else
                    itemDestroyC = value;
                break;
            case "D":
                if (isUsed)
                    itemDestroyDUsed = value;
                else
                    itemDestroyD = value;
                break;
            case "E":
                if (isUsed)
                    itemDestroyEUsed = value;
                else
                    itemDestroyE = value;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public boolean isChoiceUsed(String choiceKey) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                return isChoiceAUsed;
            case "B":
                return isChoiceBUsed;
            case "C":
                return isChoiceCUsed;
            case "D":
                return isChoiceDUsed;
            case "E":
                return isChoiceEUsed;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public void setChoiceUsed(String choiceKey, boolean isUsed) {
        switch (choiceKey.toUpperCase()) {
            case "A":
                isChoiceAUsed = isUsed;
                break;
            case "B":
                isChoiceBUsed = isUsed;
                break;
            case "C":
                isChoiceCUsed = isUsed;
                break;
            case "D":
                isChoiceDUsed = isUsed;
                break;
            case "E":
                isChoiceEUsed = isUsed;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice key: " + choiceKey);
        }
    }

    public ChoiceResult getLastChoiceResult() {
        return lastChoiceResult;
    }

    public void displayScene(boolean isDescription) {
        if (isDescription)
            System.out.println(this.description + "\n");

        System.out.println("\n==================================================================\n");
        String choiceA = getChoice("A", false);
        String choiceAUsed = getChoice("A", true);
        if (choiceA != null || choiceAUsed != null) {
            if (isChoiceUsed("A")) {
                System.out.println("1: " + choiceAUsed);
            } else {
                System.out.println("1: " + choiceA);
            }
        }

        String choiceB = getChoice("B", false);
        String choiceBUsed = getChoice("B", true);
        if (choiceB != null || choiceBUsed != null) {
            if (isChoiceUsed("B")) {
                System.out.println("2: " + choiceBUsed);
            } else {
                System.out.println("2: " + choiceB);
            }
        }

        String choiceC = getChoice("C", false);
        String choiceCUsed = getChoice("C", true);
        if (choiceC != null || choiceCUsed != null) {
            if (isChoiceUsed("C")) {
                System.out.println("3: " + choiceCUsed);
            } else {
                System.out.println("3: " + choiceC);
            }
        }

        String choiceD = getChoice("D", false);
        String choiceDUsed = getChoice("D", true);
        if (choiceD != null || choiceDUsed != null) {
            if (isChoiceUsed("D")) {
                System.out.println("4: " + choiceDUsed);
            } else {
                System.out.println("4: " + choiceD);
            }
        }

        String choiceE = getChoice("E", false);
        String choiceEUsed = getChoice("E", true);
        if (choiceE != null || choiceEUsed != null) {
            if (isChoiceUsed("E")) {
                System.out.println("5: " + choiceEUsed);
            } else {
                System.out.println("5: " + choiceE);
            }
        }
    }

    /**
     * Processes player's choice in current scene and determines next scene
     * and set choice's isChoiceUsed be true;
     *
     * @param choice choice made by player, Must not be null
     * @param player character making choice, Must not be null
     * @return next scene based on player's choice, or {@code null} if choice
     *         or player is invalid, or if choice effect could not be applied
     */
    public Scene makeChoice(String choice, Character player) {
        if (choice == null || player == null) {
            return null;
        }

        Scene nextScene = getNextScene(choice);
        // apply the choice effect and save the result
        ChoiceResult result = applyChoiceEffect(choice, player);
        if (result == null) {
            return null;
        }
        this.lastChoiceResult = result;

        if (!isChoiceUsed(choice))
            setChoiceUsed(choice, true);

        return nextScene;
    }

    public ChoiceResult applyChoiceEffect(String choice, Character player) {
        if (choice == null || player == null) {
            return null;
        }

        int appliedDamage;
        int appliedXP;
        String effectMessage;
        String itemReward = null;
        String itemDestroy = null;

        switch (choice.toUpperCase()) {
            case "A":
                appliedDamage = isChoiceAUsed ? damageAUsed : damageA;
                appliedXP = isChoiceAUsed ? XPAUsed : XPA;
                effectMessage = isChoiceAUsed ? effectMessageAUsed : effectMessageA;
                itemReward = isChoiceAUsed ? itemRewardAUsed : itemRewardA;
                itemDestroy = isChoiceAUsed ? itemDestroyAUsed : itemDestroyA;
                break;
            case "B":
                appliedDamage = isChoiceBUsed ? damageBUsed : damageB;
                appliedXP = isChoiceBUsed ? XPBUsed : XPB;
                effectMessage = isChoiceBUsed ? effectMessageBUsed : effectMessageB;
                itemReward = isChoiceBUsed ? itemRewardBUsed : itemRewardB;
                itemDestroy = isChoiceBUsed ? itemDestroyBUsed : itemDestroyB;
                break;
            case "C":
                appliedDamage = isChoiceCUsed ? damageCUsed : damageC;
                appliedXP = isChoiceCUsed ? XPCUsed : XPC;
                effectMessage = isChoiceCUsed ? effectMessageCUsed : effectMessageC;
                itemReward = isChoiceCUsed ? itemRewardCUsed : itemRewardC;
                itemDestroy = isChoiceCUsed ? itemDestroyCUsed : itemDestroyC;
                break;
            case "D":
                appliedDamage = isChoiceDUsed ? damageDUsed : damageD;
                appliedXP = isChoiceDUsed ? XPDUsed : XPD;
                effectMessage = isChoiceDUsed ? effectMessageDUsed : effectMessageD;
                itemReward = isChoiceDUsed ? itemRewardDUsed : itemRewardD;
                itemDestroy = isChoiceDUsed ? itemDestroyDUsed : itemDestroyD;
                break;
            case "E":
                appliedDamage = isChoiceEUsed ? damageEUsed : damageE;
                appliedXP = isChoiceEUsed ? XPEUsed : XPE;
                effectMessage = isChoiceEUsed ? effectMessageEUsed : effectMessageE;
                itemReward = isChoiceEUsed ? itemRewardEUsed : itemRewardE;
                itemDestroy = isChoiceEUsed ? itemDestroyEUsed : itemDestroyE;
                break;
            default:
                return null;
        }

        int oldHealth = player.getHealth();
        int oldXP = player.getXP();

        player.takeDamage(appliedDamage);
        player.addXP(appliedXP);

        if (itemReward != null && !itemReward.isEmpty()) {
            player.addItem(itemReward);
        }

        if (itemDestroy != null && !itemDestroy.isEmpty()) {
            player.removeItem(itemDestroy);
        }

        return new ChoiceResult(oldHealth, appliedDamage, oldXP, appliedXP, effectMessage);
    }

}
