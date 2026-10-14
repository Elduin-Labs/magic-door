package com.elduin.magic_door;

import java.util.function.Consumer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.BlockHitResult;

/** A door that "teleports" you to a website when you open it. */
public class MagicDoor extends DoorBlock {

	public static final String WEBSITE = "https://neoforged.net";

	/** Set by the client side. Shows Minecraft's "open this link?" screen. Does nothing on a server. */
	public static Consumer<String> openWebsite = url -> {
	};

	public MagicDoor(BlockSetType type, Properties properties) {
		super(type, properties);
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
		boolean opening = !state.getValue(OPEN);
		InteractionResult result = super.useWithoutItem(state, level, pos, player, hit);
		if (!opening) {
			return result;
		}

		if (level instanceof ServerLevel serverLevel) {
			serverLevel.sendParticles(ParticleTypes.PORTAL, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
					80, 0.4, 0.8, 0.4, 0.5);
			serverLevel.playSound(null, pos, SoundEvents.ENDERMAN_TELEPORT, SoundSource.BLOCKS, 1.0f, 1.2f);
		} else {
			openWebsite.accept(WEBSITE);
		}
		return result;
	}
}
