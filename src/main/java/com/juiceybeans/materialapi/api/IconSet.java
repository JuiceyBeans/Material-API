package com.juiceybeans.materialapi.api;

import lombok.Getter;
import lombok.Setter;

public class IconSet {
    @Getter
    @Setter
    private String name;

    public IconSet(String name) {
        this.name = name;
    }
}
