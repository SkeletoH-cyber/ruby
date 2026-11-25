package com.example.rubymod.client;

import com.example.rubymod.RubyMod;
import com.example.rubymod.entity.RubyCowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CowEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class RubyCowRenderer extends MobEntityRenderer<RubyCowEntity, CowEntityModel<RubyCowEntity>> {
    private static final Identifier TEXTURE = Identifier.of(RubyMod.MOD_ID, "textures/entity/ruby_cow.png");

    public RubyCowRenderer(EntityRendererFactory.Context context) {
        super(context, new CowEntityModel<>(context.getPart(EntityModelLayers.COW)), 0.7f);
    }

    @Override
    public Identifier getTexture(RubyCowEntity entity) {
        return TEXTURE;
    }
}
