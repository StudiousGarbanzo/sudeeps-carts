package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

public abstract class FullscreenGuiDescription extends LightweightGuiDescription {
	public FullscreenGuiDescription() {
		this.setFullscreen(true);
	}
}
