package io.github.boogiemonster1o1.sudeepscarts.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ClientModInitializer;

public class SudeepsCarts implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("sudeepscarts");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello Fabric world!");
	}
}
