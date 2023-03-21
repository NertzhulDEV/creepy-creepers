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
package dev.nertzhul.creepycreepers;

import dev.nertzhul.creepycreepers.client.CreeperRenderingRegistry;
import dev.nertzhul.creepycreepers.init.CreepyRegistry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(CreepyCreepers.MOD_ID)
public class CreepyCreepers {
    public static final String MOD_ID = "creepycreepers";

    public CreepyCreepers() {
        IEventBus mod = FMLJavaModLoadingContext.get().getModEventBus();

        CreepyRegistry.ENTITIES.register(mod);
        CreepyRegistry.ITEMS.register(mod);
        CreepyRegistry.SOUNDS.register(mod);

        mod.addListener(CreepyRegistry::registerSpawns);
        mod.addListener(CreepyRegistry::registerAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            mod.addListener(CreeperRenderingRegistry::registerEntityModels);
            mod.addListener(CreeperRenderingRegistry::registerLayerDefinition);
            mod.addListener(CreepyRegistry::addToCreativeTabs);
        }
    }
}
