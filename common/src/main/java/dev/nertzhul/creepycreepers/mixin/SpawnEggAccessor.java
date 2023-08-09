package dev.nertzhul.creepycreepers.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.SpawnEggItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(SpawnEggItem.class)
public interface SpawnEggAccessor {
    @Accessor("BY_ID")
    static Map<EntityType<? extends Mob>, SpawnEggItem> cc$getIdMap() {
        throw new AssertionError();
    }
}
