package io.github.studiousgarbanzo.sudeepscarts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import io.github.studiousgarbanzo.sudeepscarts.network.HttpSender;
import io.github.studiousgarbanzo.sudeepscarts.network.Route;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableLiveStatusRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableTrackingParams;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableTrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.LiveStatusRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.LiveTrainStatus;
import io.github.studiousgarbanzo.sudeepscarts.object.StationSearchResult;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TrainApi {
	public static final DateTimeFormatter YOCTOCHAD_DATE = new DateTimeFormatterBuilder()
			.appendValue(ChronoField.DAY_OF_MONTH, 2)
			.appendLiteral('-')
			.appendValue(ChronoField.MONTH_OF_YEAR, 2)
			.appendLiteral('-')
			.appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
			.toFormatter();

	public static Mono<TrainsStatus> getTrains(String origin, String destination, LocalDate date) {
		TrainRequest request = ImmutableTrainRequest
				.builder()
				.srcStn(origin)
				.destStn(destination)
				.date(date.format(DateTimeFormatter.BASIC_ISO_DATE))
				.build();

		return HttpSender.performJsonRequest(Route.TRAINS, request, null, TrainsStatus.class);
	}

	public static Flux<StationSearchResult> searchStations(String query) {
		return HttpSender.performJsonRequestJson(Route.TRAIN_SEARCH, null, Map.of("query", query))
				.flatMapIterable(node -> node.get("data").get("r"))
				.map(node -> {
					try {
						return HttpSender.MAPPER.treeToValue(node, StationSearchResult.class);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				});
	}

	public static Mono<LiveTrainStatus> getLiveStatus(String trainNumber, LocalDate dateOfJourney) {
		LiveStatusRequest req = ImmutableLiveStatusRequest.builder()
				.trainNumber(trainNumber)
				.dateOfJourney(dateOfJourney.format(YOCTOCHAD_DATE))
				.trackingParams(
						ImmutableTrackingParams.builder()
								.affiliateCode("MMT001")
								.channelCode("WEB")
								.build()
				)
				.build();

		return HttpSender.performJsonRequest(Route.LIVE_TRAIN_STATUS, req, null, LiveTrainStatus.class);
	}
}
