package ru.ijo42.dkm.medicaments.aidkits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class DMItem extends MedicamentBaseItem {

    public DMItem() {
        super(new DMSpecs());
    }

    static class DMSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                //TODO: снимать легкое и тяжелое кровотечение
                entityLivingBase.heal(6);
            };
        }

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 5;
        }

        @Nonnull
        @Override
        public String getName() {
            return "dm";
        }

    }

}
