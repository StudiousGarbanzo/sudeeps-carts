package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;

import net.minecraft.text.Text;

public class TrainSearchDescription extends FullscreenGuiDescription {
	public TrainSearchDescription() {
		this.setFullscreen(true);
		WGridPanel rootPanel = new WGridPanel();
		this.setRootPanel(rootPanel);

		WLabel sourceLabel = new WLabel(Text.translatable("sudeepscarts.gui.source"));
		rootPanel.add(sourceLabel, 0, 3);

		WTextField sourceField = new WTextField();
		rootPanel.add(sourceField, 1, 4, 5, 1);

		WLabel destinationLabel = new WLabel(Text.translatable("sudeepscarts.gui.destination"));
		rootPanel.add(destinationLabel, 0, 7);

		WTextField destinationField = new WTextField();
		rootPanel.add(destinationField, 1, 8, 5, 1);

		WLabel dateLabel = new WLabel(Text.translatable("sudeepscarts.gui.date"));
		rootPanel.add(dateLabel, 0, 11);

		WTextField dateField = new WTextField();
		rootPanel.add(dateField, 1, 12, 5, 1);

		rootPanel.validate(this);
	}
}
