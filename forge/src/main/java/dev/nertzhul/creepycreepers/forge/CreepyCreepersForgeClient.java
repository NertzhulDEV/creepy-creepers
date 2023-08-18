package dev.nertzhul.creepycreepers.forge;

import dev.nertzhul.creepycreepers.CreepyCreepersClient;
import dev.nertzhul.creepycreepers.client.rendering.ghostlycreeper.GhostlyCreeperModel;
import dev.nertzhul.creepycreepers.client.rendering.ghostlycreeper.GhostlyCreeperRenderer;
import dev.nertzhul.creepycreepers.client.rendering.halloweencreeper.HalloweenCreeperModel;
import dev.nertzhul.creepycreepers.client.rendering.halloweencreeper.HalloweenCreeperRenderer;
import dev.nertzhul.creepycreepers.client.rendering.snowycreeper.SnowyCreeperModel;
import dev.nertzhul.creepycreepers.client.rendering.snowycreeper.SnowyCreeperRenderer;
import dev.nertzhul.creepycreepers.items.DispenserReadySpawnEgg;
import dev.nertzhul.creepycreepers.setup.CcEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CreepyCreepersForgeClient {
    public static void init() {
        CreepyCreepersClient.init();
        
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        modBus.addListener(CreepyCreepersForgeClient::onRegisterEntityRenderers);
        modBus.addListener(CreepyCreepersForgeClient::onEntityLayers);
        
        modBus.addListener(EventPriority.HIGHEST, (RegisterColorHandlersEvent.Item event) -> {
            DispenserReadySpawnEgg.SPAWN_EGGS.forEach(pair ->
                event.getItemColors().register((stack, layer) -> pair.getSecond().getColor(layer), pair.getSecond()));
        });
    }
    
    private static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CcEntities.GHOSTLY_CREEPER.get(), GhostlyCreeperRenderer::new);
        event.registerEntityRenderer(CcEntities.SNOWY_CREEPER.get(), SnowyCreeperRenderer::new);
        event.registerEntityRenderer(CcEntities.HALLOWEEN_CREEPER.get(), HalloweenCreeperRenderer::new);
    }
    
    private static void onEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GhostlyCreeperModel.LAYER, GhostlyCreeperModel::createBodyLayer);
        event.registerLayerDefinition(SnowyCreeperModel.LAYER, SnowyCreeperModel::createBodyLayer);
        event.registerLayerDefinition(HalloweenCreeperModel.LAYER, HalloweenCreeperModel::createBodyLayer);
    }
}