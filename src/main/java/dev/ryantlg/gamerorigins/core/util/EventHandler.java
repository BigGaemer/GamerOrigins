package dev.ryantlg.gamerorigins.core.util;

import dev.emi.trinkets.api.TrinketsApi;
import dev.ryantlg.gamerorigins.Gamer;
import dev.ryantlg.gamerorigins.common.items.WingItem;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;

public class EventHandler {
	public static void commonEvents() {
		EntityElytraEvents.CUSTOM.register((entity, tickElytra) -> TrinketsApi.getTrinketComponent(entity).filter(trinketComponent -> trinketComponent.isEquipped(stack -> stack.getItem() instanceof WingItem) || Gamer.HAS_POWERED_FLIGHT.test(entity)).isPresent());
	}
}
