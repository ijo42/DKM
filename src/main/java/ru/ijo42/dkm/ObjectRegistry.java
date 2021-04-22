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
import ru.ijo42.dkm.effects.negative.ContusionEffect;
import ru.ijo42.dkm.effects.negative.FractureArmEffect;
import ru.ijo42.dkm.effects.negative.FractureLegEffect;
import ru.ijo42.dkm.effects.negative.HeavyBleedingEffect;
import ru.ijo42.dkm.effects.negative.PainEffect;
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
    public static final MedicamentBaseItem AI_0 = new AI0Item();

    @GameRegistry.ObjectHolder("fast91")
    public static final MedicamentBaseItem FAST_91 = new Fast91Item();

    @GameRegistry.ObjectHolder("dm")
    public static final MedicamentBaseItem DM = new DMItem();

    @GameRegistry.ObjectHolder("sfv")
    public static final MedicamentBaseItem SFV = new SFVItem();

    @GameRegistry.ObjectHolder("bandage")
    public static final MedicamentBaseItem BANDAGE = new BandageItem();

    @GameRegistry.ObjectHolder("bigbandage")
    public static final MedicamentBaseItem BIG_BANDAGE = new BigBandageItem();

    @GameRegistry.ObjectHolder("harness")
    public static final MedicamentBaseItem HARNESS = new HarnessItem();

    @GameRegistry.ObjectHolder("staffoe")
    public static final MedicamentBaseItem STAFFOE = new StaffoeItem();

    @GameRegistry.ObjectHolder("splint")
    public static final MedicamentBaseItem SPLINT = new SplintItem();

    @GameRegistry.ObjectHolder("materoe")
    public static final MedicamentBaseItem MATEROE = new MateroeItem();

    @GameRegistry.ObjectHolder("ibuprofon")
    public static final MedicamentBaseItem IBUPROFON = new IbuprofonItem();

    @GameRegistry.ObjectHolder("ketonol")
    public static final MedicamentBaseItem KETONOL = new KetonolItem();

    @GameRegistry.ObjectHolder("niburoxydase")
    public static final MedicamentBaseItem NIBUROXYDASE = new NiburoxydaseItem();

    @GameRegistry.ObjectHolder("ebabista")
    public static final MedicamentBaseItem EBA_BISTA = new EbaBistaItem();

    @GameRegistry.ObjectHolder("91b")
    public static final MedicamentBaseItem N_91_B = new N91BItem();

    @GameRegistry.ObjectHolder("achitilcelin")
    public static final MedicamentBaseItem ACHITILCELIN = new AchitilcelinItem();

    @GameRegistry.ObjectHolder("ps0")
    public static final MedicamentBaseItem PS_0 = new PS0Item();

    @GameRegistry.ObjectHolder("anesthetic")
    public static final Potion ANESTHETIC = new AnestheticEffect();

    @GameRegistry.ObjectHolder("bleeding")
    public static final Potion BLEEDING = new BleedingEffect();

    @GameRegistry.ObjectHolder("heavybleeding")
    public static final Potion HEAVY_BLEEDING = new HeavyBleedingEffect();

    @GameRegistry.ObjectHolder(value="fracturearm")
    public static final Potion FRACTURE_ARM = new FractureArmEffect();

    @GameRegistry.ObjectHolder(value="fractureleg")
    public static final Potion FRACTURE_LEG = new FractureLegEffect();

    @GameRegistry.ObjectHolder(value="pain")
    public static final Potion PAIN = new PainEffect();

    @GameRegistry.ObjectHolder(value="contusion")
    public static final Potion CONTUSION = new ContusionEffect();

    @SubscribeEvent
    public static void onRegistryItem(RegistryEvent.Register<Item> e) {
        e.getRegistry().registerAll(AI_0, FAST_91, DM, SFV, BANDAGE,
                BIG_BANDAGE, HARNESS, STAFFOE, SPLINT, MATEROE, IBUPROFON,
                KETONOL, NIBUROXYDASE, EBA_BISTA, N_91_B, ACHITILCELIN, PS_0
        );
    }

    @SubscribeEvent
    public static void onRegistryPotion(RegistryEvent.Register<Potion> e) {
        e.getRegistry().registerAll(
                ANESTHETIC, BLEEDING, HEAVY_BLEEDING, FRACTURE_ARM, FRACTURE_LEG,
                PAIN, CONTUSION
        );
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onRegistryModel(ModelRegistryEvent e) {
        for (MedicamentBaseItem medicamentBaseItem : Arrays.asList(
                AI_0, FAST_91, DM, SFV, BANDAGE, BIG_BANDAGE, HARNESS,
                STAFFOE, SPLINT, MATEROE, IBUPROFON, KETONOL,
                NIBUROXYDASE, EBA_BISTA, N_91_B, ACHITILCELIN, PS_0
        )) {
            medicamentBaseItem.initModel();
        }
    }

}
