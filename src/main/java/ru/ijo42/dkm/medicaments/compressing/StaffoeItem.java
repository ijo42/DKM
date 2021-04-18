package ru.ijo42.dkm.medicaments.compressing;

import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class StaffoeItem extends MedicamentBaseItem {

    public StaffoeItem() {
        super(new StaffoeSpecs());
    }

    static class StaffoeSpecs implements IMedicamentSpecs {

        @Override
        public int getUsageTime() {
            return 2;
        }

        @Override
        public int getMaxDamage() {
            return 2;
        }

        @Nonnull
        @Override
        public String getName() {
            return "staffoe";
        }

    }

}
