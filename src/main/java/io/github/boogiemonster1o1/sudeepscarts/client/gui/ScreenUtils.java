package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import java.time.LocalDate;

import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;

import net.minecraft.client.MinecraftClient;

public final class ScreenUtils {
	static LoadingScreen currentLoadingScreen = null;

	public static void openSearchScreen() {
		MinecraftClient.getInstance().setScreen(new SudeepsCartsClientScreen(new TrainSearchDescription()));
	}

	public static void openLoadingScreen(String src, String dest, LocalDate date) {
		MinecraftClient.getInstance().setScreen(new LoadingScreen(src, dest, date));
	}

	public static void openResultsScreen(TrainsStatus status) {
		MinecraftClient.getInstance().setScreen(new TrainResultsDescription.TrainResultsScreen(status));
	}
}
