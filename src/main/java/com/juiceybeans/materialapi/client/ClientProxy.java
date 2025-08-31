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
        for (var item : ModItems.PREFIX_ITEMS_BUILDER.build().values()) {
            event.register(TagPrefixItem.tintColor(item.get().getMaterial()), item.get());
        }
    }
}
