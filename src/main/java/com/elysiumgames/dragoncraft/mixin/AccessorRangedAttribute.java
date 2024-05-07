package com.elysiumgames.dragoncraft.mixin;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RangedAttribute.class)
public interface AccessorRangedAttribute {
    @Accessor("minValue")
    @Mutable
    void dragoncraft$setMinValue(double minValue);

    @Accessor("maxValue")
    @Mutable
    void dragoncraft$setMaxValue(double maxValue);
}
