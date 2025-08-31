package com.juiceybeans.materialapi.common.util;

import com.juiceybeans.materialapi.api.Material;
import com.juiceybeans.materialapi.api.TagPrefix;
import com.juiceybeans.materialapi.common.item.ModItems;
import com.juiceybeans.materialapi.common.item.TagPrefixItem;

public class MaterialHelper {

    public static TagPrefixItem getPrefixItem(TagPrefix tagPrefix, Material material) {
        return ModItems.MATERIAL_ITEMS_BUILDER.build().get(tagPrefix, material).get();
    }

    public static TagPrefixItem getPrefixItem(Material material, TagPrefix tagPrefix) {
        return getPrefixItem(tagPrefix, material);
    }
}
