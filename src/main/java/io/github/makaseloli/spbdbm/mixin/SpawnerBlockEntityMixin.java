package io.github.makaseloli.spbdbm.mixin;


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
        value = {SpawnerBlockEntity.class},
        remap = false)

public class SpawnerBlockEntityMixin {
    @Inject(
            method = "serverTick",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void noServerTick(Level p_155762_, BlockPos p_155763_, BlockState p_155764_, SpawnerBlockEntity p_155765_, CallbackInfo ci) {
        ci.cancel();
    }
}

