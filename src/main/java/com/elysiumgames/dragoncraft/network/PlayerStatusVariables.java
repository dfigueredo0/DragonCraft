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
import net.minecraft.world.item.ItemStack;
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
            clone.alignment = original.alignment;
            clone.altFunction = original.altFunction;
            clone.auraTexture = original.auraTexture;
            clone.blocking = original.blocking;
            clone.bodyType = original.bodyType;
            clone.isChargingKi = original.isChargingKi;
            clone.createdCharacter = original.createdCharacter;
            clone.currentDefense = original.currentDefense;
            clone.isDead = original.isDead;
            clone.defense = original.defense;
            clone.defenseFormula = original.defenseFormula;
            clone.equippedSubForm = original.equippedSubForm;
            clone.evasiveMove = original.evasiveMove;
            clone.eyeColor = original.eyeColor;
            clone.eyeColorID = original.eyeColorID;
            clone.eyeType = original.eyeType;
            clone.eyesTypeID = original.eyesTypeID;
            clone.fightingClass = original.fightingClass;
            clone.isFlying = original.isFlying;
            clone.form = original.form;
            clone.formBoost = original.formBoost;
            clone.formLevel = original.formLevel;
            clone.formPath = original.formPath;
            //clone.formTimer = original.formTimer;
            clone.godKi = original.godKi;
            clone.hairColor = original.hairColor;
            clone.hairColorID = original.hairColorID;
            clone.hairStyle = original.hairStyle;
            clone.health = original.health;
            clone.kaiokenLevel = original.kaiokenLevel;
            clone.kaiokenMultiplier = original.kaiokenMultiplier;
            clone.hasKaioken = original.hasKaioken;
            clone.ki = original.ki;
            clone.kiDamage = original.kiDamage;
            clone.kiDrain = original.kiDrain;
            clone.kiPower = original.kiPower;
            clone.hasKiSense = original.hasKiSense;
            clone.isLegendary = original.isLegendary;
            clone.maxHealth = original.maxHealth;
            clone.maxKi = original.maxKi;
            clone.maxStamina = original.maxStamina;
            clone.meleeDamage = original.meleeDamage;
            clone.mental = original.mental;
            clone.playerName = original.playerName;
            clone.neededStatPoints = original.neededStatPoints;
            clone.playerCoords = original.playerCoords;
            clone.isHighPLOn = original.isHighPLOn;
            clone.powerInPercent = original.powerInPercent;
            clone.powerLevel = original.powerLevel;
            clone.powerLimit = original.powerLimit;
            clone.powerReleaseTimer = original.powerReleaseTimer;
            clone.race = original.race;
            clone.releasedPower = original.releasedPower;
            clone.releasingPower = original.releasingPower;
            clone.selectedKiSlot = original.selectedKiSlot;
            clone.shootingKiBlast = original.shootingKiBlast;
            clone.showOverlay = original.showOverlay;
            clone.skinColor1 = original.skinColor1;
            clone.skinColor1ID = original.skinColor1ID;
            clone.skinColor2 = original.skinColor2;
            clone.skinColor2ID = original.skinColor2ID;
            clone.skinColor3 = original.skinColor3;
            clone.skinColor3ID = original.skinColor3ID;
            clone.skinColor4 = original.skinColor4;
            clone.skinColor4ID = original.skinColor4ID;
            clone.speed = original.speed;
            clone.superSaiyan2Level = original.superSaiyan2Level;
            clone.superSaiyanBlueLevel = original.superSaiyanBlueLevel;
            clone.superSaiyanGodLevel = original.superSaiyanGodLevel;
            clone.superSaiyanLevel = original.superSaiyanLevel;
            clone.stamina = original.stamina;
            clone.isStaminaPaused = original.isStaminaPaused;
            clone.staminaRegen = original.staminaRegen;
            clone.staminaTimer = original.staminaTimer;
            clone.strength = original.strength;
            clone.subForm = original.subForm;
            clone.subFormBoost = original.subFormBoost;
            clone.hasSuperSaiyan = original.hasSuperSaiyan;
            clone.timePunch = original.timePunch;
            clone.totalFormBoost = original.totalFormBoost;
            clone.statusPoints = original.statusPoints;
            clone.isTransforming = original.isTransforming;
            clone.inTurboMode = original.inTurboMode;
            clone.zenkaiBoostLevel = original.zenkaiBoostLevel;
            clone.topSlot0 = original.topSlot0;
            clone.tShirtSlot1 = original.tShirtSlot1;
            clone.pantsSlot2 = original.pantsSlot2;
            clone.bootsSlot3 = original.bootsSlot3;
            clone.wristbandSlot4 = original.wristbandSlot4;
            clone.beltSlot5 = original.beltSlot5;
            clone.weightSlot6 = original.weightSlot6;
            clone.callAura = original.callAura;
            clone.auraType = original.auraType;
            clone.superAuraTexture = original.superAuraTexture;
            clone.ultimateAuraTexture = original.ultimateAuraTexture;
            clone.hasTail = original.hasTail;
            clone.kiDrainTimer = original.kiDrainTimer;
            clone.healthDrainTimer = original.healthDrainTimer;
            //clone.healthDrain = original.healthDrain;
            clone.flyingSpeed = original.flyingSpeed;
            clone.kiBlastTimer = original.kiBlastTimer;
            clone.auraTimer = original.auraTimer;
            //clone.fightingMode = original.fightingMode;
            clone.fightingTimer = original.fightingTimer;
            clone.fullPowerLevel = original.fullPowerLevel;
            clone.superNamekian = original.superNamekian;
            clone.orangeNamekian = original.orangeNamekian;
            clone.powerUnleashedLevel = original.powerUnleashedLevel;
            clone.rageLevel = original.rageLevel;
            clone.humanBuff = original.humanBuff;
            clone.infiniteKiLevel = original.infiniteKiLevel;
            clone.kiAbsorption = original.kiAbsorption;
            clone.scouterSlot7 = original.scouterSlot7;
            clone.topID = original.topID;
            clone.tShirtID = original.tShirtID;
            clone.pantsID = original.pantsID;
            clone.bootsID = original.bootsID;
            clone.wristbandsID = original.wristbandsID;
            clone.beltID = original.beltID;
            clone.weightID = original.weightID;
            clone.scouterID = original.scouterID;
            clone.raceAbilityCooldown = original.raceAbilityCooldown;
            clone.raceAbilityInCooldown = original.raceAbilityInCooldown;
            clone.flyingLevel = original.flyingLevel;
            clone.skillPath = original.skillPath;
            clone.jumpLevel = original.jumpLevel;
            clone.potentialReleaseLevel = original.potentialReleaseLevel;
            clone.coolerFaceID = original.coolerFaceID;
            clone.firstFormLevel = original.firstFormLevel;
            clone.finalFormLevel = original.finalFormLevel;
            clone.goldenLevel = original.goldenLevel;
            clone.blackLevel = original.blackLevel;
            clone.turboDrainTimer = original.turboDrainTimer;
            clone.allocations = original.allocations;
            clone.senzuBeanTimer = original.senzuBeanTimer;
            clone.senzuBeanInTimer = original.senzuBeanInTimer;
            clone.endurance = original.endurance;
            clone.maxEndurance = original.maxEndurance;
            clone.enduranceRegenTimer = original.enduranceRegenTimer;
            clone.formBoostDrainImpact = original.formBoostDrainImpact;
            clone.weights = original.weights;
            clone.weightSize = original.weightSize;
            clone.jumpTimer = original.jumpTimer;
            clone.isChargingAttack = original.isChargingAttack;
            clone.attackCharge = original.attackCharge;
            clone.attackKiCost = original.attackKiCost;
            clone.attackDamage = original.attackDamage;
            clone.jumpTimer2 = original.jumpTimer2;
            clone.rightMouseClicked = original.rightMouseClicked;
            clone.currentAttack = original.currentAttack;
            clone.attackChargeTimer = original.attackChargeTimer;
            clone.UILevel = original.UILevel;
            clone.dodgeChance = original.dodgeChance;
            clone.dodging = original.dodging;
            clone.attackType = original.attackType;
            clone.lockedEntity = original.lockedEntity;
            clone.playerLocking = original.playerLocking;
            clone.actualSpeed = original.actualSpeed;
            clone.weightAmount = original.weightAmount;
            clone.environmentalWeight = original.environmentalWeight;
            clone.selectedKiAttack = original.selectedKiAttack;
            clone.tempSlot = original.tempSlot;
            clone.climbingKorinTower = original.climbingKorinTower;
            clone.dodgeTimer = original.dodgeTimer;
            clone.cLevel = original.cLevel;
            clone.xp = original.xp;
            clone.maxXP = original.maxXP;
            clone.healingWaterTimer = original.healingWaterTimer;
            clone.xpIncrease = original.xpIncrease;
            clone.lockSet = original.lockSet;
            clone.frostDemonExtraSkin = original.frostDemonExtraSkin;
            clone.kiWaveTimer = original.kiWaveTimer;
            clone.kiWave = original.kiWave;
            clone.lightningAura = original.lightningAura;
            clone.mysticLevel = original.mysticLevel;
            clone.none = original.none;
            clone.superSayainRageLevel = original.superSayainRageLevel;
            clone.beastLevel = original.beastLevel;
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
        public boolean altFunction = false;
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
        public int eyeType = 1;
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
        public double raceAbilityCooldown = 0.0D;
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
        public boolean lockSet = false;
        public String frostDemonExtraSkin = "dragoncraft:textures/entity/notexture.png";
        public double kiWaveTimer = 0.0D;
        public boolean kiWave = false;
        public boolean lightningAura = false;
        public double mysticLevel = 0.0D;
        public boolean none = false;
        public double superSayainRageLevel = 0.0D;
        public double beastLevel = 0.0D;
        public ItemStack topSlot0 = ItemStack.EMPTY;
        public ItemStack tShirtSlot1 = ItemStack.EMPTY;
        public ItemStack pantsSlot2 = ItemStack.EMPTY;
        public ItemStack bootsSlot3 = ItemStack.EMPTY;
        public ItemStack wristbandSlot4 = ItemStack.EMPTY;
        public ItemStack beltSlot5 = ItemStack.EMPTY;
        public ItemStack weightSlot6 = ItemStack.EMPTY;
        public ItemStack scouterSlot7 = ItemStack.EMPTY;
        public String topID = "dragoncraft:textures/entities/notexture.png";
        public String tShirtID = "dragoncraft:textures/entities/notexture.png";
        public String pantsID = "dragoncraft:textures/entities/notexture.png";
        public String bootsID = "dragoncraft:textures/entities/notexture.png";
        public String wristbandsID = "dragoncraft:textures/entities/notexture.png";
        public String beltID = "dragoncraft:textures/entities/notexture.png";
        public String weightID = "dragoncraft:textures/entities/notexture.png";
        public String scouterID = "dragoncraft:textures/entities/notexture.png";

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
            nbt.putBoolean("altFunction", this.altFunction);
            nbt.putString("auraTexture", this.auraTexture);
            nbt.putBoolean("blocking", this.blocking);
            nbt.putString("bodyType", this.bodyType);
            nbt.putBoolean("isChargingKi", this.isChargingKi);
            nbt.putBoolean("createdCharacter", this.createdCharacter);
            nbt.putDouble("currentDefense", this.currentDefense);
            nbt.putBoolean("isDead", this.isDead);
            nbt.putDouble("defense", this.defense);
            nbt.putDouble("defenseFormula", this.defenseFormula);
            nbt.putString("equippedSubForm", this.equippedSubForm);
            nbt.putString("evasiveMove", this.evasiveMove);
            nbt.putDouble("eyeColor", this.eyeColor);
            nbt.putString("eyeColorID", this.eyeColorID);
            nbt.putInt("eyeType", this.eyeType);
            nbt.putString("eyesTypeID", this.eyesTypeID);
            nbt.putString("fightingClass", this.fightingClass);
            nbt.putBoolean("isFlying", this.isFlying);
            nbt.putString("form", this.form);
            nbt.putDouble("formBoost", this.formBoost);
            nbt.putDouble("formLevel", this.formLevel);
            nbt.putString("formPath", this.formPath);
            nbt.putBoolean("godKi", this.godKi);
            nbt.putDouble("hairColor", this.hairColor);
            nbt.putString("hairColorID", this.hairColorID);
            nbt.putDouble("hairStyle", this.hairStyle);
            nbt.putDouble("health", this.health);
            nbt.putDouble("kaiokenLevel", this.kaiokenLevel);
            nbt.putDouble("kaiokenMultiplier", this.kaiokenMultiplier);
            nbt.putBoolean("hasKaioken", this.hasKaioken);
            nbt.putDouble("ki", this.ki);
            nbt.putDouble("kiDamage", this.kiDamage);
            nbt.putDouble("kiDrain", this.kiDrain);
            nbt.putDouble("kiPower", this.kiPower);
            nbt.putBoolean("hasKiSense", this.hasKiSense);
            nbt.putBoolean("isLegendary", this.isLegendary);
            nbt.putDouble("maxHealth", this.maxHealth);
            nbt.putDouble("maxKi", this.maxKi);
            nbt.putDouble("maxStamina", this.maxStamina);
            nbt.putDouble("meleeDamage", this.meleeDamage);
            nbt.putDouble("mental", this.mental);
            nbt.putString("playerName", this.playerName);
            nbt.putDouble("neededStatPoints", this.neededStatPoints);
            nbt.putString("playerCoords", this.playerCoords);
            nbt.putBoolean("isHighPLOn", this.isHighPLOn);
            nbt.putDouble("powerInPercent", this.powerInPercent);
            nbt.putDouble("powerLevel", this.powerLevel);
            nbt.putDouble("powerLimit", this.powerLimit);
            nbt.putDouble("powerReleaseTimer", this.powerReleaseTimer);
            nbt.putString("race", this.race);
            nbt.putDouble("releasedPower", this.releasedPower);
            nbt.putBoolean("releasingPower", this.releasingPower);
            nbt.putDouble("selectedKiSlot", this.selectedKiSlot);
            nbt.putBoolean("shootingKiBlast", this.shootingKiBlast);
            nbt.putBoolean("showOverlay", this.showOverlay);
            nbt.putDouble("skinColor1", this.skinColor1);
            nbt.putString("skinColor1ID", this.skinColor1ID);
            nbt.putDouble("skinColor2", this.skinColor2);
            nbt.putString("skinColor2ID", this.skinColor2ID);
            nbt.putDouble("skinColor3", this.skinColor3);
            nbt.putString("skinColor3ID", this.skinColor3ID);
            nbt.putDouble("skinColor4", this.skinColor4);
            nbt.putString("skinColor4ID", this.skinColor4ID);
            nbt.putDouble("speed", this.speed);
            nbt.putInt("superSaiyanLevel", this.superSaiyanLevel);
            nbt.putInt("superSaiyan2Level", this.superSaiyan2Level);
            nbt.putInt("superSaiyan3Level", this.superSaiyan3Level);
            nbt.putInt("superSaiyanGodLevel", this.superSaiyanGodLevel);
            nbt.putInt("superSaiyanBlueLevel", this.superSaiyanBlueLevel);
            nbt.putDouble("stamina", this.stamina);
            nbt.putBoolean("isStaminaPaused", this.isStaminaPaused);
            nbt.putDouble("staminaRegen", this.staminaRegen);
            nbt.putDouble("staminaTimer", this.staminaTimer);
            nbt.putDouble("strength", this.strength);
            nbt.putString("subForm", this.subForm);
            nbt.putDouble("subFormBoost", this.subFormBoost);
            nbt.putBoolean("hasSuperSaiyan", this.hasSuperSaiyan);
            nbt.putDouble("timePunch", this.timePunch);
            nbt.putDouble("totalFormBoost", this.totalFormBoost);
            nbt.putDouble("statusPoints", this.statusPoints);
            nbt.putBoolean("isTransforming", this.isTransforming);
            nbt.putBoolean("inTurboMode", this.inTurboMode);
            nbt.putDouble("zenkaiBoostLevel", this.zenkaiBoostLevel);
            nbt.putBoolean("callAura", this.callAura);
            nbt.putString("auraType", this.auraType);
            nbt.putString("superAuraTexture", this.superAuraTexture);
            nbt.putString("ultimateAuraTexture", this.ultimateAuraTexture);
            nbt.putBoolean("hasTail", this.hasTail);
            nbt.putDouble("kiDrainTimer", this.kiDrainTimer);
            nbt.putDouble("healthDrainTimer", this.healthDrainTimer);
            nbt.putDouble("flyingSpeed", this.flyingSpeed);
            nbt.putDouble("kiBlastTimer", this.kiBlastTimer);
            nbt.putDouble("auraTimer", this.auraTimer);
            nbt.putBoolean("isFighting", this.isFighting);
            nbt.putDouble("fightingTimer", this.fightingTimer);
            nbt.putDouble("fullPowerLevel", this.fullPowerLevel);
            nbt.putDouble("superNamekian", this.superNamekian);
            nbt.putDouble("orangeNamekian", this.orangeNamekian);
            nbt.putDouble("powerUnleashedLevel", this.powerUnleashedLevel);
            nbt.putDouble("rageLevel", this.rageLevel);
            nbt.putDouble("humanBuff", this.humanBuff);
            nbt.putDouble("infiniteKiLevel", this.infiniteKiLevel);
            nbt.putDouble("kiAbsorption", this.kiAbsorption);
            nbt.putDouble("RaceAbilityCooldown", this.raceAbilityCooldown);
            nbt.putBoolean("raceAbilityInCooldown", this.raceAbilityInCooldown);
            nbt.putDouble("flyingLevel", this.flyingLevel);
            nbt.putString("skillPath", this.skillPath);
            nbt.putDouble("jumpLevel", this.jumpLevel);
            nbt.putDouble("potentialReleaseLevel", this.potentialReleaseLevel);
            nbt.putString("coolerFaceID", this.coolerFaceID);
            nbt.putDouble("firstFormLevel", this.firstFormLevel);
            nbt.putDouble("finalFormLevel", this.finalFormLevel);
            nbt.putDouble("goldenLevel", this.goldenLevel);
            nbt.putDouble("blackLevel", this.blackLevel);
            nbt.putDouble("turboDrainTimer", this.turboDrainTimer);
            nbt.putDouble("allocations", this.allocations);
            nbt.putDouble("senzuBeanTimer", this.senzuBeanTimer);
            nbt.putBoolean("senzuBeanInTimer", this.senzuBeanInTimer);
            nbt.putDouble("endurance", this.endurance);
            nbt.putDouble("maxEndurance", this.maxEndurance);
            nbt.putDouble("enduranceRegenTimer", this.enduranceRegenTimer);
            nbt.putDouble("formBoostDrainImpact", this.formBoostDrainImpact);
            nbt.putDouble("weights", this.weights);
            nbt.putDouble("weightSize", this.weightSize);
            nbt.putDouble("jumpTimer", this.jumpTimer);
            nbt.putBoolean("isChargingAttack", this.isChargingAttack);
            nbt.putDouble("attackCharge", this.attackCharge);
            nbt.putDouble("attackKiCost", this.attackKiCost);
            nbt.putDouble("attackDamage", this.attackDamage);
            nbt.putDouble("jumpTimer2", this.jumpTimer2);
            nbt.putBoolean("rightMouseClicked", this.rightMouseClicked);
            nbt.putString("currentAttack", this.currentAttack);
            nbt.putDouble("attackChargeTimer", this.attackChargeTimer);
            nbt.putDouble("UILevel", this.UILevel);
            nbt.putDouble("dodgeChance", this.dodgeChance);
            nbt.putBoolean("dodging", this.dodging);
            nbt.putString("attackType", this.attackType);
            nbt.putString("lockedEntity", this.lockedEntity);
            nbt.putBoolean("playerLocking", this.playerLocking);
            nbt.putDouble("actualSpeed", this.actualSpeed);
            nbt.putDouble("weightAmount", this.weightAmount);
            nbt.putDouble("environmentalWeight", this.environmentalWeight);
            nbt.putString("selectedKiAttack", this.selectedKiAttack);
            nbt.putString("tempSlot", this.tempSlot);
            nbt.putDouble("climbingKorinTower", this.climbingKorinTower);
            nbt.putDouble("dodgeTimer", this.dodgeTimer);
            nbt.putDouble("cLevel", this.cLevel);
            nbt.putDouble("xp", this.xp);
            nbt.putDouble("maxXP", this.maxXP);
            nbt.putDouble("healingWaterTimer", this.healingWaterTimer);
            nbt.putDouble("xpIncrease", this.xpIncrease);
            nbt.putBoolean("lockSet", this.lockSet);
            nbt.putString("frostDemonExtraSkin", this.frostDemonExtraSkin);
            nbt.putDouble("kiWaveTimer", this.kiWaveTimer);
            nbt.putBoolean("kiWave", this.kiWave);
            nbt.putBoolean("lightningAura", this.lightningAura);
            nbt.putDouble("mysticLevel", this.mysticLevel);
            nbt.putBoolean("none", this.none);
            nbt.putDouble("superSayainRageLevel", this.superSayainRageLevel);
            nbt.putDouble("beastLevel", this.beastLevel);
            nbt.putString("topID", this.topID);
            nbt.putString("tShirtID", this.tShirtID);
            nbt.putString("pantsID", this.pantsID);
            nbt.putString("bootsID", this.bootsID);
            nbt.putString("wristbandsID", this.wristbandsID);
            nbt.putString("beltID", this.beltID);
            nbt.putString("weightID", this.weightID);
            nbt.putString("scouterID", this.scouterID);
            nbt.put("topSlot0", this.topSlot0.serializeNBT());
            nbt.put("tShirtSlot1", this.tShirtSlot1.serializeNBT());
            nbt.put("pantsSlot2", this.pantsSlot2.serializeNBT());
            nbt.put("bootsSlot3", this.bootsSlot3.serializeNBT());
            nbt.put("wristbandSlot4", this.wristbandSlot4.serializeNBT());
            nbt.put("beltSlot5", this.beltSlot5.serializeNBT());
            nbt.put("weightSlot6", this.weightSlot6.serializeNBT());
            nbt.put("scouterSlot7", this.scouterSlot7.serializeNBT());
            return nbt;
        }

        public void readNBT(Tag tag) {
            CompoundTag nbt = new CompoundTag();
            this.alignment = nbt.getString("alignment");
            this.altFunction = nbt.getBoolean("altFunction");
            this.auraTexture = nbt.getString("auraTexture");
            this.blocking = nbt.getBoolean("blocking");
            this.bodyType = nbt.getString("bodyType");
            this.isChargingKi = nbt.getBoolean("isChargingKi" );
            this.createdCharacter = nbt.getBoolean("createdCharacter");
            this.currentDefense = nbt.getDouble("currentDefense");
            this.isDead = nbt.getBoolean("isDead");
            this.defense = nbt.getDouble("defense");
            this.defenseFormula = nbt.getDouble("defenseFormula");
            this.equippedSubForm = nbt.getString("equippedSubForm");
            this.evasiveMove = nbt.getString("evasiveMove");
            this.eyeColor = nbt.getDouble("eyeColor");
            this.eyeColorID = nbt.getString("eyeColorID");
            this.eyeType = nbt.getInt("eyeType");
            this.eyesTypeID = nbt.getString("eyesTypeID");
            this.fightingClass = nbt.getString("fightingClass");
            this.isFlying = nbt.getBoolean("isFlying");
            this.form = nbt.getString("form");
            this.formBoost = nbt.getDouble("formBoost");
            this.formLevel = nbt.getDouble("formLevel");
            this.formPath = nbt.getString("formPath");
            this.godKi = nbt.getBoolean("godKi");
            this.hairColor = nbt.getDouble("hairColor");
            this.hairColorID = nbt.getString("hairColorID" );
            this.hairStyle = nbt.getDouble("hairStyle");
            this.health = nbt.getDouble("health");
            this.kaiokenLevel = nbt.getDouble("kaiokenLevel");
            this.kaiokenMultiplier = nbt.getDouble("kaiokenMultiplier");
            this.hasKaioken = nbt.getBoolean("hasKaioken");
            this.ki = nbt.getDouble("ki");
            this.kiDamage = nbt.getDouble("kiDamage");
            this.kiDrain = nbt.getDouble("kiDrain");
            this.kiPower = nbt.getDouble("kiPower");
            this.hasKiSense = nbt.getBoolean("hasKiSense");
            this.isLegendary = nbt.getBoolean("isLegendary");
            this.maxHealth = nbt.getDouble("maxHealth");
            this.maxKi = nbt.getDouble("maxKi");
            this.maxStamina = nbt.getDouble("maxStamina");
            this.meleeDamage = nbt.getDouble("meleeDamage");
            this.mental = nbt.getDouble("mental");
            this.playerName = nbt.getString("playerName");
            this.neededStatPoints = nbt.getDouble("neededStatPoints");
            this.playerCoords = nbt.getString("playerCoords");
            this.isHighPLOn = nbt.getBoolean("isHighPLOn");
            this.powerInPercent = nbt.getDouble("powerInPercent");
            this.powerLevel = nbt.getDouble("powerLevel");
            this.powerLimit = nbt.getDouble("powerLimit");
            this.powerReleaseTimer = nbt.getDouble("powerReleaseTimer");
            this.race = nbt.getString("race");
            this.releasedPower = nbt.getDouble("releasedPower");
            this.releasingPower = nbt.getBoolean("releasingPower");
            this.selectedKiSlot = nbt.getDouble("selectedKiSlot");
            this.shootingKiBlast = nbt.getBoolean("shootingKiBlast");
            this.showOverlay = nbt.getBoolean("showOverlay");
            this.skinColor1 = nbt.getDouble("skinColor1");
            this.skinColor1ID = nbt.getString("skinColor1ID");
            this.skinColor2 = nbt.getDouble("skinColor2");
            this.skinColor2ID = nbt.getString("skinColor2ID");
            this.skinColor3 = nbt.getDouble("skinColor3");
            this.skinColor3ID = nbt.getString("skinColor3ID");
            this.skinColor4 = nbt.getDouble("skinColor4");
            this.skinColor4ID = nbt.getString("skinColor4ID");
            this.speed = nbt.getDouble("speed");
            this.superSaiyanLevel = nbt.getInt("superSaiyanLevel");
            this.superSaiyan2Level = nbt.getInt("superSaiyan2Level");
            this.superSaiyan3Level = nbt.getInt("superSaiyan3Level");
            this.superSaiyanGodLevel = nbt.getInt("superSaiyanGodLevel");
            this.superSaiyanBlueLevel = nbt.getInt("superSaiyanBlueLevel");
            this.stamina = nbt.getDouble("stamina");
            this.isStaminaPaused = nbt.getBoolean("isStaminaPaused");
            this.staminaRegen = nbt.getDouble("staminaRegen");
            this.staminaTimer = nbt.getDouble("staminaTimer");
            this.strength = nbt.getDouble("strength");
            this.subForm = nbt.getString("subForm");
            this.subFormBoost = nbt.getDouble("subFormBoost");
            this.hasSuperSaiyan = nbt.getBoolean("hasSuperSaiyan");
            this.timePunch = nbt.getDouble("timePunch");
            this.totalFormBoost = nbt.getDouble("totalFormBoost");
            this.statusPoints = nbt.getDouble("statusPoints");
            this.isTransforming = nbt.getBoolean("isTransforming");
            this.inTurboMode = nbt.getBoolean("inTurboMode");
            this.zenkaiBoostLevel = nbt.getDouble("zenkaiBoostLevel");
            this.callAura = nbt.getBoolean("callAura");
            this.auraType = nbt.getString("auraType");
            this.superAuraTexture = nbt.getString("superAuraTexture");
            this.ultimateAuraTexture = nbt.getString("ultimateAuraTexture");
            this.hasTail = nbt.getBoolean("hasTail");
            this.kiDrainTimer = nbt.getDouble("kiDrainTimer");
            this.healthDrainTimer = nbt.getDouble("healthDrainTimer");
            this.flyingSpeed = nbt.getDouble("flyingSpeed");
            this.kiBlastTimer = nbt.getDouble("kiBlastTimer");
            this.auraTimer = nbt.getDouble("auraTimer");
            this.isFighting = nbt.getBoolean("isFighting");
            this.fightingTimer = nbt.getDouble("fightingTimer");
            this.fullPowerLevel = nbt.getDouble("fullPowerLevel");
            this.superNamekian = nbt.getDouble("superNamekian");
            this.orangeNamekian = nbt.getDouble("orangeNamekian");
            this.powerUnleashedLevel = nbt.getDouble("powerUnleashedLevel");
            this.rageLevel = nbt.getDouble("rageLevel");
            this.humanBuff = nbt.getDouble("humanBuff");
            this.infiniteKiLevel = nbt.getDouble("infiniteKiLevel");
            this.kiAbsorption = nbt.getDouble("kiAbsorption");
            this.raceAbilityCooldown = nbt.getDouble("RaceAbilityCooldown");
            this.raceAbilityInCooldown = nbt.getBoolean("raceAbilityInCooldown");
            this.flyingLevel = nbt.getDouble("flyingLevel");
            this.skillPath = nbt.getString("skillPath");
            this.jumpLevel = nbt.getDouble("jumpLevel");
            this.potentialReleaseLevel = nbt.getDouble("potentialReleaseLevel");
            this.coolerFaceID = nbt.getString("coolerFaceID");
            this.firstFormLevel = nbt.getDouble("firstFormLevel");
            this.finalFormLevel = nbt.getDouble("finalFormLevel");
            this.goldenLevel = nbt.getDouble("goldenLevel");
            this.blackLevel = nbt.getDouble("blackLevel");
            this.turboDrainTimer = nbt.getDouble("turboDrainTimer");
            this.allocations = nbt.getDouble("allocations");
            this.senzuBeanTimer = nbt.getDouble("senzuBeanTimer");
            this.senzuBeanInTimer = nbt.getBoolean("senzuBeanInTimer");
            this.endurance = nbt.getDouble("endurance");
            this.maxEndurance = nbt.getDouble("maxEndurance");
            this.enduranceRegenTimer = nbt.getDouble("enduranceRegenTimer");
            this.formBoostDrainImpact = nbt.getDouble("formBoostDrainImpact");
            this.weights = nbt.getDouble("weights");
            this.weightSize = nbt.getDouble("weightSize");
            this.jumpTimer = nbt.getDouble("jumpTimer");
            this.isChargingAttack = nbt.getBoolean("isChargingAttack");
            this.attackCharge = nbt.getDouble("attackCharge");
            this.attackKiCost = nbt.getDouble("attackKiCost");
            this.attackDamage = nbt.getDouble("attackDamage");
            this.jumpTimer2 = nbt.getDouble("jumpTimer2");
            this.rightMouseClicked = nbt.getBoolean("rightMouseClicked");
            this.currentAttack = nbt.getString("currentAttack");
            this.attackChargeTimer = nbt.getDouble("attackChargeTimer");
            this.UILevel = nbt.getDouble("UILevel");
            this.dodgeChance = nbt.getDouble("dodgeChance");
            this.dodging = nbt.getBoolean("dodging");
            this.attackType = nbt.getString("attackType");
            this.lockedEntity = nbt.getString("lockedEntity");
            this.playerLocking = nbt.getBoolean("playerLocking");
            this.actualSpeed = nbt.getDouble("actualSpeed");
            this.weightAmount = nbt.getDouble("weightAmount");
            this.environmentalWeight = nbt.getDouble("environmentalWeight");
            this.selectedKiAttack = nbt.getString("selectedKiAttack");
            this.tempSlot = nbt.getString("tempSlot");
            this.climbingKorinTower = nbt.getDouble("climbingKorinTower");
            this.dodgeTimer = nbt.getDouble("dodgeTimer");
            this.cLevel = nbt.getDouble("cLevel");
            this.xp = nbt.getDouble("xp");
            this.maxXP = nbt.getDouble("maxXP");
            this.healingWaterTimer = nbt.getDouble("healingWaterTimer");
            this.xpIncrease = nbt.getDouble("xpIncrease");
            this.lockSet = nbt.getBoolean("lockSet");
            this.frostDemonExtraSkin = nbt.getString("frostDemonExtraSkin");
            this.kiWaveTimer = nbt.getDouble("kiWaveTimer");
            this.kiWave = nbt.getBoolean("kiWave");
            this.lightningAura = nbt.getBoolean("lightningAura");
            this.mysticLevel = nbt.getDouble("mysticLevel");
            this.none = nbt.getBoolean("none");
            this.superSayainRageLevel = nbt.getDouble("superSayainRageLevel");
            this.beastLevel = nbt.getDouble("beastLevel");
            this.topID = nbt.getString("topID");
            this.tShirtID = nbt.getString("tShirtID");
            this.pantsID = nbt.getString("pantsID");
            this.bootsID = nbt.getString("bootsID");
            this.wristbandsID = nbt.getString("wristbandsID");
            this.beltID = nbt.getString("beltID");
            this.weightID = nbt.getString("weightID");
            this.scouterID = nbt.getString("scouterID");
            this.topSlot0 = ItemStack.of(nbt.getCompound("topSlot0"));
            this.tShirtSlot1 = ItemStack.of(nbt.getCompound("tShirtSlot1"));
            this.pantsSlot2 = ItemStack.of(nbt.getCompound("pantsSlot2"));
            this.bootsSlot3 = ItemStack.of(nbt.getCompound("bootsSlot3"));
            this.wristbandSlot4 = ItemStack.of(nbt.getCompound("wristbandSlot4"));
            this.beltSlot5 = ItemStack.of(nbt.getCompound("beltSlot5"));
            this.weightSlot6 = ItemStack.of(nbt.getCompound("weightSlot6"));
            this.scouterSlot7 = ItemStack.of(nbt.getCompound("scouterSlot7"));
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
            pBuffer.writeNbt((CompoundTag)message.data.writeNBT());
            pBuffer.writeInt(message.target);

        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> supplier) {
            NetworkEvent.Context context = supplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    assert Minecraft.getInstance().player != null;
                    PlayerVariables variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
                    variables.alignment = message.data.alignment;
                    variables.altFunction = message.data.altFunction;
                    variables.auraTexture = message.data.auraTexture;
                    variables.blocking = message.data.blocking;
                    variables.bodyType = message.data.bodyType;
                    variables.isChargingKi = message.data.isChargingKi;
                    variables.createdCharacter = message.data.createdCharacter;
                    variables.currentDefense = message.data.currentDefense;
                    variables.isDead = message.data.isDead;
                    variables.defense = message.data.defense;
                    variables.defenseFormula = message.data.defenseFormula;
                    variables.equippedSubForm = message.data.equippedSubForm;
                    variables.evasiveMove = message.data.evasiveMove;
                    variables.eyeColor = message.data.eyeColor;
                    variables.eyeColorID = message.data.eyeColorID;
                    variables.eyeType = message.data.eyeType;
                    variables.eyesTypeID = message.data.eyesTypeID;
                    variables.fightingClass = message.data.fightingClass;
                    variables.isFlying = message.data.isFlying;
                    variables.form = message.data.form;
                    variables.formBoost = message.data.formBoost;
                    variables.formLevel = message.data.formLevel;
                    variables.formPath = message.data.formPath;
                    variables.godKi = message.data.godKi;
                    variables.hairColor = message.data.hairColor;
                    variables.hairColorID = message.data.hairColorID;
                    variables.hairStyle = message.data.hairStyle;
                    variables.health = message.data.health;
                    variables.kaiokenLevel = message.data.kaiokenLevel;
                    variables.kaiokenMultiplier = message.data.kaiokenMultiplier;
                    variables.hasKaioken = message.data.hasKaioken;
                    variables.ki = message.data.ki;
                    variables.kiDamage = message.data.kiDamage;
                    variables.kiDrain = message.data.kiDrain;
                    variables.kiPower = message.data.kiPower;
                    variables.hasKiSense = message.data.hasKiSense;
                    variables.isLegendary = message.data.isLegendary;
                    variables.maxHealth = message.data.maxHealth;
                    variables.maxKi = message.data.maxKi;
                    variables.maxStamina = message.data.maxStamina;
                    variables.meleeDamage = message.data.meleeDamage;
                    variables.mental = message.data.mental;
                    variables.playerName = message.data.playerName;
                    variables.neededStatPoints = message.data.neededStatPoints;
                    variables.playerCoords = message.data.playerCoords;
                    variables.isHighPLOn = message.data.isHighPLOn;
                    variables.powerInPercent = message.data.powerInPercent;
                    variables.powerLevel = message.data.powerLevel;
                    variables.powerLimit = message.data.powerLimit;
                    variables.powerReleaseTimer = message.data.powerReleaseTimer;
                    variables.race = message.data.race;
                    variables.releasedPower = message.data.releasedPower;
                    variables.releasingPower = message.data.releasingPower;
                    variables.selectedKiSlot = message.data.selectedKiSlot;
                    variables.shootingKiBlast = message.data.shootingKiBlast;
                    variables.showOverlay = message.data.showOverlay;
                    variables.skinColor1 = message.data.skinColor1;
                    variables.skinColor1ID = message.data.skinColor1ID;
                    variables.skinColor2 = message.data.skinColor2;
                    variables.skinColor2ID = message.data.skinColor2ID;
                    variables.skinColor3 = message.data.skinColor3;
                    variables.skinColor3ID = message.data.skinColor3ID;
                    variables.skinColor4 = message.data.skinColor4;
                    variables.skinColor4ID = message.data.skinColor4ID;
                    variables.speed = message.data.speed;
                    variables.superSaiyanLevel = message.data.superSaiyanLevel;
                    variables.superSaiyan2Level = message.data.superSaiyan2Level;
                    variables.superSaiyan3Level = message.data.superSaiyan3Level;
                    variables.superSaiyanGodLevel = message.data.superSaiyanGodLevel;
                    variables.superSaiyanBlueLevel = message.data.superSaiyanBlueLevel;
                    variables.stamina = message.data.stamina;
                    variables.isStaminaPaused = message.data.isStaminaPaused;
                    variables.staminaRegen = message.data.staminaRegen;
                    variables.staminaTimer = message.data.staminaTimer;
                    variables.strength = message.data.strength;
                    variables.subForm = message.data.subForm;
                    variables.subFormBoost = message.data.subFormBoost;
                    variables.hasSuperSaiyan = message.data.hasSuperSaiyan;
                    variables.timePunch = message.data.timePunch;
                    variables.totalFormBoost = message.data.totalFormBoost;
                    variables.statusPoints = message.data.statusPoints;
                    variables.isTransforming = message.data.isTransforming;
                    variables.inTurboMode = message.data.inTurboMode;
                    variables.zenkaiBoostLevel = message.data.zenkaiBoostLevel;
                    variables.callAura = message.data.callAura;
                    variables.auraType = message.data.auraType;
                    variables.superAuraTexture = message.data.superAuraTexture;
                    variables.ultimateAuraTexture = message.data.ultimateAuraTexture;
                    variables.hasTail = message.data.hasTail;
                    variables.kiDrainTimer = message.data.kiDrainTimer;
                    variables.healthDrainTimer = message.data.healthDrainTimer;
                    variables.flyingSpeed = message.data.flyingSpeed;
                    variables.kiBlastTimer = message.data.kiBlastTimer;
                    variables.auraTimer = message.data.auraTimer;
                    variables.isFighting = message.data.isFighting;
                    variables.fightingTimer = message.data.fightingTimer;
                    variables.fullPowerLevel = message.data.fullPowerLevel;
                    variables.superNamekian = message.data.superNamekian;
                    variables.orangeNamekian = message.data.orangeNamekian;
                    variables.powerUnleashedLevel = message.data.powerUnleashedLevel;
                    variables.rageLevel = message.data.rageLevel;
                    variables.humanBuff = message.data.humanBuff;
                    variables.infiniteKiLevel = message.data.infiniteKiLevel;
                    variables.kiAbsorption = message.data.kiAbsorption;
                    variables.raceAbilityCooldown = message.data.raceAbilityCooldown;
                    variables.raceAbilityInCooldown = message.data.raceAbilityInCooldown;
                    variables.flyingLevel = message.data.flyingLevel;
                    variables.skillPath = message.data.skillPath;
                    variables.jumpLevel = message.data.jumpLevel;
                    variables.potentialReleaseLevel = message.data.potentialReleaseLevel;
                    variables.coolerFaceID = message.data.coolerFaceID;
                    variables.firstFormLevel = message.data.firstFormLevel;
                    variables.finalFormLevel = message.data.finalFormLevel;
                    variables.goldenLevel = message.data.goldenLevel;
                    variables.blackLevel = message.data.blackLevel;
                    variables.turboDrainTimer = message.data.turboDrainTimer;
                    variables.allocations = message.data.allocations;
                    variables.senzuBeanTimer = message.data.senzuBeanTimer;
                    variables.senzuBeanInTimer = message.data.senzuBeanInTimer;
                    variables.endurance = message.data.endurance;
                    variables.maxEndurance = message.data.maxEndurance;
                    variables.enduranceRegenTimer = message.data.enduranceRegenTimer;
                    variables.formBoostDrainImpact = message.data.formBoostDrainImpact;
                    variables.weights = message.data.weights;
                    variables.weightSize = message.data.weightSize;
                    variables.jumpTimer = message.data.jumpTimer;
                    variables.isChargingAttack = message.data.isChargingAttack;
                    variables.attackCharge = message.data.attackCharge;
                    variables.attackKiCost = message.data.attackKiCost;
                    variables.attackDamage = message.data.attackDamage;
                    variables.jumpTimer2 = message.data.jumpTimer2;
                    variables.rightMouseClicked = message.data.rightMouseClicked;
                    variables.currentAttack = message.data.currentAttack;
                    variables.attackChargeTimer = message.data.attackChargeTimer;
                    variables.UILevel = message.data.UILevel;
                    variables.dodgeChance = message.data.dodgeChance;
                    variables.dodging = message.data.dodging;
                    variables.attackType = message.data.attackType;
                    variables.lockedEntity = message.data.lockedEntity;
                    variables.playerLocking = message.data.playerLocking;
                    variables.actualSpeed = message.data.actualSpeed;
                    variables.weightAmount = message.data.weightAmount;
                    variables.environmentalWeight = message.data.environmentalWeight;
                    variables.selectedKiAttack = message.data.selectedKiAttack;
                    variables.tempSlot = message.data.tempSlot;
                    variables.climbingKorinTower = message.data.climbingKorinTower;
                    variables.dodgeTimer = message.data.dodgeTimer;
                    variables.cLevel = message.data.cLevel;
                    variables.xp = message.data.xp;
                    variables.maxXP = message.data.maxXP;
                    variables.healingWaterTimer = message.data.healingWaterTimer;
                    variables.xpIncrease = message.data.xpIncrease;
                    variables.lockSet = message.data.lockSet;
                    variables.frostDemonExtraSkin = message.data.frostDemonExtraSkin;
                    variables.kiWaveTimer = message.data.kiWaveTimer;
                    variables.kiWave = message.data.kiWave;
                    variables.lightningAura = message.data.lightningAura;
                    variables.mysticLevel = message.data.mysticLevel;
                    variables.none = message.data.none;
                    variables.superSayainRageLevel = message.data.superSayainRageLevel;
                    variables.beastLevel = message.data.beastLevel;
                    variables.topID = message.data.topID;
                    variables.tShirtID = message.data.tShirtID;
                    variables.pantsID = message.data.pantsID;
                    variables.bootsID = message.data.bootsID;
                    variables.wristbandsID = message.data.wristbandsID;
                    variables.beltID = message.data.beltID;
                    variables.weightID = message.data.weightID;
                    variables.scouterID = message.data.scouterID;
                    variables.topSlot0 = message.data.topSlot0;
                    variables.tShirtSlot1 = message.data.tShirtSlot1;
                    variables.pantsSlot2 = message.data.pantsSlot2;
                    variables.bootsSlot3 = message.data.bootsSlot3;
                    variables.wristbandSlot4 = message.data.wristbandSlot4;
                    variables.beltSlot5 = message.data.beltSlot5;
                    variables.weightSlot6 = message.data.weightSlot6;
                    variables.scouterSlot7 = message.data.scouterSlot7;
                }
            });
            context.setPacketHandled(true);
        }
    }
}
