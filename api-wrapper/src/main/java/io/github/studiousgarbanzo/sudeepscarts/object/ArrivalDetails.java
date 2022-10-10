package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableArrivalDetails.class)
@JsonDeserialize(as = ImmutableArrivalDetails.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ArrivalDetails {
	String actualArrivalDate();

	String scheduledArrivalDate();

	String actualArrivalTime();

	String scheduledArrivalTime();

	Optional<Boolean> arrived();

	OptionalInt arrivalDelay();
}
