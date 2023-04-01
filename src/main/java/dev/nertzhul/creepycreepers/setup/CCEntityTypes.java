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
package dev.nertzhul.creepycreepers.setup;

import dev.nertzhul.creepycreepers.CreepyCreepers;
import dev.nertzhul.creepycreepers.entities.AustralianCreeperEntity;
import dev.nertzhul.creepycreepers.entities.GhostlyCreeperEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreepyCreepers.MOD_ID);

    public static final RegistryObject<EntityType<GhostlyCreeperEntity>> GHOSTLY_CREEPER = register("ghostly_creeper",
        EntityType.Builder.of(GhostlyCreeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F).setTrackingRange(80));
    public static final RegistryObject<EntityType<AustralianCreeperEntity>> AUSTRALIAN_CREEPER = register("australian_creeper",
        EntityType.Builder.of(AustralianCreeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F).setTrackingRange(80));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).build(CreepyCreepers.resource(name).toString()));
    }

    public static void registerSpawns(SpawnPlacementRegisterEvent event) {
        event.register(GHOSTLY_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GhostlyCreeperEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(AUSTRALIAN_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AustralianCreeperEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(GHOSTLY_CREEPER.get(), Creeper.createAttributes().build());
        event.put(AUSTRALIAN_CREEPER.get(), Creeper.createAttributes().build());
    }
}
