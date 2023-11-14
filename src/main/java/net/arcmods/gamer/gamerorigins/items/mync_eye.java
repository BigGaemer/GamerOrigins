package net.arcmods.gamer.gamerorigins.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class mync_eye {

    public static final Item MYNC_EYE = new Item(new Item.Settings().maxCount(1).rarity(Rarity.EPIC));

    public static void register() {
        Registry.register(Registries.ITEM, new Identifier("gamerorigins", "mync_eye"), MYNC_EYE);
    }
    
}
