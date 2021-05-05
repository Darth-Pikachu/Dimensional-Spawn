package darth.dimensional.configs;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class DimensionalConfig
{
    public static class Common
    {
        public final ForgeConfigSpec.ConfigValue<String> DIM;

        public Common(ForgeConfigSpec.Builder builder)
        {
            DIM = builder.comment("The default spawn dimension. Requires a valid dimension ID(WILL CRASH IF INVALID) ex: minecraft:the_nether, twilightforest:twilightforest (default: minecraft:overworld").define("SpawnDim", "minecraft:overworld");
        }

        public RegistryKey<Dimension> getDimKey()
        {
            return RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, new ResourceLocation(DIM.get()));
        }

        public RegistryKey<World> getWorldKey()
        {
            return RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(DIM.get()));
        }
    }
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    static
    {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
