package ru.ijo42.dkm.medicaments;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.EffectConsumer;

import javax.annotation.Nonnull;

public class HarnessItem extends MedicamentBaseItem {

    public HarnessItem() {
        super(new HarnessSpecs());
    }

    static class HarnessSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
               //TODO: снимать тяжелое кровотечение
            };
        }

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "harness";
        }

    }

}
