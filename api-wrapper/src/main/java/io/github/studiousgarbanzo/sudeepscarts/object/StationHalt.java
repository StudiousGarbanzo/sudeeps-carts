package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStationHalt.class)
@JsonDeserialize(as = ImmutableStationHalt.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface StationHalt {
	StationInfo station();

	int haltMinutes();

	ArrivalDetails arrivalDetails();

	DepartureDetails departureDetails();

	DayDetails dayDetails();

	String journeyDate();

	StationMeta metaDetails();
}
