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

public class FractureLegEffect extends Potion {

    public FractureLegEffect() {
        super(true, 16284963);
        this.setPotionName("effect.fractureleg")
                .setRegistryName(Medicine.getResourceLocation("fractureleg").toString());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 10,2));
    }

    @Override
    @Nonnull
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ObjectRegistry.BANDAGE));
        ret.add(new ItemStack(ObjectRegistry.BIG_BANDAGE));
        ret.add(new ItemStack(ObjectRegistry.ACHITILCELIN));
        ret.add(new ItemStack(ObjectRegistry.EBA_BISTA));
        ret.add(new ItemStack(ObjectRegistry.N_91_B));
        ret.add(new ItemStack(ObjectRegistry.NIBUROXYDASE));
        ret.add(new ItemStack(ObjectRegistry.PS_0));
        ret.add(new ItemStack(ObjectRegistry.FAST_91));
        ret.add(new ItemStack(ObjectRegistry.DM));
        ret.add(new ItemStack(ObjectRegistry.SFV));
        return ret;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

}