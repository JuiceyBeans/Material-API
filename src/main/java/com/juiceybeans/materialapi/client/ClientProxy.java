package com.juiceybeans.materialapi.client;

import com.juiceybeans.materialapi.Main;
import com.juiceybeans.materialapi.common.item.ModItems;
import com.juiceybeans.materialapi.common.item.TagPrefixItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        for (var item : ModItems.MATERIAL_ITEMS_BUILDER.build().values()) {
            if (item.get() instanceof TagPrefixItem tagPrefixItem) {
                event.register(
                        TagPrefixItem.tintColor(tagPrefixItem.getMaterial()),
                        tagPrefixItem
                );
            }
        }
    }
}
