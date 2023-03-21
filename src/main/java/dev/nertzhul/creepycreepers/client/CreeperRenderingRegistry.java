/*
 * Creepy Creepers - https://github.com/NertzhulDEV/creepy-creepers
 * Copyright (C) 2023 <Nertzhul>
 *
 * This library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https://www.gnu.org/licenses/gpl-3.0.html
 */
package dev.nertzhul.creepycreepers.client;

import dev.nertzhul.creepycreepers.client.models.AustralianCreeperModel;
import dev.nertzhul.creepycreepers.client.models.GhostlyCreeperModel;
import dev.nertzhul.creepycreepers.client.rendering.AustralianCreeperRenderer;
import dev.nertzhul.creepycreepers.client.rendering.GhostlyCreeperRenderer;
import dev.nertzhul.creepycreepers.init.CreepyRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class CreeperRenderingRegistry {

    public static void registerEntityModels(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CreepyRegistry.GHOSTLY_CREEPER.get(),
            GhostlyCreeperRenderer::new);
        event.registerEntityRenderer(CreepyRegistry.AUSTRALIAN_CREEPER.get(),
            AustralianCreeperRenderer::new);
    }

    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GhostlyCreeperModel.GHOSTLY_CREEPER_LAYER_LOCATION,
            GhostlyCreeperModel::createBodyLayer);
        event.registerLayerDefinition(AustralianCreeperModel.AUSTRALIAN_CREEPER_LAYER_LOCATION,
            AustralianCreeperModel::createBodyLayer);
    }
}
