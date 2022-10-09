package io.github.studiousgarbanzo.sudeepscarts.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public class HttpSender {
	private static final HttpClient CLIENT = HttpClient
			.newBuilder()
			.version(HttpClient.Version.HTTP_2)
			.followRedirects(HttpClient.Redirect.NORMAL)
			.build();
	public static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new Jdk8Module()).configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

	public static <T> CompletableFuture<T> performJsonRequest(Route route, Object payloadObj, Map<String, String> parameters, Class<T> mappingClass) {
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
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0 SeaMonkey/2.40");

		switch (route.method()) {
			case GET -> requestBuilder.GET();
			case POST -> requestBuilder.POST(HttpRequest.BodyPublishers.ofString(Objects.requireNonNull(payload)));
			case DELETE -> requestBuilder.DELETE();
		}

		return CLIENT.sendAsync(requestBuilder.build(), HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenApply(s -> {
					try {
						return MAPPER.readValue(s, mappingClass);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				});
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
