package io.github.studiousgarbanzo.sudeepscarts.object.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TravelClass {
	FIRST_AC("1A"),
	AC_2_TIER("2A"),
	AC_3_TIER("3A"),
	SLEEPER("SL"),
	SECOND_SEATING("2S"),
	AC_3_TIER_ECONOMY("3E"),
	@Deprecated
	FIRST_CLASS("FC"),
	CHAIR_CAR("CC");

	private final String code;

	TravelClass(String code) {
		this.code = code;
	}

	@JsonValue
	public String code() {
		return code;
	}
}
