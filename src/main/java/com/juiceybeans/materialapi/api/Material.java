package com.juiceybeans.materialapi.api;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Material {

    public static final Map<String, Material> MATERIALS = new HashMap<>();

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int color = 0xFFFFFF;
    @Getter
    @Setter
    private IntList colors = IntArrayList.of(-1, 1);
    @Getter
    @Setter
    private IconSet iconSet;

    public Material(String name) {
        this.name = name;
        this.iconSet = IconSets.DEFAULT;
        MATERIALS.put(name, this);
    }

    public Material(String name, int color) {
        this.name = name;
        this.iconSet = IconSets.DEFAULT;
        this.color = color;
        MATERIALS.put(name, this);
    }

    public Material(String name, int color, IconSet iconSet) {
        this.name = name;
        this.iconSet = iconSet;
        this.color = color;
        MATERIALS.put(name, this);
    }

    public static final Material SCHRABIDIUM = new Material("schrabidium", 0xad3931);
    public static final Material JUICY_IRON = new Material("juicy_iron", 0x5d7da3, IconSets.METALLIC);

    public static Material get(String name) {
        return MATERIALS.get(name);
    }

    public static Collection<Material> values() {
        return MATERIALS.values();
    }
}
