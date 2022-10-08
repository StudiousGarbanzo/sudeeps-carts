package io.github.studiousgarbanzo.sudeepscarts.object;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.github.studiousgarbanzo.sudeepscarts.TrainApi;
import org.junit.jupiter.api.Test;

class TrainRequestTest {
	@Test
	public void apiTest() throws IOException, ExecutionException, InterruptedException {
		// We ignore some volatile mmt properties
//		ObjectMapper mapper = new ObjectMapper().registerModule(new Jdk8Module()).configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
//		ObjectWriter printer = new ObjectMapper().registerModule(new Jdk8Module()).writerWithDefaultPrettyPrinter(); // DEBUG
//
//		TrainRequest trainRequest = ImmutableTrainRequest.builder()
//				.date("20221029")
//				.destStn("NZM")
//				.srcStn("SBC")
//				.build();
//		String content = mapper.writeValueAsString(trainRequest);
//		HttpURLConnection conn = (HttpURLConnection) new URL("https://railways.makemytrip.com/api/trains").openConnection();
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/json");
//		conn.setRequestProperty("Content-Length", String.valueOf(content.length()));
//		conn.setDoOutput(true);
//		conn.getOutputStream().write(content.getBytes());
//		conn.connect();
//		printer.writeValueAsString(mapper.readValue(conn.getInputStream(), TrainsStatus.class));

 		TrainsStatus status = new TrainApi().getTrains("NZM", "SBC", LocalDate.now()).get();
		System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(status));
	}
}
