package com.elysiumgames.dragoncraft.utils;

import com.google.gson.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Constants {
    public static final String MOD_NAME = "DragonCraft";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().registerTypeAdapter(Double.class, new DoubleJsonSerializer()).create();
    public static final DecimalFormat FORMAT = new DecimalFormat("#.##");

    private static final class DoubleJsonSerializer implements JsonSerializer<Double> {
        @Override
        public JsonElement serialize(final Double src, final Type typeOfSrc, final JsonSerializationContext context) {

            if (src.isInfinite() || src.isNaN()) {

                return new JsonPrimitive(src);
            }

            BigDecimal value = BigDecimal.valueOf(src);

            try {
                value = new BigDecimal(value.toBigIntegerExact());
            }

            catch (ArithmeticException e) {
                // NO-OP
            }

            return new JsonPrimitive(value);
        }
    }

    public enum Race {
        HUMAN("Human"),
        SAIYAN("Saiyan"),
        HALF_SAIYAN("Half_Saiyan"),
        FROST_DEMON("Frost_Demon"),
        NAMEKIAN("Namekian"),
        MAJIN("Majin")
        ;

        private final String race;

        Race(String race) {
            this.race = race;
        }

        public String getRace() {
            return race;
        }
    }

}
