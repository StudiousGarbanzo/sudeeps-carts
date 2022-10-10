package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableDepartureDetails.class)
@JsonDeserialize(as = ImmutableDepartureDetails.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface DepartureDetails {
	String actualDepartureDate();

	String scheduledDepartureDate();

	String actualDepartureTime();

	String scheduledDepartureTime();

	Optional<Boolean> departed();

	int departureDelay();
}
