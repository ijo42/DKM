package ru.ijo42.dkm.medicaments.aidkits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class SFVItem extends MedicamentBaseItem {

    public SFVItem() {
        super(new SFVSpecs());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void onFoodEaten(final ItemStack stack, final World worldIn, final EntityPlayer player) {
        if (!worldIn.isRemote) {
            //TODO: снимать легкое и тяжелое кровотечение
            player.heal(8);
        }
    }

    static class SFVSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 4;
        }

        @Override
        public int getMaxDamage() {
            return 7;
        }

        @Nonnull
        @Override
        public String getName() {
            return "sfv";
        }

    }

}
