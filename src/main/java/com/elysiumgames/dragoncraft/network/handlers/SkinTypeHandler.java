package com.elysiumgames.dragoncraft.network.handlers;

import com.elysiumgames.dragoncraft.network.PlayerStatusVariables;
import net.minecraft.world.entity.Entity;


public class SkinTypeHandler {
    public enum SkinType {
        FROST_DEMON,
        NAMEKIAN,
        HUMANOID
    }

    public static boolean hasSkin(Entity entity, int id) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        if (id == 0) {
            return playerVariables.bodyType.equals("namekian") || playerVariables.bodyType.equals("frost_demon");
        } else {
            return playerVariables.bodyType.equals("frost_demon");
        }
    }

    public static boolean hasSkinColor(Entity entity, SkinType type, int id, int typeID) {
        assert entity != null;

        PlayerStatusVariables.PlayerVariables playerVariables = entity.getCapability(PlayerStatusVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerStatusVariables.PlayerVariables());

        switch (type) {
            case FROST_DEMON -> {
                if (typeID == 1) {
                    if (id == 1) {
                        return playerVariables.skinColor1 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor1 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor1 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor1 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor1 == 5.0D;
                    }
                } else if (typeID == 2) {
                    if (id == 1) {
                        return playerVariables.skinColor2 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor2 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor2 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor2 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor2 == 5.0D;
                    }
                } else if (typeID == 3) {
                    if (id == 1) {
                        return playerVariables.skinColor3 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor3 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor3 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor3 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor3 == 5.0D;
                    }
                } else if (typeID == 4) {
                    if (id == 1) {
                        return playerVariables.skinColor4 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor4 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor4 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor4 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor4 == 5.0D;
                    }
                }
            }
            case NAMEKIAN -> {
                if (typeID == 1) {
                    if (id == 1) {
                        return playerVariables.skinColor1 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor1 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor1 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor1 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor1 == 5.0D;
                    }
                } else if (typeID == 2) {
                    if (id == 1) {
                        return playerVariables.skinColor2 == 1.0D;
                    }
                    if (id == 2) {
                        return playerVariables.skinColor2 == 2.0D;
                    }
                    if (id == 3) {
                        return playerVariables.skinColor2 == 3.0D;
                    }
                    if (id == 4) {
                        return playerVariables.skinColor2 == 4.0D;
                    }
                    if (id == 5) {
                        return playerVariables.skinColor2 == 5.0D;
                    }
                }
            }
            case HUMANOID -> {
                if (id == 1) {
                    return playerVariables.skinColor1 == 1.0D;
                }
                if (id == 2) {
                    return playerVariables.skinColor1 == 2.0D;
                }
                if (id == 3) {
                    return playerVariables.skinColor1 == 3.0D;
                }
                if (id == 4) {
                    return playerVariables.skinColor1 == 4.0D;
                }
                if (id == 5) {
                    return playerVariables.skinColor1 == 5.0D;
                }
            }
        }
        return false;
    }
}
