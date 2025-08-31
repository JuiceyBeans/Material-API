package com.juiceybeans.materialapi.common.material;

import com.juiceybeans.materialapi.api.TagPrefix;

public class TagPrefixes {

    public static final TagPrefix PLATE = new TagPrefix.Builder("plate")
            .idPattern("%s_plate")
            .langValue("%s Plate")
            .build();

    public static final TagPrefix GEAR = new TagPrefix.Builder("gear")
            .idPattern("%s_gear")
            .langValue("%s Gear")
            .build();

    public static final TagPrefix ROD = new TagPrefix.Builder("rod")
            .idPattern("%s_rod")
            .langValue("%s Rod")
            .build();
}
