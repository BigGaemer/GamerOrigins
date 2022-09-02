package dev.ryantlg.gamerorigins.core.integration;

import dev.ryantlg.gamerorigins.Gamer;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class GamerOrigins {
	public static final PowerType<Power> POWERED_FLIGHT = new PowerTypeReference<>(new Identifier(Gamer.MOD_ID, "powered_flight"));

	public static boolean hasPoweredFlight(Entity entity) {
		return GamerOrigins.POWERED_FLIGHT.get(entity) != null;
	}
}
