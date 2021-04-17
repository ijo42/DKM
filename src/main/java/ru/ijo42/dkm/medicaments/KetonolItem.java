package ru.ijo42.dkm.medicaments;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.Constants;
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
    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            //TODO: снимать `боль`
            player.addPotionEffect(new PotionEffect(ObjectRegistry.Anesthetic, 200 * Constants.TICK_IN_SECONDS));
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 9 * Constants.TICK_IN_SECONDS, 2));
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
