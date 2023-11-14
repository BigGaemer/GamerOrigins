package net.arcmods.gamer.gamerorigins;

import net.arcmods.gamer.gamerorigins.items.mync_eye;
import net.arcmods.gamer.gamerorigins.items.umbrella;
import net.arcmods.gamer.gamerorigins.registry.modEnchantments;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gamer implements ModInitializer {
	public static final String MOD_ID = "gamerorigins";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		umbrella.registerItems();
		mync_eye.register();
		modEnchantments.register();
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((content) -> content.add(umbrella.UMBRELLA));
		LOGGER.info("man this Origins is Gamer");
	}
}
