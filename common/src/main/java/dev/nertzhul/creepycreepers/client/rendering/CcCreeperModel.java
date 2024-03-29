package dev.nertzhul.creepycreepers.client.rendering;

import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

import org.jetbrains.annotations.NotNull;
import java.util.function.Function;

public abstract class CcCreeperModel<T extends Creeper> extends HierarchicalModel<T> {
    private final ModelPart root;
    
    protected CcCreeperModel(ModelPart pRoot) {
        this (pRoot, RenderType::entityCutoutNoCull);
    }
    
    protected CcCreeperModel(ModelPart pRoot, Function<ResourceLocation, RenderType> renderType) {
        super(renderType);
        this.root = pRoot;
    }
    
    public static LayerDefinition createBodyLayer() {
        return CreeperModel.createBodyLayer(CubeDeformation.NONE);
    }
    
    @Override @NotNull
    public ModelPart root() {
        return this.root;
    }
}
