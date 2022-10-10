package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLiveTrainDetails.class)
@JsonDeserialize(as = ImmutableLiveTrainDetails.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LiveTrainDetails {
	String trainNumber();

	String trainName();

	int distanceCovered();

	String startDate();

	String startDayDifference();

	String startDay();

	boolean departed();

	StationInfo currentStation();

	boolean terminated();

	String totalJourney();

	int totalLateMinutes();
}
