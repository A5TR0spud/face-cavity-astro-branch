package io.github.facecavity.registration;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.tigereye.chestcavity.ChestCavity;

public class FCFoodComponents {
    public static final FoodComponent HUMAN_BRAIN_FOOD_COMPONENT;
    static {
        HUMAN_BRAIN_FOOD_COMPONENT = (new FoodComponent.Builder()).hunger(3).saturationModifier(0.5F).meat().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 24000, 1), ChestCavity.config.RISK_OF_PRIONS).statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 24000, 1), ChestCavity.config.RISK_OF_PRIONS).statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 24000, 1), ChestCavity.config.RISK_OF_PRIONS).build();
    }
}
