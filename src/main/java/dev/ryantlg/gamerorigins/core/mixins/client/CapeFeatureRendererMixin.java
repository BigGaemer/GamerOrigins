package dev.ryantlg.gamerorigins.core.mixins.client;

import dev.emi.trinkets.api.TrinketsApi;
import dev.ryantlg.gamerorigins.Gamer;
import dev.ryantlg.gamerorigins.common.items.WingItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.CapeFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CapeFeatureRenderer.class)
public class CapeFeatureRendererMixin {
	@Inject(method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V", at = @At("HEAD"), cancellable = true)
	public void disableCape(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float g, float h, float j, float k, float l, CallbackInfo info) {
		if(Gamer.HAS_POWERED_FLIGHT.test(abstractClientPlayerEntity) || TrinketsApi.getTrinketComponent(abstractClientPlayerEntity).map(trinketComponent -> trinketComponent.isEquipped(itemStack -> itemStack.getItem() instanceof WingItem)).orElse(false))
			info.cancel();
	}
}
