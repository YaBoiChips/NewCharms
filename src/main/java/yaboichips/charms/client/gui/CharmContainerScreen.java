package yaboichips.charms.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import yaboichips.charms.Charms;
import yaboichips.charms.container.CharmContainer;

public class CharmContainerScreen extends AbstractContainerScreen<CharmContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Charms.MOD_ID, "textures/gui/container.png");


    public CharmContainerScreen(CharmContainer screenContainer, Inventory inv, Component titleIn) {
        super(screenContainer, inv, titleIn);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderBg(GuiGraphics matrixStack, float p_97788_, int p_97789_, int p_97790_) {
        RenderSystem.clearColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        matrixStack.blit(BACKGROUND_TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }


    @Override
    public void render(GuiGraphics matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }
}