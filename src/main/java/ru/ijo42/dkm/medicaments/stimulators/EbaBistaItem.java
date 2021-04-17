package ru.ijo42.dkm.medicaments.stimulators;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class EbaBistaItem extends MedicamentBaseItem {

    public EbaBistaItem() {
        super(new EbaBistaSpecs());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 60 * Constants.TICK_IN_SECONDS, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80 * Constants.TICK_IN_SECONDS));
        }
    }

    static class EbaBistaSpecs implements IMedicamentSpecs {

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
            return "ebabista";
        }

    }

}
