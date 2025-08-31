package com.juiceybeans.materialapi.common.item;

import com.juiceybeans.materialapi.api.Material;
import com.juiceybeans.materialapi.api.TagPrefix;
import com.juiceybeans.materialapi.common.util.LangUtil;

import lombok.Getter;
import lombok.Setter;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.materialapi.prefix_item",
                LangUtil.formatToEnglishLocalization(this.getMaterial().getName()),
                LangUtil.formatToEnglishLocalization(this.getTagPrefix().getName()));
    }

    public String getUnlocalisedName() {
        return this.material.getName() + "_" + this.tagPrefix.getName();
    }
}
