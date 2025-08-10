package io.github.makaseloli.nospawner.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(
        value = MobSpawnerBlockEntity.class
)

public class MobSpawnerBlockEntityMixin {
    @Inject(
            method = "serverTick(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/block/entity/MobSpawnerBlockEntity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void inject_serverTick(World world, BlockPos pos, BlockState state, MobSpawnerBlockEntity blockEntity, CallbackInfo ci) {
        ci.cancel();
    }
}

