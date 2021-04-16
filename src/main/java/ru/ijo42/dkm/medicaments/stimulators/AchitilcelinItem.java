package ru.ijo42.dkm.medicaments.stimulators;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AchitilcelinItem extends MedicamentBaseItem {

    public AchitilcelinItem() {
        super(new AchitilcelinSpecs());
    }

    static class AchitilcelinSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 50 * Constants.TICK_IN_SECONDS));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 50 * Constants.TICK_IN_SECONDS));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 200 * Constants.TICK_IN_SECONDS));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10 * Constants.TICK_IN_SECONDS));
                new Timer(this + " Thread").schedule(new TimerTask() {
                    @Override
                    public void run() {
                        entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20 * Constants.TICK_IN_SECONDS));
                    }
                }, TimeUnit.SECONDS.toMillis(120));
            };
        }

        @Override
        public int getUsageTime() {
            return 1;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "achitilcelin";
        }

    }

}
