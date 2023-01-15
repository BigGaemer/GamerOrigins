package dev.ryantlg.gamerorigins.registry;

import dev.ryantlg.gamerorigins.Gamer;
import dev.ryantlg.gamerorigins.enchantment.SunProtectionEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class modEnchantments {
    
    public static final Enchantment SUN_PROTECTION = new SunProtectionEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});

    public static void register() {
        register("water_protection", SUN_PROTECTION);
    }

    private static Enchantment register(String path, Enchantment enchantment) {
        Registry.register(Registry.ENCHANTMENT, new Identifier(Gamer.MOD_ID, path), enchantment);
        return enchantment;
    }
}
