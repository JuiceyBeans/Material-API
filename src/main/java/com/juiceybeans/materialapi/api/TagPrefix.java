package com.juiceybeans.materialapi.api;

import com.juiceybeans.materialapi.common.util.LangUtil;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import lombok.Getter;
import lombok.Setter;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class TagPrefix {

    public final static Map<String, TagPrefix> PREFIXES = new HashMap<>();
    public static final Map<TagPrefix, OreType> ORES = new Object2ObjectLinkedOpenHashMap<>();

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String idPattern;
    @Getter
    @Setter
    private String langValue;
    @Getter
    @Setter
    private boolean generateItem;
    @Getter
    @Setter
    private boolean isIgnored;
    @Getter
    @Setter
    private IconSet iconSet;

    public TagPrefix(String name) {
        this.name = name;
        this.idPattern = "%s";
        this.langValue = "%s";
        this.generateItem = true;
        this.iconSet = IconSets.DEFAULT;
        PREFIXES.put(name, this);
    }

    public TagPrefix(Builder builder) {
        this.name = builder.name;
        this.idPattern = builder.idPattern;
        this.langValue = builder.langValue;
        this.generateItem = builder.generateItem;
        this.iconSet = builder.iconSet;
        PREFIXES.put(name, this);
    }

    public static final TagPrefix INGOT = new TagPrefix.Builder("ingot")
            .idPattern("%s_ingot")
            .langValue("%s Ingot")
            .build();

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

    public static class Builder {

        private final String name;
        private String idPattern;
        private String langValue;
        private boolean generateItem;
        private IconSet iconSet;

        public Builder(String name) {
            this.name = name;
            this.idPattern = "%s_" + name;
            this.langValue = "%s" + LangUtil.formatToEnglishLocalization(name);
            this.generateItem = true;
            this.iconSet = IconSets.DEFAULT;
        }

        public Builder idPattern(String idPattern) {
            this.idPattern = idPattern;
            return this;
        }

        public Builder langValue(String langValue) {
            this.langValue = langValue;
            return this;
        }

        public Builder generateItem(boolean generateItem) {
            this.generateItem = generateItem;
            return this;
        }

        public Builder iconSet(IconSet iconSet) {
            this.iconSet = iconSet;
            return this;
        }

        public TagPrefix build() {
            return new TagPrefix(this);
        }
    }

    public static final TagPrefix NULL_PREFIX = new TagPrefix.Builder("null")
            .generateItem(false)
            .build();

    public static TagPrefix get(String name) {
        return PREFIXES.get(name);
    }

    public static Collection<TagPrefix> values() {
        return PREFIXES.values();
    }

    public boolean isEmpty() {
        return this == NULL_PREFIX;
    }

    public boolean doGenerateItem() {
        return generateItem;
    }

    public boolean doGenerateItem(Material material) {
        return generateItem;
    }

    public record OreType(Supplier<BlockState> stoneType, Supplier<Material> material,
                          Supplier<BlockBehaviour.Properties> inheritProperties, ResourceLocation baseModelLocation,
                          boolean dropAsItem) {}

    public record BlockProperties(Supplier<Supplier<RenderType>> renderType,
                                  UnaryOperator<BlockBehaviour.Properties> properties) {}
}
