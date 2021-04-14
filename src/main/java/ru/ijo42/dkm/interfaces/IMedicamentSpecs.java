package ru.ijo42.dkm.interfaces;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public interface IMedicamentSpecs {

    @Nonnull
    ImmutableList<TripleConsumer<ItemStack, World, EntityLivingBase>> getRelatedEffects();

    /**
     * TODO: implement
     */
    default SoundEvent getSoundEvents() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    /**
     * @return number of seconds required to use
     *         TODO: implement
     */
    int getUsageTime();

    default int getMaxStackSize() {
        return 1;
    }

    /**
     * @return number of uses of this medicament -1
     */
    int getMaxDamage();

    default ITextComponent getDescription() {
        return new TextComponentTranslation("item." + getName() + ".desc");
    }

    @Nonnull
    String getName();

}
