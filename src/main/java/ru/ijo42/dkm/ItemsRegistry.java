package ru.ijo42.dkm;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.medicaments.AI0Item;

import java.util.Arrays;

@GameRegistry.ObjectHolder(Medicine.MOD_ID)
@Mod.EventBusSubscriber
public class ItemsRegistry {

    @GameRegistry.ObjectHolder("ai0")
    public static final MedicamentBaseItem AI0 = new AI0Item();

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(AI0);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        for (MedicamentBaseItem medicamentBaseItem : Arrays.asList(
                AI0
        )) {
            medicamentBaseItem.initModel();
        }
    }

}
