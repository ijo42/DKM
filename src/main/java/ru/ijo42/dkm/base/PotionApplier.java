package ru.ijo42.dkm.base;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import ru.ijo42.dkm.Constants;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class PotionApplier {

    public static void applyPotion(EntityLivingBase player, Potion potion, int duration, int amplifier) {
        applyPotion(player, potion, duration, amplifier, false);
    }

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

    public static void applyPotionDelayed(EntityLivingBase player, Potion potion, int duration, int delaySeconds) {
        applyPotionDelayed(player, potion, duration, 0, delaySeconds);
    }

    public static void applyPotionDelayed(EntityLivingBase player, Potion potion, int duration, int amplifier, int delaySeconds) {
        applyPotionDelayed(player, potion, duration, amplifier, false, delaySeconds);
    }

    public static void applyPotionDelayed(
            EntityLivingBase player,
            Potion potion,
            int duration,
            boolean isAmbient,
            int delaySeconds
    ) {
        applyPotionDelayed(player, potion, duration, 0, isAmbient, delaySeconds);
    }

    public static void applyPotionDelayed(
            EntityLivingBase player, Potion potion, int duration, int amplifier,
            boolean isAmbient, int delaySeconds
    ) {
        TimerHolder.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.addPotionEffect(new PotionEffect(potion,
                        duration * Constants.TICK_IN_SECONDS, amplifier, isAmbient, isAmbient
                ));
            }
        }, TimeUnit.SECONDS.toMillis(delaySeconds));

    }

    private final static class TimerHolder {

        private final static Timer timer = new Timer();

    }

}
