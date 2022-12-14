package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStationSearchResult.class)
@JsonDeserialize(as = ImmutableStationSearchResult.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface StationSearchResult {
	@JsonProperty("dn")
	String name();

	@JsonProperty("irctc_code")
	String code();
}
