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

import dev.nertzhul.creepycreepers.setup.CCEntityTypes;
import dev.nertzhul.creepycreepers.setup.CCItems;
import dev.nertzhul.creepycreepers.setup.CCSoundTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreepyCreepers.MOD_ID)
public class CreepyCreepers {
    public static final String MOD_ID = "creepycreepers";

    public CreepyCreepers() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        CCItems.ITEMS.register(modBus);
        CCEntityTypes.ENTITIES.register(modBus);
        CCSoundTypes.SOUNDS.register(modBus);

        modBus.addListener(CCItems::registerCreativeTab);
        modBus.addListener(CCEntityTypes::registerSpawns);
        modBus.addListener(CCEntityTypes::registerAttributes);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> CreepyCreepersClient::new);
    }

    public static ResourceLocation resource(String pValue) {
        return new ResourceLocation(MOD_ID, pValue);
    }
}
