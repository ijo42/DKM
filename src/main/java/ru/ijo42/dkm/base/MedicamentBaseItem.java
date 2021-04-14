package ru.ijo42.dkm.base;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ijo42.dkm.Medicine;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;
import ru.ijo42.dkm.interfaces.EffectConsumer;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MedicamentBaseItem extends ItemPotion {

    private final ITextComponent desk;
    private final EffectConsumer<ItemStack, World, EntityLivingBase>
            relatedEffects;

    public MedicamentBaseItem(
            IMedicamentSpecs specs
    ) {
        this.setRegistryName(Medicine.getResourceLocation(specs.getName()).toString());
        this.setCreativeTab(Medicine.DKM);
        this.setTranslationKey(specs.getName());
        this.setMaxStackSize(specs.getMaxStackSize());
        this.setMaxDamage(specs.getMaxDamage() - 1);
        this.desk = specs.getDescription();
        this.relatedEffects = specs.getRelatedEffects();
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(
            @Nonnull ItemStack stack,
            World world,
            List<String> tooltip,
            @Nonnull net.minecraft.client.util.ITooltipFlag flag
    ) {
        tooltip.add(desk.getFormattedText());
    }

    @Override
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    public String getItemStackDisplayName(ItemStack stack) {
        return new TextComponentTranslation(getTranslationKey()).getFormattedText();
    }

    @SideOnly(Side.CLIENT)
    @Override
    @MethodsReturnNonnullByDefault
    public ItemStack getDefaultInstance() {
        return PotionUtils.addPotionToItemStack(new ItemStack(this), PotionTypes.EMPTY);
    }

    @Override
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer) entityLiving : null;

        if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
            stack.damageItem(1, entityLiving);
        }

        if (entityplayer instanceof EntityPlayerMP) {
            CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) entityplayer, stack);
        }

        if (!worldIn.isRemote) {
            for (PotionEffect potioneffect : PotionUtils.getEffectsFromStack(stack)) {
                if (potioneffect.getPotion().isInstant()) {
                    potioneffect.getPotion().affectEntity(
                            entityplayer,
                            entityplayer,
                            entityLiving,
                            potioneffect.getAmplifier(),
                            1.0D
                    );
                } else {
                    entityLiving.addPotionEffect(new PotionEffect(potioneffect));
                }
            }

            relatedEffects.accept(stack, worldIn, entityLiving);
        }
        return stack;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(new ItemStack(this));
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        if (getRegistryName() == null) {
            throw new RuntimeException("Init registry name first");
        }
        net.minecraftforge.client.model.ModelLoader
                .setCustomModelResourceLocation(this, 0,
                        new net.minecraft.client.renderer.block.model.ModelResourceLocation(
                                getRegistryName(), "inventory")
                );
    }

}
