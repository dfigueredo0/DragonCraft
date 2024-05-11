package com.elysiumgames.dragoncraft.world.entity.monster.saibamen;

import com.mojang.serialization.Codec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum Variant implements StringRepresentable {
    DEFAULT(0, "saibamen"), // Spawn Egg for colors, White Claws
    KYUKONMAN(1, "kyukonman"), // Yellow Skin, Orange "Armor", White Claws
    TENNENMAN(2, "tennenman"), // Pink Skin, Blue "Armor", Yellow Claws
    JINKOUMAN(3, "jinkouman"), // Light Gray Skin, Dark Gray "Armor", White Claws
    KAIWAREMAN(4, "kaiwareman"), // Light Blue Skin, Dark Blue "Armor", White Claws
    COPYMAN(5, "copyman") // Black, White Claws
    ;

    public static final Codec<Variant> CODEC = StringRepresentable.fromEnum(Variant::values);
    private static final IntFunction<Variant> BY_ID = ByIdMap.continuous(Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.WRAP);
    private final int id;
    private final String name;

    Variant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public static Variant byId(int id) {
        return BY_ID.apply(id);
    }

    public String getSerializedName() {
        return this.name;
    }
}