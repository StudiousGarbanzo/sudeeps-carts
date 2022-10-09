package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class LoadingScreen extends CottonClientScreen {
	LoadingScreen() {
		super(new Description());
		ScreenUtils.currentLoadingScreen = this;
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

	private static class Description extends FullscreenGuiDescription {
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
