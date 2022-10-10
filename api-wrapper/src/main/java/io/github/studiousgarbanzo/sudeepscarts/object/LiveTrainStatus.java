package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLiveTrainStatus.class)
@JsonDeserialize(as = ImmutableLiveTrainStatus.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LiveTrainStatus {
	LiveTrainDetails trainDetails();

	List<StationHalt> stations();

	String lastUpdated();
}
