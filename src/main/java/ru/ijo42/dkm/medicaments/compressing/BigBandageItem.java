package ru.ijo42.dkm.medicaments.compressing;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class BigBandageItem extends MedicamentBaseItem {

    public BigBandageItem() {
        super(new BigBandageSpecs());
    }

    static class BigBandageSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                //TODO: снимать легкое кровотечение
            };
        }

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 2;
        }

        @Nonnull
        @Override
        public String getName() {
            return "bigbandage";
        }

    }

}
