package com.juiceybeans.materialapi.api;

import com.juiceybeans.materialapi.common.IconSets;

import lombok.Getter;
import lombok.Setter;

public class IconSet {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private IconSet parentIconSet = IconSets.DEFAULT;

    public IconSet(String name) {
        this.name = name;
    }

    public IconSet(String name, IconSet parentIconSet) {
        this.name = name;
        this.parentIconSet = parentIconSet;
    }
}
