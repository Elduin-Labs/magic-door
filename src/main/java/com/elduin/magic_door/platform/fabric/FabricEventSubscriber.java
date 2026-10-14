package com.elduin.magic_door.platform.fabric;

//? fabric {

import com.elduin.magic_door.ModBlocks;
//? if <26.2 {
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//?} else {
/*import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
*///?}
import net.minecraft.world.item.CreativeModeTabs;

public class FabricEventSubscriber {

	public static void registerEvents() {
		//? if <26.2 {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register(entries -> entries.accept(ModBlocks.MAGIC_DOOR));
		//?} else {
		/*CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register(output -> output.accept(ModBlocks.MAGIC_DOOR));
		*///?}
	}
}
//?}
