package io.github.studiousgarbanzo.sudeepscarts.network;

public record Route(HttpMethod method, String url) {
	public static final Route TRAINS = new Route(HttpMethod.POST, "https://railways.makemytrip.com/api/trains");
	public static final Route TRAIN_SEARCH = new Route(HttpMethod.GET, "https://ground-auto-suggest.makemytrip.com/rails/autosuggest/stations?limit=10&search_query={query}&version=v1");

	public static final Route LIVE_TRAIN_STATUS = new Route(HttpMethod.POST, "https://mapi.makemytrip.com/api/rails/train/livestatus/v1?region=in&language=eng&currency=inr");
}
