package dev.ryantlg.gamerorigins.core.integration;

import dev.ryantlg.gamerorigins.Gamer;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Gamer.MOD_ID)
public class GamerConfig implements ConfigData {
	public boolean canLoopdeloop = true;
	public boolean armourSlows = true;
	public boolean canSlowFall = false;
	public float maxSlowedMultiplier = 3F;
	public float wingsSpeed = 0.02F;
	public int wingsDurability = 0;
	public float exhaustionAmount = 0.03F;
	public float rollAmount = 1.0F;
}
