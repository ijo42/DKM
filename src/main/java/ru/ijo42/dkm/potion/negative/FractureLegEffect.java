package ru.ijo42.dkm.potion.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import ru.ijo42.dkm.ObjectRegistry;
import ru.ijo42.dkm.base.PotionApplier;
import ru.ijo42.dkm.potion.PotionBase;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class FractureLegEffect extends PotionBase {

    public FractureLegEffect() {
        super(true, "fractureleg");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        PotionApplier.applyPotion(entityLivingBaseIn, MobEffects.SLOWNESS, 10, 1);
    }

    @Nonnull
    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ObjectRegistry.SPLINT));
        ret.add(new ItemStack(ObjectRegistry.MATEROE));
        ret.add(new ItemStack(ObjectRegistry.SFV));
        return ret;
    }

}
