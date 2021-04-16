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

public class EbaBistaItem extends MedicamentBaseItem {

    public EbaBistaItem() {
        super(new EbaBistaSpecs());
    }

    static class EbaBistaSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.SPEED, 60 * Constants.TICK_IN_SECONDS, 2));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80 * Constants.TICK_IN_SECONDS));
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
            return "ebabista";
        }

    }

}
