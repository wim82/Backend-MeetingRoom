package be.kawi.meetingroom.json;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;


public class ShortDateSerializer extends SerializerBase<Date> {
	
	protected ShortDateSerializer() {
		super(Date.class);
	}

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonGenerationException {
		DateFormat df = new SimpleDateFormat(DateUtil.SHORT_DATE_FORMAT, Locale.ENGLISH);
		generator.writeString(df.format(date));
	}
}

