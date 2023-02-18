package me.neo.forgedfactory.blocks.tiles.stone.dustmixer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.forgedfactory.FF;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Inventory;

public class DustMixerScreen extends AbstractContainerScreen<DustMixerMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FF.MOD_ID, "textures/gui/dust_mixer_gui.png");

    public DustMixerScreen(DustMixerMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
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

    private void renderProgressArrow(PoseStack stack, int x, int y) {
        if (menu.isCrafting()) {
            blit(stack, x + 102, y + 41, 176, 14, menu.getScaledProgress(), 18);
        }
    }

    private void renderHeatFlame(PoseStack stack, int x, int y) {
        if (menu.isBurning()) {
            blit(stack, x + 9, y + 43 + 12 - menu.getBurnProgres(), 176, 12 - menu.getBurnProgres(), 14, menu.getBurnProgres() + 1);

            blit(stack, x + 23, y + 15, 176, 32, 23, 56);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
}
