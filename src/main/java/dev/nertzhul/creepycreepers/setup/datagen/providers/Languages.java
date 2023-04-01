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
import dev.nertzhul.creepycreepers.setup.CCEntityTypes;
import dev.nertzhul.creepycreepers.setup.CCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unused" })
public class Languages extends LanguageProvider {
    public static final Translation CREATIVE_TAB = Translation.builder("creativetab", "title").addLocale(Locale.EN_US, "Creepy Creepers").build();

    //region Items
    public static final Translation AUSTRALIAN_CREEPER_SPAWN_EGG = Translation.builder(CCItems.AUSTRALIAN_CREEPER_SPAWN_EGG.get())
        .addLocale(Locale.EN_US, "Australian Creeper Spawn Egg")
        .addLocale(Locale.PT_BR, "Ovo de Creeper Australiano").build();
    public static final Translation GHOSTLY_CREEPER_SPAWN_EGG = Translation.builder(CCItems.GHOSTLY_CREEPER_SPAWN_EGG.get())
        .addLocale(Locale.EN_US, "Ghostly Creeper Spawn Egg")
        .addLocale(Locale.PT_BR, "Ovo de Creeper Fantasmagórico").build();
    //endregion

    //region Entities
    public static final Translation AUSTRALIAN_CREEPER = Translation.builder(CCEntityTypes.AUSTRALIAN_CREEPER.get())
        .addLocale(Locale.EN_US, "Australian Creeper")
        .addLocale(Locale.PT_BR, "Creeper Australiano").build();
    public static final Translation GHOSTLY_CREEPER = Translation.builder(CCEntityTypes.GHOSTLY_CREEPER.get())
        .addLocale(Locale.EN_US, "Ghostly Creeper")
        .addLocale(Locale.PT_BR, "Creeper Fantasmagórico").build();
    //endregion

    //region Subtitles
    public static final Translation AUSTRALIAN_CREEPER_SCREAM = Translation.builder("subtitle", "australian_creeper_scream")
        .addLocale(Locale.EN_US, "Australian Creeper Scream")
        .addLocale(Locale.PT_BR, "Grito de Creeper Australiano").build();
    public static final Translation GHOSTLY_CREEPER_SCREAM = Translation.builder("subtitle", "ghostly_creeper_scream")
        .addLocale(Locale.EN_US, "Ghostly Creeper Scream")
        .addLocale(Locale.PT_BR, "Grito de Creeper Fantasmagórico").build();
    //endregion

    private final Locale locale;

    public Languages(PackOutput output, Locale locale) {
        super(output, CreepyCreepers.MOD_ID, locale.get());
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.getType() == Translation.class) {
                try {
                    Translation entry = (Translation) field.get(Translation.class);
                    String key = this.locale.get();

                    if (entry.localeMap().get(key) != null) {
                        add(entry.key(), entry.localeMap.get(key));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public record Translation(String key, Map<String, String> localeMap) {
        public Component asComponent() {
            return Component.translatable(key());
        }

        public Component asComponent(Object... args) {
            return Component.translatable(key(), args);
        }

        public static Builder builder(Item item) {
            return new Builder(item.getDescriptionId());
        }

        public static Builder builder(EntityType<?> entityType) {
            return new Builder(entityType.getDescriptionId());
        }

        public static Builder builder(Block block) {
            return new Builder(block.getDescriptionId());
        }

        public static Builder builder(String category, String path) {
            return new Builder(category + "." + CreepyCreepers.MOD_ID + "." + path);
        }

        public static class Builder {
            private final String key;
            private final Map<String, String> localeMap;

            private Builder(String key) {
                this.key = key;
                this.localeMap = new HashMap<>();
            }

            public Builder addLocale(Locale locale, String translation) {
                this.localeMap.put(locale.get(), translation);
                return this;
            }

            public Translation build() {
                return new Translation(key, localeMap);
            }
        }
    }

    public enum Locale {
        EN_US, PT_BR;

        public String get() { return this.name().toLowerCase(); }
    }
}
