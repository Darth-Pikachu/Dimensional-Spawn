package darth.dimensional;

import darth.dimensional.configs.DimensionalConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DimensionalSpawn.MODID)
public class DimensionalSpawn
{
    public static final String MODID = "dimensionalspawn";
    public static final Logger LOGGER = LogManager.getLogger();

    public DimensionalSpawn() {
        DimensionalSpawn.LOGGER.info("Zhu Li, do the thing!");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DimensionalConfig.COMMON_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
