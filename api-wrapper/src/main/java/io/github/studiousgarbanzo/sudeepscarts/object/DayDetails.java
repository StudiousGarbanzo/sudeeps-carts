package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDayDetails.class)
@JsonDeserialize(as = ImmutableDayDetails.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DayDetails {
	int dayCount();

	int scheduledDayCount();

	String dayDifference();
}
