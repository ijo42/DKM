package ru.ijo42.dkm.effects.negative;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.Medicine;
import ru.ijo42.dkm.ObjectRegistry;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

public class FractureArmEffect extends Potion {

    public FractureArmEffect() {
        super(true, 16284963);
        this.setPotionName("effect.fracturearm")
                .setRegistryName(Medicine.getResourceLocation("fracturearm").toString());
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 10,2));
    }

    @Override
    @Nonnull
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ObjectRegistry.SPLINT));
        ret.add(new ItemStack(ObjectRegistry.MATEROE));
        ret.add(new ItemStack(ObjectRegistry.SFV));
        return ret;
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

}
