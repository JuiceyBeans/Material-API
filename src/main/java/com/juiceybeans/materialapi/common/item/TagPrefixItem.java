package com.juiceybeans.materialapi.common.item;

import com.juiceybeans.materialapi.api.Material;
import com.juiceybeans.materialapi.api.TagPrefix;

import lombok.Getter;
import lombok.Setter;

import net.minecraft.world.item.Item;

public class TagPrefixItem extends Item {

    @Getter
    @Setter
    private Material material;
    @Getter
    @Setter
    private TagPrefix tagPrefix;

    public TagPrefixItem(TagPrefix tagPrefix, Material material, Properties properties) {
        super(properties);
        this.tagPrefix = tagPrefix;
        this.material = material;
    }

    // @Override
    // public Component getName(ItemStack pStack) {
    // return Component.translatable("item.materialapi." + getId());
    // }

    public String getId() {
        return this.material.getName() + "_" + this.tagPrefix.getName();
    }
}
