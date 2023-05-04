package net.arcmods.gamer.gamerorigins.items;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class mync_eye {

    public static final Item MYNC_EYE = new Item(new Item.Settings().maxCount(1).rarity(Rarity.EPIC));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("gamerorigins", "mync_eye"), MYNC_EYE);
    }
    
}
