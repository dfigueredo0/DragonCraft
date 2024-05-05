package com.elysiumgames.dragoncraft.fluid;

import com.elysiumgames.dragoncraft.DragonCraft;
import com.elysiumgames.dragoncraft.world.item.ModItems;
import com.elysiumgames.dragoncraft.world.level.block.ModBlocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, DragonCraft.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_HEALING_WATER = FLUIDS.register("healing_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HEALING_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HEALING_WATER = FLUIDS.register("flowing_healing_water_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HEALING_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HEALING_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HEALING_WATER_FLUID_TYPE, SOURCE_HEALING_WATER, FLOWING_HEALING_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.HEALING_WATER_BLOCK).bucket(ModItems.HEALING_WATER_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
