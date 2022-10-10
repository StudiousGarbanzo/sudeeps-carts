package io.github.studiousgarbanzo.sudeepscarts.object;

import io.github.studiousgarbanzo.sudeepscarts.TrainApi;
import org.junit.jupiter.api.Test;

class StationSearchResultTest {
	@Test
	public void test() {
		TrainApi.searchStations("kjm").toStream().forEach(System.out::println);
	}
}
