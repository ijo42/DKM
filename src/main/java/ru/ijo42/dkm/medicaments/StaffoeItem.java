package ru.ijo42.dkm.medicaments;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.TripleConsumer;

import javax.annotation.Nonnull;

public class StaffoeItem extends MedicamentBaseItem {

    public StaffoeItem() {
        super(new StaffoeSpecs());
    }

    static class StaffoeSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public ImmutableList<TripleConsumer<ItemStack, World, EntityLivingBase>> getRelatedEffects() {
            return ImmutableList.of((itemStack, world, entityLivingBase) -> {
               //TODO: снимать тяжелое кровотечение
            });
        }

        @Override
        public int getUsageTime() {
            return 2;
        }

        @Override
        public int getMaxDamage() {
            return 2;
        }

        @Nonnull
        @Override
        public String getName() {
            return "staffoe";
        }

    }

}
