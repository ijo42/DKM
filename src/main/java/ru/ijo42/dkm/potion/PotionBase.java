package ru.ijo42.dkm.potion;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.ijo42.dkm.Medicine;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;

public class PotionBase extends Potion {
    protected final ResourceLocation textureRL;
    private final static int LIQUID_COLOR_IN = 16284963;
    @SideOnly(Side.CLIENT)
    private final static class MCHolder {
        private final static net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getMinecraft();
    }

    public PotionBase(boolean isBadEffectIn, String name) {
        super(isBadEffectIn, LIQUID_COLOR_IN);

        this.setPotionName("potion." + name)
                .setRegistryName(Medicine.getResourceLocation(name).toString());

        this.textureRL = Medicine.getResourceLocation("textures/potions/" + name + ".png");
    }

    @Nonnull
    @Override
    public List<ItemStack> getCurativeItems() {
        return Collections.emptyList();
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @ParametersAreNonnullByDefault
    public void renderInventoryEffect(PotionEffect effect, net.minecraft.client.gui.Gui gui, int x, int y, float z){
        if (this.textureRL != null) {
            MCHolder.mc.getTextureManager().bindTexture(this.textureRL);
            GlStateManager.pushMatrix();
            double sc = 0.07D;
            GlStateManager.scale(sc, sc, sc);
            x = MathHelper.floor((double)x / sc) + (int)(4.0D / sc);
            y = MathHelper.floor((double)y / sc) + (int)(5.0D / sc);
            int textureX = 0;
            int textureY = 0;
            int width = 256;
            int height = 256;
            float zLevel = 0.0F;
            float f = 0.00390625F;
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder vertexBuffer = tessellator.getBuffer();
            vertexBuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            vertexBuffer.pos(x, y + height, zLevel).tex((float)(textureX) * f, (float)(textureY + height) * f).endVertex();
            vertexBuffer.pos(x + width, y + height, zLevel).tex((float)(textureX + width) * f, (float)(textureY + height) * f).endVertex();
            vertexBuffer.pos(x + width, y, zLevel).tex((float)(textureX + width) * f, (float)(textureY) * f).endVertex();
            vertexBuffer.pos(x, y, zLevel).tex((float)(textureX) * f, (float)(textureY) * f).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
        }

    }

    @SideOnly(Side.CLIENT)
    @ParametersAreNonnullByDefault
    public void renderHUDEffect(PotionEffect effect, net.minecraft.client.gui.Gui gui, int x, int y, float z, float alpha){
        if (this.textureRL != null && MCHolder.mc.ingameGUI != null) {
            MCHolder.mc.getTextureManager().bindTexture(this.textureRL);
            GlStateManager.pushMatrix();
            double sc = 0.08D;
            GlStateManager.scale(sc, sc, sc);
            MCHolder.mc.ingameGUI.drawTexturedModalRect(MathHelper.floor((double)x / sc) + MathHelper.floor(2.0D / sc),
                    MathHelper.floor((double)y / sc) + MathHelper.floor(2.0D / sc), 0, 0, 256, 256);
            GlStateManager.popMatrix();
        }

    }
}
