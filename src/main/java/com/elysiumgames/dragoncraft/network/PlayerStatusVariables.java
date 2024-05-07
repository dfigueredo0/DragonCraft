package com.elysiumgames.dragoncraft.network;

import com.elysiumgames.dragoncraft.DragonCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlayerStatusVariables {
    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {});

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        DragonCraft.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerStatusVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
            }
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
            }
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
            }
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            event.getOriginal().revive();
            PlayerVariables original = event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            PlayerVariables clone = event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            //set all variables from clone equal to original.
            if (!event.isWasDeath());
            if (!event.getEntity().level().isClientSide()) {
                for (Entity entity : new ArrayList<>(event.getEntity().level().players())) {
                    entity.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new PlayerVariables())
                            .syncPlayerVariables(entity);
                }
            }
        }
    }

    @Mod.EventBusSubscriber
    private static class PlayerVariableProvider implements ICapabilitySerializable<Tag> {
        private final PlayerVariables playerVariables = new PlayerVariables();
        private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer)) {
                event.addCapability(new ResourceLocation(DragonCraft.MOD_ID, "player_variables"), new PlayerVariableProvider());
            }
        }
        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction) {
            return capability == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerVariables.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag tag) {
            playerVariables.readNBT(tag);
        }
    }

    public static class PlayerVariables {
        public String alignment = "Neutral";
        public String auraTexture = "\"\"";
        public boolean blocking = false;
        public String bodyType = "\"\"";
        public boolean isChargingKi = false;
        public boolean createdCharacter = false;
        public double currentDefense = 0.0; //Defense + DefenseFormula (added defense from Blocking)
        public boolean isDead = false;
        public double defense = 0.0; //Base Defense
        public double defenseFormula = 0.0;
        public String equippedSubForm = "\"\"";
        public String evasiveMove = "None";
        public double eyeColor = 1.0;
        public String eyeColorID = "\"\"";
        public double eyeType = 1.0;
        public String eyesTypeID = "dragoncraft:textures/entity/notexture.png";
        public String fightingClass = "Martial Artist";
        public boolean isFlying = false;
        public String form = "Form";
        public double formBoost = 1.0;
        public double formLevel = 0.0;
        public String formPath = "None";
        public boolean godKi = false;
        public double hairColor = 1.0;
        public String hairColorID = "dragoncraft:textures/entity/hair1.png";
        public double hairStyle = 1.0;
        public double health = 0.0;
        public double kaiokenLevel = 0.0;
        public double kaiokenMultiplier = 2.0;
        public boolean hasKaioken = false;
        public double ki = 0.0;
        public double kiDamage = 0.0;
        public double kiDrain = 0.0;
        public double kiPower = 0.0;
        public boolean hasKiSense = false;
        public boolean isLegendary = false;
        public double maxHealth = 0.0;
        public double maxKi = 0.0;
        public double maxStamina = 0.0;
        public double meleeDamage = 0.0;
        public double mental = 0.0;
        public String playerName = "\"\"";
        public double neededStatPoints = 5.0;
        public String playerCoords = "\"\"";
        public boolean isHighPLOn = false;
        public double powerInPercent = 0.0;
        public double powerLevel = 0.0;
        public double powerLimit = 0.5;
        public double powerReleaseTimer = 0.0;
        public String race = "None";
        public double releasedPower = 0.05;
        public boolean releasingPower = false;
        public double selectedKiSlot = 1.0;
        public boolean shootingKiBlast = false;
        public boolean showOverlay = false;
        public double skinColor1 = 1.0;
        public String skinColor1ID = "dragoncraft:textures/entity/test.png";
        public double skinColor2 = 0.0;
        public String skinColor2ID = "dragoncraft:textures/entity/notexture.png";
        public double skinColor3 = 0.0;
        public String skinColor3ID = "dragoncraft:textures/entity/notexture.png";
        public double skinColor4 = 0.0;
        public String skinColor4ID = "dragoncraft:textures/entity/notexture.png";
        public double speed = 0.0;
        public int superSaiyanLevel = 0;
        public int superSaiyan2Level = 0;
        public int superSaiyan3Level = 0;
        public int superSaiyanGodLevel = 0;
        public int superSaiyanBlueLevel = 0;
        public double stamina = 0.0;
        public boolean isStaminaPaused = false;
        public double staminaRegen = 0.0;
        public double staminaTimer = 0.0;
        public double strength = 1.0;
        public String subForm = "Base";
        public double subFormBoost = 1.0;
        public boolean hasSuperSaiyan = false;
        public double timePunch = 1.0;
        public double totalFormBoost = 0.0;
        public double statusPoints = 0.0;
        public boolean isTransforming = false;
        public boolean inTurboMode = false;
        public double zenkaiBoostLevel = 0.0;
        public boolean callAura = false;
        public String auraType = "\"\"";
        public String superAuraTexture = "\"\"";
        public String ultimateAuraTexture = "\"\"";
        public boolean hasTail = true;
        public double kiDrainTimer = 0.0;
        public double healthDrainTimer = 0.0;
        public double flyingSpeed = 2.0;
        public double kiBlastTimer = 0.0;
        public double auraTimer = 0.0;
        public boolean isFighting = false;
        public double fightingTimer = 0.0;
        public double fullPowerLevel  = 0.0;
        public double superNamekian = 0.0;
        public double orangeNamekian = 0.0;
        public double powerUnleashedLevel = 0.0;
        public double rageLevel = 0.0;
        public double humanBuff = 1.0;
        public double infiniteKiLevel = 0.0;
        public double kiAbsorption = 0.0;
        public double RaceAbilityCooldown = 0.0D;
        public boolean raceAbilityInCooldown = false;
        public double flyingLevel = 0.0D;
        public String skillPath = "\"\"";
        public double jumpLevel = 0.0D;
        public double potentialReleaseLevel = 0.0D;
        public String coolerFaceID = "\"\"";
        public double firstFormLevel = 1.0D;
        public double finalFormLevel = 0.0D;
        public double goldenLevel = 0.0D;
        public double blackLevel = 0.0D;
        public double turboDrainTimer = 0.0D;
        public double allocations = 0.0D;
        public double senzuBeanTimer = 0.0D;
        public boolean senzuBeanInTimer = false;
        public double endurance = 0.0D;
        public double maxEndurance = 0.0D;
        public double enduranceRegenTimer = 0.0D;
        public double formBoostDrainImpact = 0.0D;
        public double weights = 1.0D;
        public double weightSize = 0.0D;
        public double jumpTimer = 0.0D;
        public boolean isChargingAttack = false;
        public double attackCharge = 0.0D;
        public double attackKiCost = 0.0D;
        public double attackDamage = 0.0D;
        public double jumpTimer2 = 0.0D;
        public boolean rightMouseClicked = false;
        public String currentAttack = "\"\"";
        public double attackChargeTimer = 0.0D;
        public double UILevel = 0.0D;
        public double dodgeChance = 1.0D;
        public boolean dodging = false;
        public String attackType = "\"\"";
        public String lockedEntity = "\"\"";
        public boolean playerLocking = false;
        public double actualSpeed = 0.0D;
        public double weightAmount = 0.0D;
        public double environmentalWeight = 1.0D;
        public String selectedKiAttack = "\"\"";
        public String tempSlot = "\"\"";
        public double climbingKorinTower = 0.0D;
        public double dodgeTimer = 0.0D;
        public double cLevel = 1.0D;
        public double xp = 0.0D;
        public double maxXP = 5.0D;
        public double healingWaterTimer = 0.0D;
        public double xpIncrease = 0.0D;
        public boolean LockSet = false;
        public String frostDemonExtraSkin = "dbm:textures/entity/notexture.png";
        public double kiWaveTimer = 0.0D;
        public boolean kiWave = false;
        public boolean lightningAura = false;
        public double mysticLevel = 0.0D;
        public boolean none = false;
        public double superSayainRageLevel = 0.0D;
        public double beastLevel = 0.0D;


        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer) {
                Objects.requireNonNull(entity.level());
                DragonCraft.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with((entity.level()::dimension)),
                        new PlayerVariablesSyncMessage(this, entity.getId()));
            }
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putString("alignment", this.alignment);
            return nbt;
        }

        public void readNBT(Tag tag) {
            CompoundTag nbt = new CompoundTag();
        }

        @SubscribeEvent
        public static void registerMessage(FMLCommonSetupEvent event) {
            DragonCraft.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer,
                    PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
        }
    }

    public static class PlayerVariablesSyncMessage {
        private final int target;
        private final PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf pBuffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(pBuffer.readNbt());
            this.target = pBuffer.readInt();
        }

        public PlayerVariablesSyncMessage(PlayerVariables data, int entityId) {
            this.data = data;
            this.target = entityId;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf pBuffer) {
            pBuffer.writeNbt((CompoundTag) message.data.writeNBT());
            pBuffer.writeInt(message.target);

        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> supplier) {
            NetworkEvent.Context context = supplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
                }
            });
            context.setPacketHandled(true);
        }
    }
}
