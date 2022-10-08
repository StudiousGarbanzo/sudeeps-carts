package io.github.studiousgarbanzo.sudeepscarts.object;

import java.util.Optional;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.studiousgarbanzo.sudeepscarts.object.type.Quota;
import io.github.studiousgarbanzo.sudeepscarts.object.type.TravelClass;
import io.github.studiousgarbanzo.sudeepscarts.object.type.WaitingListType;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableQuotaAvailability.class)
@JsonDeserialize(as = ImmutableQuotaAvailability.class)
public interface QuotaAvailability {
	Optional<String> lastUpdatedOn();

	long lastUpdatedOnRaw();

	Optional<String> availablityDate();

	Optional<String> availablityStatus();

	Optional<String> prettyPrintingAvailablityStatus();

	Optional<String> availablityType();

	Optional<String> reason();

	Optional<String> reasonType();

	@JsonProperty("wlType")
	OptionalInt waitingListType();

	Optional<String> currentBkgFlag();

	Optional<String> classType();

	Quota quota();

	int totalFare();

	TravelClass className();

	double availablityScore();

	double classWt();

	double availAndClassScoreCombined();

	double cumulativeQuotaScore();

	double quotaScore();

	OptionalInt predictionPercentage();
}
