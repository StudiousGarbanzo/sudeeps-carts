package io.github.boogiemonster1o1.sudeepscarts.client.gui;

import java.util.Arrays;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainBetweenStations;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;
import org.lwjgl.glfw.GLFW;

import net.minecraft.text.Text;

public class TrainResultsDescription extends FullscreenGuiDescription {
	private final TrainsStatus status;
	private int hMax = 20;

	public TrainResultsDescription(TrainsStatus status) {
		super();
		this.status = status;
		WPlainPanel root = new WPlainPanel();
		this.setRootPanel(root);

		root.add(new WLabel(Text.translatable("gui.sudeepscarts.train_results.title")), 20, 20);

		WListPanel<TrainBetweenStations, WTrainElement> trainList = new WListPanel<>(Arrays.asList(status.trainsBetweenStations()), WTrainElement::new, (data, widget) -> widget.configure(data));
		trainList.layout();
		trainList.setListItemHeight(hMax);
		trainList.layout();
		root.add(trainList, 20, 40, 400, hMax * 2 + 10);

		root.validate(this);
	}

	public class WTrainElement extends WPlainPanel {
		public WTrainElement() {
			this.setBackgroundPainter(BackgroundPainter.createColorful(0x33000000));
			this.setInsets(Insets.ROOT_PANEL);
		}

		public void configure(TrainBetweenStations train) {
			this.add(new WLabel(Text.literal(train.trainName())), 0, 0);
			Text departure = Text.of("Departure: " + train.fromStationName() + " - " + train.departureTime12hFormat() + " " + train.departureMeridiem() + ", " + train.fromDay());
			this.add(new WLabel(departure), 0, 15);
			Text arrival = Text.of("Arrival: " + train.toStationName() + " - " + train.arrivalTime12hFormat() + " " + train.arrivalMeridiem() + ", " + train.toDay());
			this.add(new WLabel(arrival), 0, 25);
			Text time = Text.of("Duration: " + train.durationHours() + ":" + train.durationMinutes());
			this.add(new WLabel(time), 0, 35);
			this.layout();
			TrainResultsDescription.this.hMax = Math.max(TrainResultsDescription.this.hMax, this.getHeight());
			this.setSize(this.getWidth(), TrainResultsDescription.this.hMax);
		}
	}

	public static class TrainResultsScreen extends CottonClientScreen {
		public TrainResultsScreen(TrainsStatus status) {
			super(new TrainResultsDescription(status));
		}

		@Override
		public boolean keyPressed(int ch, int keyCode, int modifiers) {
			if (ch == GLFW.GLFW_KEY_ESCAPE) {
				ScreenUtils.openSearchScreen();
				return true;
			}
			return super.keyPressed(ch, keyCode, modifiers);
		}
	}
}
