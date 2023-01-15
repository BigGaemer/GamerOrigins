package dev.ryantlg.gamerorigins.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;

public class SunProtectionEnchantment extends Enchantment {
    
    public SunProtectionEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    public int getMinPower(int level) {
        return 8 + level * 5;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 8;
    }

    public boolean isTreasure() {
        return true;
    }

    public int getMaxLevel() {
        return 4;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        if(other == this || ((other instanceof ProtectionEnchantment && !(((ProtectionEnchantment)other).protectionType == ProtectionEnchantment.Type.ALL)))) {
            return false;
        }
        return super.canAccept(other);
    }


}
