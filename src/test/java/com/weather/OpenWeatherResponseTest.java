package com.weather;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.net.URL;

/**
 * Created on 10.03.17
 */
public class OpenWeatherResponseTest
{
//	@InjectMocks
//	private OpenWeatherResponseParser openWeatherResponseParser = new OpenWeatherResponseParser();

	@Test
	public void testResponseMapping() throws Exception
	{
		String key = "";

		String url = "http://api.openweathermap.org/data/2.5/weather?q=Cologne,Berlin,de&appid="+key;
		String genreJson = IOUtils.toString(new URL(url));
		JSONObject json = new JSONObject(genreJson);
		// get the title
		System.out.println(json.get("title"));
		// get the data
		JSONArray genreArray = (JSONArray) json.get("dataset");
		// get the first genre
		JSONObject firstGenre = (JSONObject) genreArray.get(0);
		System.out.println(firstGenre.get("genre_title"));


//		OpenWeatherResponse response = openWeatherResponseParser.parseResponse(responseJson);

//		assertThat("357985368", is(response));
	}
}