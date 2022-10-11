package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import java.time.LocalDate;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.studiousgarbanzo.sudeepscarts.TrainApi;
import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

public class LoadingScreen extends CottonClientScreen {
	LoadingScreen(String src, String dest, LocalDate date) {
		super(new Description());
		ScreenUtils.currentLoadingScreen = this;
		TrainApi.getTrains(src, dest, date)
				.doOnError(t -> {
					MinecraftClient client = MinecraftClient.getInstance();
					client.execute(() -> {
						if (client.currentScreen instanceof LoadingScreen) {
							ScreenUtils.openSearchScreen();
						}
						client.getToastManager().add(new SystemToast(SystemToast.Type.UNSECURE_SERVER_WARNING, Text.translatable("Error searching Trains"), null)); // TODO
					});
				})
				.subscribe(status -> {
					MinecraftClient client = MinecraftClient.getInstance();
					client.execute(() -> ScreenUtils.openResultsScreen(status));
				});
	}

	@Override
	public boolean keyPressed(int ch, int keyCode, int modifiers) {
		if (ch == GLFW.GLFW_KEY_ESCAPE) {
			ScreenUtils.openSearchScreen();
			return true;
		}
		return super.keyPressed(ch, keyCode, modifiers);
	}

	@Override
	public void removed() {
		super.removed();
		ScreenUtils.currentLoadingScreen = null;
	}

	private static class Description extends LightweightGuiDescription {
		Description() {
			super();
			WPlainPanel rootPanel = new WPlainPanel();
			this.setRootPanel(rootPanel);

			Text loadingText = Text.translatable("sudeepscarts.gui.loading");
			int width = MinecraftClient.getInstance().textRenderer.getWidth(loadingText);
			rootPanel.setSize(100, 30);
			WLabel loading = new WLabel(loadingText);
			rootPanel.add(loading, rootPanel.getWidth() / 2 - width / 2, rootPanel.getHeight() / 2 - 5);
		}
	}
}
