package com.example.rubymod;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item RUBY = register("ruby", new Item(new Item.Settings()));

    public static final Item MAGIC_APPLE = register("magic_apple", new Item(new Item.Settings()
            .rarity(Rarity.RARE)
            .food(new FoodComponent.Builder()
                    .nutrition(6)
                    .saturationModifier(1.2f)
                    .alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 1), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 0), 1.0f)
                    .build())));

    public static final Item RUBY_COW_SPAWN_EGG = register("ruby_cow_spawn_egg",
            new SpawnEggItem(ModEntities.RUBY_COW, 0xB3122B, 0xF2D6A0, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RubyMod.MOD_ID, name), item);
    }

    public static void register() {}
}
