package com.example.rubymod;

import com.example.rubymod.entity.RubyCowEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntities {
    public static final EntityType<RubyCowEntity> RUBY_COW = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(RubyMod.MOD_ID, "ruby_cow"),
            EntityType.Builder.create(RubyCowEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f, 1.4f)
                    .maxTrackingRange(10)
                    .build("ruby_cow"));

    public static void register() {
        FabricDefaultAttributeRegistry.register(RUBY_COW, RubyCowEntity.createCowAttributes());

        SpawnRestriction.register(RUBY_COW, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.MEADOW, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST),
                SpawnGroup.CREATURE, RUBY_COW, 6, 2, 4);
    }
}
