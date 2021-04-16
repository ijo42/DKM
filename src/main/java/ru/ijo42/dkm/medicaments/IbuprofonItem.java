package ru.ijo42.dkm.medicaments;

import mcp.MethodsReturnNonnullByDefault;
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

public class IbuprofonItem extends MedicamentBaseItem {

    public IbuprofonItem() {
        super(new IbuprofonSpecs());
    }

    @Override
    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            //TODO: снимать `боль`
            //TODO: накладывать эффект `под обезболивающим` (90с)
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 5 * Constants.TICK_IN_SECONDS, 2));
        }
    }

    static class IbuprofonSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 2;
        }

        @Override
        public int getMaxDamage() {
            return 4;
        }

        @Nonnull
        @Override
        public String getName() {
            return "ibuprofon";
        }

    }

}
