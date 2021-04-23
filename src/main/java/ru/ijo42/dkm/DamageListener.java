package ru.ijo42.dkm;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

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
    public static void onRespawn(PlayerEvent.PlayerRespawnEvent ev) {
        final UUID uuid = ev.player.getGameProfile().getId();
        if (potionSaveMapHolder.potionSaveMap.containsKey(uuid)) {
            applyPotion(ev.player, potionSaveMapHolder.potionSaveMap.get(uuid));
            potionSaveMapHolder.potionSaveMap.remove(uuid);
        }
    }

    @SubscribeEvent
    public static void onDamage(LivingHurtEvent ev) {
        final EntityLivingBase player = ev.getEntityLiving();
        if (player instanceof EntityPlayerMP && ev.getSource() != DamageSource.OUT_OF_WORLD) {

            if (ev.getAmount() > 2.0F) {

                applyPotion(player, ObjectRegistry.BLEEDING, 180, 25);

                applyPotion(player, ObjectRegistry.HEAVY_BLEEDING, 200, 7);

                if (ev.getSource() != DamageSource.FALL && !player.isPotionActive(ObjectRegistry.FRACTURE_LEG)) {
                    applyPotion(player, ObjectRegistry.FRACTURE_ARM, 1500, 15);
                }

                if (!player.isPotionActive(ObjectRegistry.FRACTURE_ARM)) {
                    applyPotion(player, ObjectRegistry.FRACTURE_LEG, 1500, 15);
                }

                if (!player.isPotionActive(ObjectRegistry.ANESTHETIC)) {
                    applyPotion(player, ObjectRegistry.PAIN, 60, 30);
                }

                applyPotion(player, ObjectRegistry.CONTUSION, 1, 3);

            }

            if (ev.getSource() == DamageSource.FALL && ev.getAmount() >= 6.0F) {
                applyPotion(player, ObjectRegistry.FRACTURE_LEG, 1500, 60);
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
            player.addPotionEffect(new PotionEffect(potion, seconds * Constants.TICK_IN_SECONDS, 0, false, false));
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
