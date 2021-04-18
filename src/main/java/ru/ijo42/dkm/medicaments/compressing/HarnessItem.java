package ru.ijo42.dkm.medicaments.compressing;

import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class HarnessItem extends MedicamentBaseItem {

    public HarnessItem() {
        super(new HarnessSpecs());
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
