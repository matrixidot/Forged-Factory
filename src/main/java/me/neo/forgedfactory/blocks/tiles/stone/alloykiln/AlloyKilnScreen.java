package me.neo.forgedfactory.blocks.tiles.stone.alloykiln;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import me.neo.forgedfactory.FF;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;



public class AlloyKilnScreen extends AbstractContainerScreen<AlloyKilnMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FF.MOD_ID, "textures/gui/alloy_kiln_gui.png");

    public AlloyKilnScreen(AlloyKilnMenu menu, Inventory inventory, Component component) {
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
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(pPoseStack, x, y);
        renderHeatFlame(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            // Stack, pos x, pos y, filled texture x, filled texture y, something, something
            blit(pPoseStack, x + 101, y + 24, 176, 14, menu.getScaledProgress(), 16);
            blit(pPoseStack, x + 57, y + 21, 176, 30, 9, 9);
        }
    }
    private void renderHeatFlame(PoseStack stack, int x, int y) {
        if(menu.isBurning()) {
            blit(stack, x + 55, y + 42 + 12 - menu.getBurnProgress(), 176, 12 - menu.getBurnProgress(), 14, menu.getBurnProgress() + 1);

            blit(stack, x + 35, y + 59, 176, 41, 17, 10);
            blit(stack, x + 72, y + 59, 176, 51, 17, 10);

            blit(stack, x + 83, y + 42, 176, 62, 8, 16);
            blit(stack, x + 34, y + 42, 176, 62, 8, 16);
        }



    }
    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}

