package com.juiceybeans.materialapi.common.item;

import com.juiceybeans.materialapi.api.Material;
import com.juiceybeans.materialapi.api.TagPrefix;

import lombok.Getter;
import lombok.Setter;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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

    @OnlyIn(Dist.CLIENT)
    public static ItemColor tintColor(Material material) {
        return ((itemStack, tintIndex) -> {
            if (tintIndex == 0) {
                return material.getColor();
            }
            return 0xFFFFFF; // No tint for other layers
        });
    }

    public String getUnlocalisedName() {
        return this.material.getName() + "_" + this.tagPrefix.getName();
    }
}
