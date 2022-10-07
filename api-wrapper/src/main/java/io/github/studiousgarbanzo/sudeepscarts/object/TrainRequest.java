package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.Optional;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableTrainRequest.class)
@JsonDeserialize(as = ImmutableTrainRequest.class)
public interface TrainRequest {
	String srcStn();

	String destStn();

	String date();

	Optional<String> mmtAuth();

	Optional<String> myBusinessSubscription();
}
