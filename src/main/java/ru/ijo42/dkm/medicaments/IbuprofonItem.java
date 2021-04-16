package ru.ijo42.dkm.medicaments;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class IbuprofonItem extends MedicamentBaseItem {

    public IbuprofonItem() {
        super(new IbuprofonSpecs());
    }

    static class IbuprofonSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                //TODO: снимать `боль`
                //TODO: накладывать эффект `под обезболивающим` (90с)
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 5 * Constants.TICK_IN_SECONDS, 2));
            };
        }

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
