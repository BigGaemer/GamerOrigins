package net.arcmods.gamer.gamerorigins.mixin;

import net.arcmods.gamer.gamerorigins.items.umbrella;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {


	@Shadow World world;

	@Shadow abstract BlockPos getBlockPos();

	@Shadow abstract Box getBoundingBox();

	@Shadow abstract Iterable<ItemStack> getHandItems();

	@Inject(method = "isBeingRainedOn", at = @At("HEAD"), cancellable = true)
	private void isBeingRainedOn(CallbackInfoReturnable<Boolean> cir) {
		Iterable<ItemStack> hands = this.getHandItems();
		for (ItemStack stack : hands) {
			if (stack.getItem() == umbrella.UMBRELLA)
				cir.setReturnValue(false);
		}
	}



}