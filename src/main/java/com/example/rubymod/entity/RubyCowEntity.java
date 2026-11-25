package com.example.rubymod.entity;

import com.example.rubymod.ModEntities;
import com.example.rubymod.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

/** Рубиновая корова: ведёт себя как корова, но время от времени "откладывает" рубин. */
public class RubyCowEntity extends CowEntity {
    private int rubyTimer;

    public RubyCowEntity(EntityType<? extends CowEntity> type, World world) {
        super(type, world);
        this.rubyTimer = this.random.nextInt(6000) + 6000; // 5–10 минут
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.getWorld().isClient && this.isAlive() && !this.isBaby() && --this.rubyTimer <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(ModItems.RUBY);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.rubyTimer = this.random.nextInt(6000) + 6000;
        }
    }

    @Override
    public RubyCowEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.RUBY_COW.create(world);
    }
}
