package net.pitan76.advancedreborn;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.EmotionParticle;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.Vec3d;
import net.pitan76.advancedreborn.entities.IndustrialTNTEntity;
import net.pitan76.advancedreborn.packet.EntitySpawnPacket;
import net.pitan76.advancedreborn.renderer.IndustrialTNTEntityRenderer;
import net.pitan76.advancedreborn.screen.CardboardBoxScreen;
import net.pitan76.mcpitanlib.api.client.registry.CompatRegistryClient;
import net.pitan76.mcpitanlib.api.client.registry.EntityRendererRegistry;
import net.pitan76.mcpitanlib.api.network.ClientNetworking;

import java.util.UUID;

import static net.pitan76.advancedreborn.AdvancedReborn.INSTANCE;

public class AdvancedRebornClient implements ClientModInitializer {

    public static MinecraftClient client = MinecraftClient.getInstance();

    public void onInitializeClient() {
        CompatRegistryClient.registryClientSpriteAtlasTexture(INSTANCE.id("particle/energy"));

        CompatRegistryClient.registerParticle(Particles.ENERGY, EmotionParticle.HeartFactory::new);

        EntityRendererRegistry.registerEntityRendererAsFlyingItem(() -> Entities.DYNAMITE.getOrNull());
        CompatRegistryClient.registerEntityRenderer(() -> (EntityType<IndustrialTNTEntity>) Entities.I_TNT.getOrNull(), IndustrialTNTEntityRenderer::new);

        CompatRegistryClient.registerScreen(AdvancedReborn.MOD_ID, ScreenHandlers.CARDBOARD_BOX_SCREEN_HANDLER, CardboardBoxScreen::new);

        /*
        ClientNetworking.registerReceiver(Defines.SPAWN_PACKET_ID.toMinecraft(), (client, player, buf) -> {
            EntityType<?> et = Registries.ENTITY_TYPE.get(buf.readVarInt());
            UUID uuid = buf.readUuid();
            int entityId = buf.readVarInt();
            Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(buf);
            float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(buf);
            float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(buf);
            if (client.world == null) return;
            Entity entity = et.create(client.world);
            if (entity == null) return;
            entity.updateTrackedPosition(pos.x, pos.y, pos.z);
            entity.setPos(pos.x, pos.y, pos.z);
            entity.setYaw(pitch);
            entity.setYaw(yaw);
            entity.setId(entityId);
            entity.setUuid(uuid);
            client.world.addEntity(entity);
        });

         */
    }
}