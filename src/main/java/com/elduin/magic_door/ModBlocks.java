package com.elduin.magic_door;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public final class ModBlocks {

	public static final Block MAGIC_DOOR = registerDoor("magic_door");

	private ModBlocks() {
	}

	private static Block registerDoor(String name) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, ModTemplate.id(name));
		Block door = Registry.register(BuiltInRegistries.BLOCK, blockKey, new MagicDoor(BlockSetType.OAK,
				BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).lightLevel(state -> 7).setId(blockKey)));

		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, ModTemplate.id(name));
		Registry.register(BuiltInRegistries.ITEM, itemKey,
				new DoubleHighBlockItem(door, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
		return door;
	}

	/** Touching this class registers everything in it. */
	public static void init() {
	}
}
