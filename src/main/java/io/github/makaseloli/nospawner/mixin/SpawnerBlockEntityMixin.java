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
    private static void cancelServerTick(Level level, BlockPos pos, BlockState state, SpawnerBlockEntity entity, CallbackInfo ci) {
        ci.cancel();
    }
}
