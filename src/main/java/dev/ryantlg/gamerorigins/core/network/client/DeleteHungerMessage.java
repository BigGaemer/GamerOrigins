package dev.ryantlg.gamerorigins.core.network.client;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.ryantlg.gamerorigins.Gamer;
import dev.ryantlg.gamerorigins.common.items.WingItem;
import dev.ryantlg.gamerorigins.core.util.IcarusHelper;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class DeleteHungerMessage {
	public static final Identifier ID = new Identifier(Gamer.MOD_ID, "delete_hunger");
	private static final TagKey<Item> MELTS = TagKey.of(Registry.ITEM_KEY, new Identifier(Gamer.MOD_ID, "melts"));

	public static void send() {
		PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
		ClientPlayNetworking.send(ID, buf);
	}

	public static void handle(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler network, PacketByteBuf buf, PacketSender sender) {
		server.execute(() -> {
			player.getHungerManager().addExhaustion(Gamer.getConfig().exhaustionAmount);

			if(!Gamer.HAS_POWERED_FLIGHT.test(player) && Gamer.getConfig().wingsDurability > 0 && player.age % 20 == 0) {
				Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);

				component.ifPresent(trinketComponent -> trinketComponent.getAllEquipped().forEach(pair -> {
					ItemStack stack = pair.getRight();

					if(stack.getItem() instanceof WingItem wings) {
						if(!wings.isUsable(stack))
							IcarusHelper.stopFlying(player);

						if(stack.isIn(MELTS))
							stack.damage(1, player, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
					}
				}));
			}
		});
	}
}
