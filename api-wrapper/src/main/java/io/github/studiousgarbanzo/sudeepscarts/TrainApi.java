package io.github.studiousgarbanzo.sudeepscarts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

import io.github.studiousgarbanzo.sudeepscarts.network.HttpSender;
import io.github.studiousgarbanzo.sudeepscarts.network.Route;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableTrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;

public class TrainApi {
	public static CompletableFuture<TrainsStatus> getTrains(String origin, String destination, LocalDate date) {
		TrainRequest request = ImmutableTrainRequest
				.builder()
				.srcStn(origin)
				.destStn(destination)
				.date(date.format(DateTimeFormatter.BASIC_ISO_DATE))
				.build();

		return HttpSender.performJsonRequest(Route.TRAINS, request, null, TrainsStatus.class);
	}
}
