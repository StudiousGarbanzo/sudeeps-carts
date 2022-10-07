package io.github.studiousgarbanzo.sudeepscarts.object.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class YNBooleanSerializer extends JsonSerializer<Boolean> {
	@Override
	public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeString(value ? "Y" : "N");
	}
}
