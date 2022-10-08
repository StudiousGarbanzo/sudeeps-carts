package io.github.studiousgarbanzo.sudeepscarts.object.type;

public enum WaitingListType {
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	GENERAL("9"),
	TEN("10"),
	REGRET("11"),
	REMOTE_LOCATION("12");

	private final String value;

	WaitingListType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
