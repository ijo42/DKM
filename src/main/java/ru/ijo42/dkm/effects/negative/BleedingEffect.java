package ru.ijo42.dkm.effects.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.Medicine;

import javax.annotation.ParametersAreNonnullByDefault;

public class BleedingEffect extends Potion {

    public BleedingEffect() {
        super(true, 16284963);
        this.setPotionName("effect.bleeding")
                .setRegistryName(Medicine.getResourceLocation("bleeding").toString());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int k = 20 * Constants.TICK_IN_SECONDS >> amplifier;

        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
