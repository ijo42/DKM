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

public class PainEffect extends PotionBase {

    public PainEffect() {
        super(true, "pain");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        PotionApplier.applyPotion(entityLivingBaseIn, MobEffects.MINING_FATIGUE, 10, 1);
    }

    @Nonnull
    @Override
    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<>();
        ret.add(new ItemStack(ObjectRegistry.IBUPROFON));
        ret.add(new ItemStack(ObjectRegistry.KETONOL));
        ret.add(new ItemStack(ObjectRegistry.NIBUROXYDASE));
        ret.add(new ItemStack(ObjectRegistry.SFV));
        return ret;
    }

}
