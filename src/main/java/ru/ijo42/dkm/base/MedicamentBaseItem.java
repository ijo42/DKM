package ru.ijo42.dkm.base;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ijo42.dkm.Constants;
import ru.ijo42.dkm.Medicine;
import ru.ijo42.dkm.interfaces.IMedicamentSpecs;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class MedicamentBaseItem extends ItemFood {

    private final int itemUseDuration;
    private final ITextComponent desk;

    public MedicamentBaseItem(
            IMedicamentSpecs specs
    ) {
        super(0, 0, false);
        this.setCreativeTab(Medicine.DKM)
                .setTranslationKey(specs.getName())
                .setMaxStackSize(specs.getMaxStackSize())
                .setMaxDamage(specs.getMaxDamage() - 1)
                .setRegistryName(Medicine.getResourceLocation(specs.getName()).toString());

        this.itemUseDuration = specs.getUsageTime() * Constants.TICK_IN_SECONDS;
        this.desk = specs.getDescription();
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getMaxItemUseDuration(final ItemStack stack) {
        return itemUseDuration;
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
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.curePotionEffects(stack);
        }
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        if (entityLiving instanceof EntityPlayer) {
            EntityPlayer entityplayer = (EntityPlayer) entityLiving;
            this.onFoodEaten(stack, worldIn, entityplayer);

            if (entityplayer instanceof EntityPlayerMP) {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP) entityplayer, stack);
            }
        }

        if (getMaxDamage(stack) > 1) {
            stack.damageItem(1, entityLiving);
        } else {
            stack.shrink(1);
        }
        return stack;
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        playerIn.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
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
