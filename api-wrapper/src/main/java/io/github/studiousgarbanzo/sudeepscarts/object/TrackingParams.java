package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableTrackingParams.class)
@JsonDeserialize(as = ImmutableTrackingParams.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface TrackingParams {
	String channelCode();

	String affiliateCode();
}
