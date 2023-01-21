package net.arcmods.gamer.gamerorigins.items;

import net.arcmods.gamer.gamerorigins.Gamer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.DyeableItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class umbrella {
    public static final umbrellaDyeTest UMBRELLA = new umbrellaDyeTest(new FabricItemSettings().group(ItemGroup.MISC).maxCount(1).maxDamage(1200));


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Gamer.MOD_ID, "umbrella"), UMBRELLA);

    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayers() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (tintIndex > 0) ? -1 : ((DyeableItem) stack.getItem()).getColor(stack), UMBRELLA);
    }
}
