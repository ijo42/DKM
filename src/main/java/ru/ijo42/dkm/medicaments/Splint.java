package ru.ijo42.dkm.medicaments;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.TripleConsumer;

import javax.annotation.Nonnull;

public class Splint extends MedicamentBaseItem {

    public Splint() {
        super(new SplintSpecs());
    }

    static class SplintSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public ImmutableList<TripleConsumer<ItemStack, World, EntityLivingBase>> getRelatedEffects() {
            return ImmutableList.of((itemStack, world, entityLivingBase) -> {
               //TODO: снимать переломы
            });
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
            return "splint";
        }

    }

}
