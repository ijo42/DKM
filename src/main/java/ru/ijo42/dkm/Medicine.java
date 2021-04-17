package ru.ijo42.dkm;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

@Mod(
        modid = Medicine.MOD_ID,
        name = Medicine.MOD_NAME,
        version = Medicine.VERSION,
        certificateFingerprint = Medicine.CERTIFICATE
)
public class Medicine {

    public static final String MOD_ID = "dkm",
            MOD_NAME = "DKM", VERSION = "%VERSION%",
            CERTIFICATE = "%CERTIFICATE%";

    public static final CreativeTabs DKM = new CreativeTabs(MOD_ID) {
        @Nonnull
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return Items.SPLASH_POTION.getDefaultInstance();
        }
    };

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Medicine INSTANCE;

    public static ResourceLocation getResourceLocation(String key) {
        return new ResourceLocation(MOD_ID, key);
    }

}
