package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

import net.minecraft.text.Text;

public class SudeepsCartsClientScreen extends CottonClientScreen {
	public static final Text TITLE = Text.translatable("sudeepscarts.gui.title");

	public SudeepsCartsClientScreen(GuiDescription description) {
		super(TITLE, description);
	}
}
