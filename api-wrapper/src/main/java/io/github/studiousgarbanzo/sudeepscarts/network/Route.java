package io.github.studiousgarbanzo.sudeepscarts.network;

import java.net.URI;

public record Route(HttpMethod method, URI uri) {
	public static final Route TRAINS = new Route(HttpMethod.POST, URI.create("https://railways.makemytrip.com/api/trains"));
	public static final Route TRAIN_SEARCH = new Route(HttpMethod.GET, URI.create("https://ground-auto-suggest.makemytrip.com/rails/autosuggest/stations"));
}
