package io.github.studiousgarbanzo.sudeepscarts.object;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.studiousgarbanzo.sudeepscarts.object.type.TravelClass;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableTrainBetweenStations.class)
@JsonDeserialize(as = ImmutableTrainBetweenStations.class)
public interface TrainBetweenStations {
	String arrivalTime();

	@JsonProperty("avlClasses")
	TravelClass[] availableClasses();

	String departureTime();
}
