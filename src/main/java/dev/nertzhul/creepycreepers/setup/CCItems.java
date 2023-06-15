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
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreepyCreepers.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreepyCreepers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("main_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(CCItems.GHOSTLY_CREEPER_SPAWN_EGG.get())).title(Component.translatable("creativetab.creepycreepers.title")).build());

    public static final RegistryObject<SpawnEggItem> GHOSTLY_CREEPER_SPAWN_EGG = ITEMS.register("ghostly_creeper_spawn_egg",
        () -> new ForgeSpawnEggItem(CCEntityTypes.GHOSTLY_CREEPER, 0xFFFFFF, 0x808080, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> AUSTRALIAN_CREEPER_SPAWN_EGG = ITEMS.register("australian_creeper_spawn_egg",
        () -> new ForgeSpawnEggItem(CCEntityTypes.AUSTRALIAN_CREEPER, 0x0000FF, 0xFFFFFF, new Item.Properties()));


    public static void registerCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CCItems.CREATIVE_TAB.get()) {
            ForgeRegistries.ITEMS.forEach(item -> {
                ResourceLocation itemID = ForgeRegistries.ITEMS.getKey(item);
                if (itemID != null && itemID.getNamespace().equals(CreepyCreepers.MOD_ID)) {
                    event.accept(item);
                }
            });
        }
    }
}
