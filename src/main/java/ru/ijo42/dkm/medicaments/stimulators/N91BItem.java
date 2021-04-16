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

public class N91BItem extends MedicamentBaseItem {

    public N91BItem() {
        super(new N91BSpecs());
    }

    static class N91BSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.SPEED, 50 * Constants.TICK_IN_SECONDS, 2));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 20 * Constants.TICK_IN_SECONDS));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 65 * Constants.TICK_IN_SECONDS));
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
            return "91b";
        }

    }

}
