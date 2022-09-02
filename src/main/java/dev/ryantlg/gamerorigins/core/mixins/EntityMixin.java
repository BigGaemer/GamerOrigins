package dev.ryantlg.gamerorigins.core.mixins;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import dev.ryantlg.gamerorigins.core.util.IcarusHelper;

@Mixin(Entity.class)
public abstract class EntityMixin {
	@SuppressWarnings("ConstantConditions")
	@Redirect(method = "changeLookDirection", at = @At(value = "INVOKE",
			target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"
	))
	public float aaaaa(float value, float min, float max) {
		return IcarusHelper.getAdjustedPitch((Entity) (Object) this, MathHelper.clamp(value, min, max));
	}
}
