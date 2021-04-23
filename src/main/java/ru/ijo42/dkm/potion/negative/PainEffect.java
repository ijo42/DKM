package ru.ijo42.dkm.potion.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import ru.ijo42.dkm.Medicine;
import ru.ijo42.dkm.potion.PotionBase;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class PainEffect extends PotionBase {

    public PainEffect() {
        super(true, "pain");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 10,1));
    }

}
