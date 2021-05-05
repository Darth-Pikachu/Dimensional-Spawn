package darth.dimensional.mixins;


import darth.dimensional.configs.DimensionalConfig;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerMixin
{
    @Redirect(method = "func_205734_a", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/DimensionType;hasSkyLight()Z"))
    public boolean replaceSkyLightCheck(DimensionType dimensionType)
    {
        return true;
    }

    @Redirect(method = "changeDimension", at = @At(value = "FIELD", target = "Lnet/minecraft/world/World;OVERWORLD:Lnet/minecraft/util/RegistryKey;"))
    public RegistryKey<World> endCreditFix()
    {
        return DimensionalConfig.COMMON.getWorldKey();
    }
}
