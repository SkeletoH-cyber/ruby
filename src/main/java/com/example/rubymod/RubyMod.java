package com.example.rubymod;

import net.fabricmc.api.ModInitializer;

public class RubyMod implements ModInitializer {
    public static final String MOD_ID = "rubymod";

    @Override
    public void onInitialize() {
        ModEntities.register();
        ModItems.register();
        ModBlocks.register();
        ModItemGroup.register();
    }
}
