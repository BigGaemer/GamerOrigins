package dev.ryantlg.gamerorigins;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.function.Predicate;

import dev.ryantlg.gamerorigins.core.integration.GamerConfig;
import dev.ryantlg.gamerorigins.core.integration.GamerOrigins;
import dev.ryantlg.gamerorigins.core.network.client.DeleteHungerMessage;
import dev.ryantlg.gamerorigins.core.registry.ModItems;
import dev.ryantlg.gamerorigins.core.util.EventHandler;

public class Gamer implements ModInitializer {
	public static final String MOD_ID = "gamerorigins";
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(ModItems.WHITE_FEATHERED_WINGS));
	public static final Predicate<Entity> HAS_POWERED_FLIGHT = FabricLoader.getInstance().isModLoaded("origins") ? GamerOrigins::hasPoweredFlight : entity -> false;
	private static ConfigHolder<GamerConfig> configHolder;

	@Override
	public void onInitialize() {
		AutoConfig.register(GamerConfig.class, JanksonConfigSerializer::new);
		configHolder = AutoConfig.getConfigHolder(GamerConfig.class);

		ServerPlayNetworking.registerGlobalReceiver(DeleteHungerMessage.ID, DeleteHungerMessage::handle);
		ModItems.register();
		EventHandler.commonEvents();
	}

	public static GamerConfig getConfig() {
		return configHolder.getConfig();
	}
}
