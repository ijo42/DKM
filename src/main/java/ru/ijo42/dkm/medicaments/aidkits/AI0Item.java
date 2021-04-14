package ru.ijo42.dkm.medicaments.aidkits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.EffectConsumer;

import javax.annotation.Nonnull;

public class AI0Item extends MedicamentBaseItem {

    public AI0Item() {
        super(new AI0Specs());
    }

    static class AI0Specs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> entityLivingBase.heal(3);
        }

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 3;
        }

        @Nonnull
        @Override
        public String getName() {
            return "ai0";
        }

    }

}
