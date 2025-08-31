package com.juiceybeans.materialapi.data.datagen;

import com.juiceybeans.materialapi.Main;
import com.juiceybeans.materialapi.common.item.ModItems;
import com.juiceybeans.materialapi.common.item.TagPrefixItem;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Main.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            if (item.get() instanceof TagPrefixItem tagPrefixItem) {
                prefixItem(tagPrefixItem);
            } else simpleItem(item);
        }
    }

    private static void checkExisting(ExistingFileHelper existingFileHelper, ResourceLocation texture,
                                      TagPrefixItem item) {}

    private ItemModelBuilder prefixItem(TagPrefixItem item) {
        var iconSet = item.getMaterial().getIconSet();
        var texturePath = Main.id("item/icon_set/" + iconSet.getName() + "/" +
                item.getTagPrefix().getName());

        if (!existingFileHelper.exists(texturePath, ModelProvider.TEXTURE)) {
            iconSet = item.getMaterial().getIconSet().getParentIconSet();
            texturePath = Main.id("item/icon_set/" + iconSet.getName() + "/" +
                    item.getTagPrefix().getName());
        }

        return withExistingParent(item.getUnlocalisedName(),
                new ResourceLocation("item/generated")).texture("layer0", texturePath);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                        Main.id("item/" + itemRegistryObject.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> itemRegistryObject) {
        return withExistingParent(itemRegistryObject.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                        Main.id("item/" + itemRegistryObject.getId().getPath()));
    }
}
