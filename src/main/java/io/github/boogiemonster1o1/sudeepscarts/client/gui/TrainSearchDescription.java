package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

import net.minecraft.text.Text;

public class TrainSearchDescription extends LightweightGuiDescription {
	public static final DateTimeFormatter CHAD_DATE = new DateTimeFormatterBuilder()
			.appendValue(ChronoField.DAY_OF_MONTH, 2)
			.appendLiteral('/')
			.appendValue(ChronoField.MONTH_OF_YEAR, 2)
			.appendLiteral('/')
			.appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
			.toFormatter();
	private boolean validDate = true;
	private boolean validSource = true; // TODO
	private boolean validDest = true; // TODO

	public TrainSearchDescription() {
		super();
		this.setFullscreen(false);
		WGridPanel rootPanel = new WGridPanel(10);
		this.setRootPanel(rootPanel);

		WLabel sourceLabel = new WLabel(Text.translatable("sudeepscarts.gui.source"));
		rootPanel.add(sourceLabel, 0, 4);

		WTextField sourceField = new WTextField();
		rootPanel.add(sourceField, 0, 5, 14, 1);

		WLabel destinationLabel = new WLabel(Text.translatable("sudeepscarts.gui.destination"));
		rootPanel.add(destinationLabel, 0, 9);

		WTextField destinationField = new WTextField();
		rootPanel.add(destinationField, 0, 10, 14, 1);

		WLabel dateLabel = new WLabel(Text.translatable("sudeepscarts.gui.date"));
		rootPanel.add(dateLabel, 0, 14);

		WTextField dateField = new WTextField();
		rootPanel.add(dateField, 0, 15, 14, 1);
		dateField.setChangedListener(str -> {
			try {
				LocalDate date = LocalDate.from(CHAD_DATE.parse(str));
				if (date.isBefore(LocalDate.now())) {
					throw new RuntimeException();
				}
				dateField.setEnabledColor(0x07B307);
				validDate = true;
			} catch (Exception e) {
				dateField.setEnabledColor(0xFF0000);
				validDate = false;
			}
		});
		dateField.setText(LocalDate.now().format(CHAD_DATE));

		WButton checkButton = new WButton(Text.translatable("sudeepscarts.gui.check")) {
			@Override
			public void tick() {
				super.tick();
				this.setEnabled(validDate && validSource && validDest);
			}
		};
		rootPanel.add(checkButton, 0, 20, 14, 1);
		checkButton.setOnClick(ScreenUtils::openLoadingScreen);
		rootPanel.setInsets(new Insets(15));

		rootPanel.validate(this);
	}
}
