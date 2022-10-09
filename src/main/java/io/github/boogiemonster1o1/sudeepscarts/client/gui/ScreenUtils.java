package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import net.minecraft.client.MinecraftClient;

public final class ScreenUtils {
	public static void openSearchScreen() {
		MinecraftClient.getInstance().setScreen(new SudeepsCartsClientScreen(new TrainSearchDescription()));
	}
}
