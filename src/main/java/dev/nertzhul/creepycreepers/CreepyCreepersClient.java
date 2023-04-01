/*
 * Copyright (C) 2023 <Nertzhul>
 * Creepy Creepers - https://github.com/NertzhulDEV/creepy-creepers
 *
 * This library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the license.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https://www.gnu.org/licenses/gpl-3.0.html
 */
package dev.nertzhul.creepycreepers;

import dev.nertzhul.creepycreepers.client.models.AustralianCreeperModel;
import dev.nertzhul.creepycreepers.client.models.GhostlyCreeperModel;
import dev.nertzhul.creepycreepers.client.rendering.AustralianCreeperRenderer;
import dev.nertzhul.creepycreepers.client.rendering.GhostlyCreeperRenderer;
import dev.nertzhul.creepycreepers.setup.CCEntityTypes;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CreepyCreepersClient {
    public CreepyCreepersClient() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::onRegisterRenderers);
        modBus.addListener(this::onRegisterLayerDefinitions);
    }

    public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CCEntityTypes.GHOSTLY_CREEPER.get(), GhostlyCreeperRenderer::new);
        event.registerEntityRenderer(CCEntityTypes.AUSTRALIAN_CREEPER.get(), AustralianCreeperRenderer::new);
    }

    public void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GhostlyCreeperModel.GHOSTLY_CREEPER_LAYER_LOCATION, GhostlyCreeperModel::createBodyLayer);
        event.registerLayerDefinition(AustralianCreeperModel.AUSTRALIAN_CREEPER_LAYER_LOCATION, AustralianCreeperModel::createBodyLayer);
    }
}
