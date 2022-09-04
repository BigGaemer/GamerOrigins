package dev.ryantlg.gamerorigins;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Gamer implements ModInitializer {
	public static final String MOD_ID = "gamerorigins";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("man this Origins is Gamer");
	}
}
