package ru.ijo42.dkm.medicaments.compressing;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class HarnessItem extends MedicamentBaseItem {

    public HarnessItem() {
        super(new HarnessSpecs());
    }

    @Override
    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            //TODO: снимать тяжелое кровотечение
        }
    }

    static class HarnessSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "harness";
        }

    }

}
