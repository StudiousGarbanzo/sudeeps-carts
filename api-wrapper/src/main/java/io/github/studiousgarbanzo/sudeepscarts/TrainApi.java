package io.github.studiousgarbanzo.sudeepscarts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import io.github.studiousgarbanzo.sudeepscarts.network.HttpSender;
import io.github.studiousgarbanzo.sudeepscarts.network.Route;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableTrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.StationSearchResult;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TrainApi {
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
		return HttpSender.performJsonRequest(Route.TRAIN_SEARCH, null, Map.of("search_query", query))
				.map(HttpSender::toJsonNode)
				.flatMapIterable(node -> node.get("data").get("r"))
				.map(node -> {
					try {
						return HttpSender.MAPPER.treeToValue(node, StationSearchResult.class);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				});
	}
}
