package ru.ijo42.dkm.effects.positive;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import ru.ijo42.dkm.Medicine;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class AnestheticEffect extends Potion {

    public AnestheticEffect() {
        super(false, 16284963);
        this.setPotionName("effect.anesthetic")
                .setBeneficial()
                .setRegistryName(Medicine.getResourceLocation("anesthetic").toString());
    }

    @Nonnull
    public List<ItemStack> getCurativeItems() {
        return Collections.emptyList();
    }

}
