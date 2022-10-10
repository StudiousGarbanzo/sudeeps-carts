package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStationMeta.class)
@JsonDeserialize(as = ImmutableStationMeta.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface StationMeta {
	boolean stoppingStation();

	boolean divertedStation();

	boolean cancelledStation();

	OptionalInt distanceRemaining();

	Optional<List<String>> details();
}
