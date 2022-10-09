package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import net.minecraft.client.MinecraftClient;

public final class ScreenUtils {
	static LoadingScreen currentLoadingScreen = null;

	public static void openSearchScreen() {
		MinecraftClient.getInstance().setScreen(new SudeepsCartsClientScreen(new TrainSearchDescription()));
	}

	public static void openLoadingScreen() {
		MinecraftClient.getInstance().setScreen(new LoadingScreen());
	}
}
