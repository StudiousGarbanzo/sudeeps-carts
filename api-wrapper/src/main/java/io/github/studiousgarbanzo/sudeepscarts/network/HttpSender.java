package io.github.studiousgarbanzo.sudeepscarts.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import reactor.core.publisher.Mono;

public class HttpSender {
	private static final HttpClient CLIENT = HttpClient
			.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL)
			.build();
	public static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new Jdk8Module()).configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

	public static Mono<JsonNode> performJsonRequestJson(Route route, Object payloadObj, Map<String, String> parameters) {
		return performJsonRequest(route, payloadObj, parameters).map(body -> {
			try {
				return MAPPER.readTree(body);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		});
	}

	public static <T> Mono<T> performJsonRequest(Route route, Object payloadObj, Map<String, String> parameters, Class<T> mappingClass) {
		return performJsonRequest(route, payloadObj, parameters)
				.map(body -> {
					try {
						return MAPPER.readValue(body, mappingClass);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				});
	}

	public static Mono<String> performJsonRequest(Route route, Object payloadObj, Map<String, String> parameters) {
		String payload;

		if (payloadObj instanceof String) {
			payload = (String) payloadObj;
		} else if (payloadObj == null) {
			payload = null;
		} else {
			try {
				payload = MAPPER.writeValueAsString(payloadObj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		HttpRequest.Builder requestBuilder = HttpRequest
				.newBuilder()
				.uri(URI.create(formatUrl(route.url(), parameters)))
				.header("Content-Type", "application/json")
				.header("User-Agent", "curl/7.54");

		switch (route.method()) {
			case GET -> requestBuilder.GET();
			case POST -> requestBuilder.POST(HttpRequest.BodyPublishers.ofString(Objects.requireNonNull(payload)));
			case DELETE -> requestBuilder.DELETE();
		}

		return Mono.fromFuture(CLIENT.sendAsync(requestBuilder.build(), HttpResponse.BodyHandlers.ofString()))
				.map(HttpResponse::body);
	}

	public static <T> String formatUrl(String url, Map<String, String> parameters) {
		if (parameters == null) {
			return url;
		}
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			url = url.replace("{" + entry.getKey() + "}", entry.getValue());
		}
		return url;
	}
}
