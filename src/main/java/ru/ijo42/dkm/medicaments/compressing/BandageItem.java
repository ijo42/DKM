package ru.ijo42.dkm.medicaments.compressing;

import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class BandageItem extends MedicamentBaseItem {

    public BandageItem() {
        super(new BandageSpecs());
    }

    static class BandageSpecs implements IMedicamentSpecs {

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
            return "bandage";
        }

    }

}
