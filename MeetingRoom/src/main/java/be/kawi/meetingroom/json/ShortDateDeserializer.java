package be.kawi.meetingroom.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;


public class ShortDateDeserializer extends JsonDeserializer<Date>{

		@Override
		public Date deserialize(JsonParser parser, DeserializationContext context)
				throws IOException, JsonProcessingException {
			DateFormat df = new SimpleDateFormat(DateUtil.SHORT_DATE_FORMAT, Locale.ENGLISH);
			try {
				return df.parse(parser.getText());
			} catch (ParseException e) {
				return null;
			}
		}

	}


