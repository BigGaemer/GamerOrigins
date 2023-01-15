package dev.ryantlg.gamerorigins;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.ryantlg.gamerorigins.items.mync_eye;
import dev.ryantlg.gamerorigins.registry.modEnchantments;

public class Gamer implements ModInitializer {
	public static final String MOD_ID = "gamerorigins";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		mync_eye.register();
		modEnchantments.register();
		LOGGER.info("man this Origins is Gamer");
	}
}
