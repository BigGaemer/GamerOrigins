package net.arcmods.gamer.gamerorigins.mixin;

import io.github.apace100.apoli.power.factory.condition.EntityConditions;
import io.github.apace100.calio.data.SerializableData;
import net.arcmods.gamer.gamerorigins.items.umbrella;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityConditions.class)
public class PlayerConditionsMixin {

    @Inject(method = { "lambda$register$10" }, at = { @At("HEAD") }, cancellable = true)
    private static void sunDamagePrevention(SerializableData.Instance data, Entity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getHandItems()) {
            if (stack.getItem().equals(umbrella.UMBRELLA) && stack.getDamage() < stack.getMaxDamage() - 1) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(method = { "lambda$register$11" }, at = { @At("HEAD") }, cancellable = true)
    private static void umbrellaRainedOn(SerializableData.Instance data, Entity player, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : player.getHandItems()) {
            if (stack.getItem().equals(umbrella.UMBRELLA) && stack.getDamage() < stack.getMaxDamage() - 1) {
                cir.setReturnValue(false);
            }
        }
    }


}