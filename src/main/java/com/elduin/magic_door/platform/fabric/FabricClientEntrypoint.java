package com.elduin.magic_door.platform.fabric;

//? fabric {

import com.elduin.magic_door.MagicDoor;
import com.elduin.magic_door.ModTemplate;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ModTemplate.onInitializeClient();
		// No screen is open when you click a door, so there is nothing to go back to afterwards.
		MagicDoor.openWebsite = url -> Minecraft.getInstance().execute(() -> ConfirmLinkScreen.confirmLinkNow(null, url));
	}

}
//?}
