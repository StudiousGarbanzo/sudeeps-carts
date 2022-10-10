package io.github.studiousgarbanzo.sudeepscarts.object;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.github.studiousgarbanzo.sudeepscarts.TrainApi;
import org.junit.jupiter.api.Test;

class TrainRequestTest {
	@Test
	public void apiTest() throws IOException {
		ObjectWriter printer = new ObjectMapper().registerModule(new Jdk8Module()).writerWithDefaultPrettyPrinter(); // DEBUG

 		TrainsStatus status = TrainApi.getTrains("KLBG", "SBC", LocalDate.now()).block();
		System.out.println(printer.writeValueAsString(status));
	}
}
