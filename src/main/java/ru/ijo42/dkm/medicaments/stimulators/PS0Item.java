package ru.ijo42.dkm.medicaments.stimulators;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import java.util.Timer;
import java.util.TimerTask;

public class PS0Item extends MedicamentBaseItem {

    public PS0Item() {
        super(new PS0Specs());
    }

    static class PS0Specs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                //TODO: накладывать эффект `под обезболивающим` (200с)
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 50));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HASTE, 50));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 100));
                new Timer(this + " Thread").schedule(new TimerTask() {
                    @Override
                    public void run() {
                        entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20));
                    }
                }, 300);
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
            return "ps0";
        }

    }

}
