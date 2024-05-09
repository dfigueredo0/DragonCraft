package com.elysiumgames.dragoncraft.world.level.GameRules;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModGameRules {
    public static final GameRules.Key<GameRules.BooleanValue> RULE_DO_KI_ATTACK_EXPLODE = GameRules.register("", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
}
