package ru.ijo42.dkm.medicaments.aidkits;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.TripleConsumer;

import javax.annotation.Nonnull;

public class Fast91Item extends MedicamentBaseItem {

    public Fast91Item() {
        super(new Fast91Specs());
    }

    static class Fast91Specs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public ImmutableList<TripleConsumer<ItemStack, World, EntityLivingBase>> getRelatedEffects() {
            return ImmutableList.of((itemStack, world, entityLivingBase) -> {
                //TODO: снимать легкое кровотечение
                entityLivingBase.heal(4);
            });
        }

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 4;
        }

        @Nonnull
        @Override
        public String getName() {
            return "fast91";
        }

    }

}
