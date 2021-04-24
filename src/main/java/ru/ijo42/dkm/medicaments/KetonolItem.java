package ru.ijo42.dkm.medicaments;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.ObjectRegistry;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class KetonolItem extends MedicamentBaseItem {

    public KetonolItem() {
        super(new KetonolSpecs());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (!worldIn.isRemote) {
            PotionApplier.applyPotion(player, ObjectRegistry.ANESTHETIC, 200, false);
            PotionApplier.applyPotion(player, MobEffects.HUNGER, 9, 1);
        }
    }

    static class KetonolSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 2;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "ketonol";
        }

    }

}
