package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStationInfo.class)
@JsonDeserialize(as = ImmutableStationInfo.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface StationInfo {
	String name();

	String code();

	OptionalInt distance();

	OptionalInt expectedPlatformNumber();
}
