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
            blit(pPoseStack, x + 106, y + 37, 176, 14, menu.getScaledProgress(), 17);
        }
    }
    private void renderHeatFlame(PoseStack stack, int x, int y) {
        if(menu.isBurning()) {
            blit(stack, x + 9, y + 41 + 12 - menu.getBurnProgress(), 176, 12 - menu.getBurnProgress(), 14, menu.getBurnProgress() + 1);
        }

    }
    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}

