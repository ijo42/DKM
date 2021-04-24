package ru.ijo42.dkm.base;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import ru.ijo42.dkm.Constants;

public class PotionApplier {

    public static void applyPotion(EntityLivingBase player, Potion potion, int duration) {
        applyPotion(player, potion, duration, 0);
    }

    public static void applyPotion(EntityLivingBase player, Potion potion, int duration, boolean isAmbient) {
        applyPotion(player, potion, duration, 0, isAmbient);
    }

    public static void applyPotion(EntityLivingBase player, Potion potion, int duration, int amplifier) {
        applyPotion(player, potion, duration, amplifier, true);
    }

    public static void applyPotion(EntityLivingBase player, Potion potion, int duration, int amplifier, boolean isAmbient) {
        player.addPotionEffect(new PotionEffect(potion,
                duration * Constants.TICK_IN_SECONDS, amplifier, isAmbient, isAmbient
        ));
    }

}
