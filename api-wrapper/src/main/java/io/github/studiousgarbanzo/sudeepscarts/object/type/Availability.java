package io.github.studiousgarbanzo.sudeepscarts.object.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Availability {
	NOT_AVAILABLE("0"),
	AVAILABLE("1"),
	RAC("2"),
	WAITLISTED("3");

	private final String value;

	Availability(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
