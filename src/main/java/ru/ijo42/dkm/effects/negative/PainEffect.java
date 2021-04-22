package ru.ijo42.dkm.effects.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import ru.ijo42.dkm.Medicine;
import ru.ijo42.dkm.ObjectRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class PainEffect extends Potion {

    public PainEffect() {
        super(true, 16284963);
        this.setPotionName("effect.pain")
                .setRegistryName(Medicine.getResourceLocation("pain").toString());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 10,1));
    }

    @Override
    @Nonnull
    public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

}
