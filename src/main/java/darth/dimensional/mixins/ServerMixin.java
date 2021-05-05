package darth.dimensional.mixins;


import darth.dimensional.configs.DimensionalConfig;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftServer.class)
public abstract class ServerMixin {

    @Redirect(method = "func_240787_a_", at = @At(value = "FIELD", target = "Lnet/minecraft/world/World;OVERWORLD:Lnet/minecraft/util/RegistryKey;"))
    public RegistryKey<World> replaceWorldKey()
    {
        return DimensionalConfig.COMMON.getWorldKey();
    }

    @Redirect(method = "func_240787_a_", at = @At(value = "FIELD", target = "Lnet/minecraft/world/Dimension;OVERWORLD:Lnet/minecraft/util/RegistryKey;"))
    public RegistryKey<Dimension> replaceDimKey()
    {
        return DimensionalConfig.COMMON.getDimKey();
    }


    @Inject(at = @At("HEAD"), method = "func_241755_D_()Lnet/minecraft/world/server/ServerWorld;", cancellable = true)
    public void func_241755_D_(CallbackInfoReturnable<ServerWorld> callback)
    {
        callback.setReturnValue(this.getWorld(DimensionalConfig.COMMON.getWorldKey()));
    }

    @Shadow
    public ServerWorld getWorld(RegistryKey<World> dimension)
    {
        throw new IllegalStateException("Mixin failed to shadow getWorld()");
    }
}
