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
package dev.nertzhul.creepycreepers.setup.datagen.providers;

import dev.nertzhul.creepycreepers.CreepyCreepers;
import dev.nertzhul.creepycreepers.setup.CCSoundTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundDefinitions extends SoundDefinitionsProvider {
    public SoundDefinitions(PackOutput output, ExistingFileHelper helper) {
        super(output, CreepyCreepers.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        add(CCSoundTypes.AUSTRALIAN_CREEPER_SOUND.get(), definition().with(
            sound(modLoc("ghostly_creeper_scream"))
        ).subtitle("subtitle.creepycreepers.australian_creeper_scream"));

        add(CCSoundTypes.GHOSTLY_CREEPER_SOUND.get(), definition().with(
            sound(modLoc("ghostly_creeper_scream"))
        ).subtitle("subtitle.creepycreepers.ghostly_creeper_scream"));
    }

    private ResourceLocation modLoc(String path) {
        return new ResourceLocation(CreepyCreepers.MOD_ID, path);
    }
}
