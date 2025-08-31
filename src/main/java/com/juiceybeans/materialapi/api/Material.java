package com.juiceybeans.materialapi.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Material {

    public final static Map<String, Material> MATERIALS = new HashMap<>();

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int color;

    public Material(String name) {
        this.name = name;
        this.color = 0xFFFFFF;
        MATERIALS.put(name, this);
    }

    public Material(String name, int color) {
        this.name = name;
        this.color = color;
        MATERIALS.put(name, this);
    }

    public static Material get(String name) {
        return MATERIALS.get(name);
    }

    public static Collection<Material> values() {
        return MATERIALS.values();
    }
}
