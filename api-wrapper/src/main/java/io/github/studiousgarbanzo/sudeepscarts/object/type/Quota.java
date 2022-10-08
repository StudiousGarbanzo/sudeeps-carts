package io.github.studiousgarbanzo.sudeepscarts.object.type;

public enum Quota {
	GN("General"),
	TQ("Tatkal"),
	LD("Ladies");

	private final String prettyName;

	Quota(String prettyName) {
		this.prettyName = prettyName;
	}

	public String prettyName() {
		return prettyName;
	}
}