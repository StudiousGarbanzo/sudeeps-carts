package io.github.studiousgarbanzo.sudeepscarts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.github.studiousgarbanzo.sudeepscarts.object.ImmutableTrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainRequest;
import io.github.studiousgarbanzo.sudeepscarts.object.TrainsStatus;

import javax.swing.text.html.Option;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class TrainApi {
    private static final String API_ROOT = "https://railways.makemytrip.com/api";

    private final HttpClient CLIENT = HttpClient
            .newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    private final ObjectMapper MAPPER = new ObjectMapper().registerModule(new Jdk8Module()).configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    public CompletableFuture<TrainsStatus> getTrains(String origin, String destination, LocalDate date) {
        TrainRequest request = ImmutableTrainRequest
                .builder()
                .srcStn(origin)
                .destStn(destination)
                .date(date.format(DateTimeFormatter.BASIC_ISO_DATE))
                .build();

        try {
            String requestJson = MAPPER.writer().writeValueAsString(request);

            return performJsonRequest("/trains", HttpVerb.POST, Optional.of(requestJson))
                    .thenApply(s -> {
                        try {
                            return MAPPER.readValue(s, TrainsStatus.class);
                        } catch (JsonProcessingException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private CompletableFuture<String> performJsonRequest(String endpoint, HttpVerb verb, Optional<String> payload) {
        HttpRequest.Builder requestBuilder = HttpRequest
                .newBuilder()
                .uri(URI.create(API_ROOT + "/trains"))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0 SeaMonkey/2.40");

        switch(verb) {
            case GET:
                requestBuilder.GET();
                break;
            case POST:
                requestBuilder.POST(HttpRequest.BodyPublishers.ofString(payload.orElseThrow()));
                break;
            case DELETE:
                requestBuilder.DELETE();
        }

        return CLIENT.sendAsync(requestBuilder.build(), HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

    private enum HttpVerb {
        GET,
        POST,
        DELETE
    }
}


