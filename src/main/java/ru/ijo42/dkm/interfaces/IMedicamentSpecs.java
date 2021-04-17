package ru.ijo42.dkm.interfaces;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

@MethodsReturnNonnullByDefault
public interface IMedicamentSpecs {

    /**
     * TODO: implement
     */
    default SoundEvent getSoundEvents() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    int getUsageTime();

    default int getMaxStackSize() {
        return 1;
    }

    /**
     * @return number of uses of this medicament
     */
    int getMaxDamage();

    default ITextComponent getDescription() {
        return new TextComponentTranslation("item." + getName() + ".desc");
    }

    String getName();

}
