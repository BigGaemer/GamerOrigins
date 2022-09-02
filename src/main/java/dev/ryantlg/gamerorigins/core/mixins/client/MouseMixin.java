package dev.ryantlg.gamerorigins.core.mixins.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import dev.ryantlg.gamerorigins.Gamer;

@Mixin(Mouse.class)
public class MouseMixin {
	@Shadow @Final private MinecraftClient client;

	@ModifyArg(method = "updateMouse", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V"
	), index = 0)
	public double changeLookDirectionX(double x) {
		if(Gamer.getConfig().canLoopdeloop && client.player != null && client.player.isFallFlying() && (client.player.getPitch() > 90 || client.player.getPitch() < -90))
			return -x;

		return x;
	}
}
