package ru.ijo42.dkm;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class DamageListener {

    @SubscribeEvent
    public static void onDead(LivingDeathEvent ev) {
        if (ev.getEntityLiving() instanceof EntityPlayerMP) {
            final PotionSaveEffect potionSave = new PotionSaveEffect(
                    ev.getEntityLiving()
                            .getActivePotionEffects()
            );
            if (!potionSave.isEmpty()) {
                potionSaveMapHolder.potionSaveMap.put(
                        ((EntityPlayerMP) ev.getEntityLiving()).getGameProfile().getId(),
                        potionSave
                );
            }
        }
    }

    @SubscribeEvent
    public static void onRespawn(LivingSpawnEvent ev) {
        if (ev.getEntityLiving() instanceof EntityPlayerMP) {
            final UUID uuid = ((EntityPlayerMP) ev.getEntityLiving()).getGameProfile().getId();
            if (potionSaveMapHolder.potionSaveMap.containsKey(uuid)) {
                applyPotion(ev.getEntityLiving(), potionSaveMapHolder.potionSaveMap.get(uuid));
            }
        }
    }

    @SubscribeEvent
    public static void onDamage(LivingHurtEvent ev) {
        final EntityLivingBase entityLiving = ev.getEntityLiving();
        if (entityLiving instanceof EntityPlayerMP) {

            if (ev.getAmount() > 2.0F) {

                applyPotion(entityLiving, ObjectRegistry.BLEEDING, 180, 15);

                applyPotion(entityLiving, ObjectRegistry.HEAVY_BLEEDING, 200, 7);

                applyPotion(entityLiving, ObjectRegistry.FRACTURE_ARM, 900, 15);

                applyPotion(entityLiving, ObjectRegistry.FRACTURE_LEG, 1500, 15);

                if (!entityLiving.isPotionActive(ObjectRegistry.ANESTHETIC)) {
                    applyPotion(entityLiving, ObjectRegistry.PAIN, 60, 30);
                }

                applyPotion(entityLiving, ObjectRegistry.CONTUSION, 3, 7);

            }
        }
    }

    @SubscribeEvent
    public static void onFall(LivingHurtEvent ev) {
        if (ev.getEntityLiving() instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) ev.getEntityLiving();

            if (ev.getSource() == DamageSource.FALL) {
                if (ev.getAmount() >= 3.0F) {
                    applyPotion(player, ObjectRegistry.FRACTURE_LEG, 1500, 40);
                }
            }
        }
    }

    /**
     * @param player  applicable player
     * @param potion  applicable potion
     * @param seconds duration of effects
     * @param chance  integer chance value of applicable potion (100% = 100)
     */
    private static void applyPotion(EntityLivingBase player, Potion potion, int seconds, int chance) {
        if (Math.random() < chance / 100.0D) {
            player.addPotionEffect(new PotionEffect(potion, seconds * Constants.TICK_IN_SECONDS, 1, false, false));
        }
    }

    private static void applyPotion(EntityLivingBase player, PotionSaveEffect potionMap) {
        if (!potionMap.isEmpty()) {
            potionMap.forEach(player::addPotionEffect);
        }
    }

    private static final class potionSaveMapHolder {

        static final Map<UUID, PotionSaveEffect> potionSaveMap = new HashMap<>();

    }

    public static class PotionSaveEffect extends LinkedList<PotionEffect> {

        public PotionSaveEffect(Collection<PotionEffect> potions) {
            for (PotionEffect potion : potions) {
                if (potion.getPotion() == ObjectRegistry.PAIN) {
                    this.add(potion);
                } else if (potion.getPotion() == ObjectRegistry.FRACTURE_LEG) {
                    this.add(potion);
                } else if (potion.getPotion() == ObjectRegistry.FRACTURE_ARM) {
                    this.add(potion);
                }
            }
        }

    }

}
