package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLiveTrainMeta.class)
@JsonDeserialize(as = ImmutableLiveTrainMeta.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LiveTrainMeta {
	StationHalt currentStation();

	@JsonProperty("topStation")
	StationHalt nextStation();

	@JsonProperty("bottomtStation")
	StationHalt lastStation();

	LiveOtherDetails otherDetails();
}
