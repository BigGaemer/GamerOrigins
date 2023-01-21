package net.arcmods.gamer.gamerorigins.client;

import net.arcmods.gamer.gamerorigins.items.umbrella;
import net.fabricmc.api.ClientModInitializer;

public class layerRenderer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        umbrella.registerRenderLayers();
    }
    
}
