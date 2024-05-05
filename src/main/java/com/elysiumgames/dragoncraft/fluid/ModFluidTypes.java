package com.elysiumgames.dragoncraft.fluid;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DragonCraft.MOD_ID);

    public static final RegistryObject<FluidType> HEALING_WATER_FLUID_TYPE = registerFluidType("healing_water_fluid",
            new BaseFluidType(FluidType.Properties.create().lightLevel(2).viscosity(5).density(15),
                    WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xA14DFF4D, new Vector3f(77.0F / 255.0F, 1.0f, 77.0F / 255.0F)))

    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
