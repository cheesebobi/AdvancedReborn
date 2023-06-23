package ml.pkom.advancedreborn.renderer;

import ml.pkom.advancedreborn.Blocks;
import ml.pkom.advancedreborn.entities.IndustrialTNTEntity;
import ml.pkom.mcpitanlibarch.api.util.MathUtil;
import ml.pkom.mcpitanlibarch.api.util.client.MatrixStackUtil;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class IndustrialTNTEntityRenderer extends EntityRenderer<IndustrialTNTEntity> {

    private final BlockRenderManager blockRenderManager;

    public IndustrialTNTEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        blockRenderManager = context.getBlockRenderManager();
        this.shadowRadius = 0.5F;
    }

    public void render(IndustrialTNTEntity entity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0D, 0.5D, 0.0D);
        if (entity.getFuse() - g + 1.0F < 10.0F) {
            float h = 1.0F - (entity.getFuse() - g + 1.0F) / 10.0F;
            h = MathHelper.clamp(h, 0.0F, 1.0F);
            h *= h;
            h *= h;
            float j = 1.0F + h * 0.3F;
            matrixStack.scale(j, j, j);
        }

        //matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0F));
        MatrixStackUtil.multiply(matrixStack, MathUtil.RotationAxisType.POSITIVE_Y, -90.0F);
        matrixStack.translate(-0.5D, -0.5D, 0.5D);
        //matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
        MatrixStackUtil.multiply(matrixStack, MathUtil.RotationAxisType.POSITIVE_Y, 90.0F);
        TntMinecartEntityRenderer.renderFlashingBlock(this.blockRenderManager, Blocks.INDUSTRIAL_TNT.getDefaultState(), matrixStack, vertexConsumerProvider, i, entity.getFuse() / 5 % 2 == 0);
        matrixStack.pop();
        super.render(entity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(IndustrialTNTEntity entity) {
        return SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE;
    }
}
