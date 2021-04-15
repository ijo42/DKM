package ru.ijo42.dkm.medicaments.stimulators;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.interfaces.EffectConsumer;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;

public class NiburoxydaseItem extends MedicamentBaseItem {

    public NiburoxydaseItem() {
        super(new NiburoxydaseSpecs());
    }

    static class NiburoxydaseSpecs implements IMedicamentSpecs {

        @Nonnull
        @Override
        public EffectConsumer<ItemStack, World, EntityLivingBase> getRelatedEffects() {
            return (itemStack, world, entityLivingBase) -> {
                //TODO: снимать `боль`
                //TODO: накладывать эффект `под обезболивающим` (200с)
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 20));
                entityLivingBase.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10));
                //TODO: накладывать эффект `истощение II` (20c)
            };
        }

        @Override
        public int getUsageTime() {
            return 1;
        }

        @Override
        public int getMaxDamage() {
            return 1;
        }

        @Nonnull
        @Override
        public String getName() {
            return "niburoxydase";
        }

    }

}
