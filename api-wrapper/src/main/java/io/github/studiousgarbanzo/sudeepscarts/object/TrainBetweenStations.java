package io.github.studiousgarbanzo.sudeepscarts.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.studiousgarbanzo.sudeepscarts.object.serializer.YNBooleanDeserializer;
import io.github.studiousgarbanzo.sudeepscarts.object.serializer.YNBooleanSerializer;
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

	int distance();

	int duration();

	@JsonProperty("frmStnCode")
	String fromStnCode();

	@JsonProperty("frmStnName")
	String fromStationName();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningFri")
	Boolean runningFriday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningMon")
	Boolean runningMonday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningSat")
	Boolean runningSaturday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningSun")
	Boolean runningSunday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningThu")
	Boolean runningThursday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningTue")
	Boolean runningTuesday();

	@JsonDeserialize(using = YNBooleanDeserializer.class)
	@JsonSerialize(using = YNBooleanSerializer.class)
	@JsonProperty("runningWed")
	Boolean runningWednesday();

	@JsonProperty("toStnCode")
	String toStationCode();

	@JsonProperty("toStnName")
	String toStationName();

	@JsonProperty("trainName")
	String trainName();

	String trainNumber();

	String[] trainType();

	@JsonProperty("tbsAvailability")
	QuotaAvailability[] quotaAvailabilities();

	boolean bookingAllowed();

	boolean tatkalApplicable();

	int sourceDistance();

	int destinationDistance();

	boolean clusterTrain();

	String trainOwner();

	double trainQuotaCombinedScore();

	int trainNamePriority();

	int durationHours();

	int durationMinutes();

	String departureMeridiem();

	String arrivalMeridiem();

	String departureTime12hFormat();

	String arrivalTime12hFormat();

	String fromDay();

	String toDay();
}
