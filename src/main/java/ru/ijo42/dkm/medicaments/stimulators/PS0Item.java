package ru.ijo42.dkm.medicaments.stimulators;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.ObjectRegistry;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.base.PotionApplier;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class PS0Item extends MedicamentBaseItem {

    public PS0Item() {
        super(new PS0Specs());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (!worldIn.isRemote) {
            PotionApplier.applyPotion(player, ObjectRegistry.ANESTHETIC, 200);
            PotionApplier.applyPotion(player, MobEffects.STRENGTH, 50);
            PotionApplier.applyPotion(player, MobEffects.HASTE, 50);
            PotionApplier.applyPotion(player, MobEffects.HUNGER, 100);
            PotionApplier.applyPotionDelayed(player, MobEffects.NAUSEA, 20, 300);
        }
    }

    static class PS0Specs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 1;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "ps0";
        }

    }

}
