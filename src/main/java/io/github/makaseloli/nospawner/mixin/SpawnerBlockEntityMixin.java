package io.github.makaseloli.nospawner.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(
        value = SpawnerBlockEntity.class
)

public class SpawnerBlockEntityMixin {
    @Inject(
            method = "serverTick(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/SpawnerBlockEntity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void inject_serverTick(Level p_155762_, BlockPos p_155763_, BlockState p_155764_, SpawnerBlockEntity p_155765_, CallbackInfo ci) {
        ci.cancel();
    }
}

