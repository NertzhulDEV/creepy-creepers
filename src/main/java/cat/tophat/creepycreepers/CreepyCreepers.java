package cat.tophat.creepycreepers;

import cat.tophat.creepycreepers.common.init.Config;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CreepyCreepers.MOD_ID)
@EventBusSubscriber(bus = Bus.MOD)
public class CreepyCreepers {

    /**
     * Set the mods ID.
     */
    public static final String MOD_ID = "creepy-creepers";
    /**
     * Setup the logger for the mod.
     */
    private static final Logger LOGGER = LogManager.getLogger("Creepy Creepers");

    /**
     * Register things.
     */
    public CreepyCreepers() {
        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, Config.SERVER_SPECIFICATION);
    }
}
