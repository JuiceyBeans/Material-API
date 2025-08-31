package com.juiceybeans.materialapi.data.datagen;

import com.juiceybeans.materialapi.Main;
import com.juiceybeans.materialapi.common.item.ModItems;
import com.juiceybeans.materialapi.common.util.LangUtil;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public abstract class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output, String locale) {
        super(output, Main.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            addItem(item, LangUtil.formatToEnglishLocalization(item.getId().getPath()));
        }

        addLang();
    }

    private void addLang() {
        // add("itemGroup.materialapi.test_key", "Test Key");
    }
}
