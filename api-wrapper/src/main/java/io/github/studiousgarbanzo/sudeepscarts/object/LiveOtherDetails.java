package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLiveOtherDetails.class)
@JsonDeserialize(as = ImmutableLiveOtherDetails.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface LiveOtherDetails {
	String distanceDetail();

	String timeDetail();

	boolean delay();
}
