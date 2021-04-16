package ru.ijo42.dkm.medicaments.compressing;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class MateroeItem extends MedicamentBaseItem {

    public MateroeItem() {
        super(new MateroeSpecs());
    }

    @Override
    @MethodsReturnNonnullByDefault
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            //TODO: снимать переломы
        }
    }

    static class MateroeSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 3;
        }

        @Override
        public int getMaxDamage() {
            return 4;
        }

        @Nonnull
        @Override
        public String getName() {
            return "materoe";
        }

    }

}
