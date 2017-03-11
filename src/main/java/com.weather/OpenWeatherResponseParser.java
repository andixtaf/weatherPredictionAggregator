package com.weather;

import org.json.JSONObject;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Stateless
public class OpenWeatherResponseParser
{
	public OpenWeatherResponse parseResponse(String response)
	{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(OpenWeatherResponse.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (OpenWeatherResponse) jaxbUnmarshaller.unmarshal(new StringReader(response));
		} catch (Exception e) {
			throw new WeatherRuntimeException(e.getMessage(), e);
		}
	}


	public static OpenWeatherResponse parse(String response)
	{
		OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();

		JSONObject json = new JSONObject(response);

		JSONObject coord = json.getJSONObject("coord");

		Coordinate coordinate = new Coordinate(coord.getInt("lon"), coord.getInt("lat"));

		openWeatherResponse.setCoordinate(coordinate);

		JSONObject main = json.getJSONObject("main");

		WeatherData weatherData = new WeatherData.WeatherDataBuilder(main.getDouble("temp"), main.getDouble("temp_min"),
				main.getDouble("temp_max")).pressure(main.getInt("pressure")).humidity(main.getInt("humidity")).build();

		openWeatherResponse.setWeatherData(weatherData);


		return openWeatherResponse;
	}
}
