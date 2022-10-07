package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.studiousgarbanzo.sudeepscarts.object.type.Quota;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableTrainsStatus.class)
@JsonDeserialize(as = ImmutableTrainsStatus.class)
public interface TrainsStatus {
	MinPriceDetails minPriceDetails();

	int minDuration();

	Quota[] quotaList();

	// Ignore clientConfig

	boolean showAlternateAvailability();

	boolean noTrainFound();

	// Ignore mySafetyCardImgLink

	// Ignore mySafetyCardDetailsLink

	// Ignore safetyGuideLines

	boolean showBreakJourney();

	@JsonProperty("trainBtwnStnsList")
	TrainBetweenStations[] trainsBetweenStations();

	int wakeupTime();
}
