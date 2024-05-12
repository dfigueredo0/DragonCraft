package com.elysiumgames.dragoncraft.world.inventory;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DragonCraft.MOD_ID);

    public static final RegistryObject<MenuType<RacialSkillMenu>> ALIGNMENT_MENU = registerMenuType(RacialSkillMenu::new, "alignment_menu");
    public static final RegistryObject<MenuType<AltInventoryMenu>> ALT_INVENTORY_MENU = registerMenuType(AltInventoryMenu::new, "alt_inventory_menu");
    public static final RegistryObject<MenuType<DragonBallWishMenu>> DRAGON_BALL_WISH_MENU = registerMenuType(DragonBallWishMenu::new, "dragon_ball_wish_menu");
    public static final RegistryObject<MenuType<StatisticsMenu>> STATISTICS_MENU = registerMenuType(StatisticsMenu::new, "statistics_menu");
    public static final RegistryObject<MenuType<RacialSkillMenu>> RACIAL_SKILL_MENU = registerMenuType(RacialSkillMenu::new, "racial_skill_menu");
    public static final RegistryObject<MenuType<RacialSkillMenu>> WELCOME_MENU = registerMenuType(RacialSkillMenu::new, "welcome_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
