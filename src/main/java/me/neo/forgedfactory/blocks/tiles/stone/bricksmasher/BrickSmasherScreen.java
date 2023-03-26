package me.neo.forgedfactory.blocks.tiles.stone.bricksmasher;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.forgedfactory.FF;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BrickSmasherScreen extends AbstractContainerScreen<BrickSmasherMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FF.MOD_ID, "textures/gui/brick_smasher_gui.png");

    public BrickSmasherScreen(BrickSmasherMenu menu, Inventory inv, Component component) {
        super(menu, inv, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(pPoseStack, x, y);
        renderHeatFlame(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack poseStack, int x, int y) {
        if (menu.isCrafting()) {
            // Stack, pos x, pos y, filled texture x, filled texture y, something, something
            blit(poseStack, x + 67, y + 34, 176, 14, menu.getScaledProgress(), 17);
        }
    }

    private void renderHeatFlame(PoseStack stack, int x, int y) {
        if(menu.isBurning()) {
            blit(stack, x + 8, y + 37 + 12 - menu.getBurnProgress(), 176, 12 - menu.getBurnProgress(), 14, menu.getBurnProgress() + 1);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
