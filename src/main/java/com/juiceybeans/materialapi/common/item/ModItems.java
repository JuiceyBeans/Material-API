package com.juiceybeans.materialapi.common.item;

import com.juiceybeans.materialapi.Main;
import com.juiceybeans.materialapi.api.Material;
import com.juiceybeans.materialapi.api.TagPrefix;

import com.google.common.collect.ImmutableTable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static ImmutableTable.Builder<TagPrefix, Material, RegistryObject<TagPrefixItem>> MATERIAL_ITEMS_BUILDER = ImmutableTable
            .builder();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", () -> new Item(
            new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static void register(IEventBus eventBus) {
        generateMaterialItems();
        ITEMS.register(eventBus);
    }

    public static void generateMaterialItems() {
        for (var tagPrefix : TagPrefix.values()) {
            if (tagPrefix.doGenerateItem()) {
                for (var material : Material.values()) {
                    generateMaterialItem(tagPrefix, material);
                }
            }
        }
    }

    private static void generateMaterialItem(TagPrefix tagPrefix, Material material) {
        var item = ModItems.ITEMS.register((material.getName() + "_" + tagPrefix.getName()), () -> new TagPrefixItem(
                tagPrefix, material, new Item.Properties()));

        MATERIAL_ITEMS_BUILDER.put(tagPrefix, material, item);
        Main.LOGGER.debug("Generated prefix item {}", (material.getName() + "_" + tagPrefix.getName()));
    }
}
