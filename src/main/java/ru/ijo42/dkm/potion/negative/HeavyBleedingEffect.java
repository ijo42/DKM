package ru.ijo42.dkm.potion.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.ObjectRegistry;
import ru.ijo42.dkm.potion.PotionBase;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class HeavyBleedingEffect extends PotionBase {

    public HeavyBleedingEffect() {
        super(true, "heavybleeding");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 2.0F);
    }

    @Override
    @Nonnull
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ObjectRegistry.SPLINT));
        ret.add(new ItemStack(ObjectRegistry.STAFFOE));
        ret.add(new ItemStack(ObjectRegistry.HARNESS));
        ret.add(new ItemStack(ObjectRegistry.DM));
        ret.add(new ItemStack(ObjectRegistry.SFV));
        return ret;
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
