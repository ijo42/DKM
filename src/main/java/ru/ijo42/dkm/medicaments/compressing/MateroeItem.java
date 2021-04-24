package ru.ijo42.dkm.medicaments.compressing;

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
