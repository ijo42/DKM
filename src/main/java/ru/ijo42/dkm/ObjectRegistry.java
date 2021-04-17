package ru.ijo42.dkm;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ijo42.dkm.base.MedicamentBaseItem;
import ru.ijo42.dkm.effects.negative.BleedingEffect;
import ru.ijo42.dkm.effects.negative.HeavyBleedingEffect;
import ru.ijo42.dkm.effects.positive.AnestheticEffect;
import ru.ijo42.dkm.medicaments.IbuprofonItem;
import ru.ijo42.dkm.medicaments.KetonolItem;
import ru.ijo42.dkm.medicaments.aidkits.AI0Item;
import ru.ijo42.dkm.medicaments.aidkits.DMItem;
import ru.ijo42.dkm.medicaments.aidkits.Fast91Item;
import ru.ijo42.dkm.medicaments.aidkits.SFVItem;
import ru.ijo42.dkm.medicaments.compressing.BandageItem;
import ru.ijo42.dkm.medicaments.compressing.BigBandageItem;
import ru.ijo42.dkm.medicaments.compressing.HarnessItem;
import ru.ijo42.dkm.medicaments.compressing.MateroeItem;
import ru.ijo42.dkm.medicaments.compressing.SplintItem;
import ru.ijo42.dkm.medicaments.compressing.StaffoeItem;
import ru.ijo42.dkm.medicaments.stimulators.AchitilcelinItem;
import ru.ijo42.dkm.medicaments.stimulators.EbaBistaItem;
import ru.ijo42.dkm.medicaments.stimulators.N91BItem;
import ru.ijo42.dkm.medicaments.stimulators.NiburoxydaseItem;
import ru.ijo42.dkm.medicaments.stimulators.PS0Item;

import java.util.Arrays;

@GameRegistry.ObjectHolder(Medicine.MOD_ID)
@Mod.EventBusSubscriber
public class ObjectRegistry {

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
    public static final MedicamentBaseItem Splint = new SplintItem();

    @GameRegistry.ObjectHolder("materoe")
    public static final MedicamentBaseItem Materoe = new MateroeItem();

    @GameRegistry.ObjectHolder("ibuprofon")
    public static final MedicamentBaseItem Ibuprofon = new IbuprofonItem();

    @GameRegistry.ObjectHolder("ketonol")
    public static final MedicamentBaseItem Ketonol = new KetonolItem();

    @GameRegistry.ObjectHolder("niburoxydase")
    public static final MedicamentBaseItem Niburoxydase = new NiburoxydaseItem();

    @GameRegistry.ObjectHolder("ebabista")
    public static final MedicamentBaseItem EbaBista = new EbaBistaItem();

    @GameRegistry.ObjectHolder("91b")
    public static final MedicamentBaseItem N91B = new N91BItem();

    @GameRegistry.ObjectHolder("achitilcelin")
    public static final MedicamentBaseItem Achitilcelin = new AchitilcelinItem();

    @GameRegistry.ObjectHolder("ps0")
    public static final MedicamentBaseItem PS0 = new PS0Item();

    @GameRegistry.ObjectHolder("anesthetic")
    public static final Potion Anesthetic = new AnestheticEffect();

    @GameRegistry.ObjectHolder("bleeding")
    public static final Potion Bleeding = new BleedingEffect();

    @GameRegistry.ObjectHolder("heavybleeding")
    public static final Potion HardBleeding = new HeavyBleedingEffect();

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(AI0, Fast91, DM, SFV, Bandage,
                BigBandage, Harness, Staffoe, Splint, Materoe, Ibuprofon,
                Ketonol, Niburoxydase, EbaBista, N91B, Achitilcelin, PS0
        );
    }

    @SubscribeEvent
    public static void onRegistryPotion(RegistryEvent.Register<Potion> e) {
        e.getRegistry().registerAll(
                Anesthetic, Bleeding, HardBleeding
        );
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        for (MedicamentBaseItem medicamentBaseItem : Arrays.asList(
                AI0, Fast91, DM, SFV, Bandage, BigBandage, Harness,
                Staffoe, Splint, Materoe, Ibuprofon, Ketonol,
                Niburoxydase, EbaBista, N91B, Achitilcelin, PS0
        )) {
            medicamentBaseItem.initModel();
        }
    }

}
