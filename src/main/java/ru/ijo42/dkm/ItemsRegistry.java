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
import ru.ijo42.dkm.medicaments.BandageItem;
import ru.ijo42.dkm.medicaments.BigBandageItem;
import ru.ijo42.dkm.medicaments.HarnessItem;
import ru.ijo42.dkm.medicaments.Splint;
import ru.ijo42.dkm.medicaments.StaffoeItem;
import ru.ijo42.dkm.medicaments.aidkits.AI0Item;
import ru.ijo42.dkm.medicaments.aidkits.DMItem;
import ru.ijo42.dkm.medicaments.aidkits.Fast91Item;
import ru.ijo42.dkm.medicaments.aidkits.SFVItem;

import java.util.Arrays;

@GameRegistry.ObjectHolder(Medicine.MOD_ID)
@Mod.EventBusSubscriber
public class ItemsRegistry {

    @GameRegistry.ObjectHolder("ai0")
    public static final MedicamentBaseItem AI0 = new AI0Item();

    @GameRegistry.ObjectHolder("fast91")
    public static final MedicamentBaseItem Fast91 = new Fast91Item();

    @GameRegistry.ObjectHolder("dm")
    public static final MedicamentBaseItem DM = new DMItem();

    @GameRegistry.ObjectHolder("sfv")
    public static final MedicamentBaseItem SFV = new SFVItem();

    @GameRegistry.ObjectHolder("bandage")
    public static final MedicamentBaseItem Bandage = new BandageItem();

    @GameRegistry.ObjectHolder("bigbandage")
    public static final MedicamentBaseItem BigBandage = new BigBandageItem();

    @GameRegistry.ObjectHolder("harness")
    public static final MedicamentBaseItem Harness = new HarnessItem();

    @GameRegistry.ObjectHolder("staffoe")
    public static final MedicamentBaseItem Staffoe = new StaffoeItem();

    @GameRegistry.ObjectHolder("splint")
    public static final MedicamentBaseItem Splint = new Splint();

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(AI0, Fast91, DM, SFV, Bandage, BigBandage, Harness, Staffoe, Splint);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        for (MedicamentBaseItem medicamentBaseItem : Arrays.asList(
                AI0, Fast91, DM, SFV, Bandage, BigBandage, Harness, Staffoe, Splint
        )) {
            medicamentBaseItem.initModel();
        }
    }

}
