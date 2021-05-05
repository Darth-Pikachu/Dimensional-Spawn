package darth.dimensional.mixins;

import darth.dimensional.configs.DimensionalConfig;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerList.class)
public abstract class PlayerJoinMixin
{
    @Redirect(method = "initializeConnectionToPlayer", at = @At(value = "FIELD", target = "Lnet/minecraft/world/World;OVERWORLD:Lnet/minecraft/util/RegistryKey;"))
    public RegistryKey<World> replaceSpawnDim()
    {
        return DimensionalConfig.COMMON.getWorldKey();
    }
}
