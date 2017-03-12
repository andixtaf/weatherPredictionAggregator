package com.weather;

import org.json.JSONObject;

import javax.ejb.Stateless;

@Stateless
public class OpenWeatherResponseParser
{

	public OpenWeatherResponse parse(String response)
	{
		OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();

		JSONObject json = new JSONObject(response);

		openWeatherResponse.setCoordinate(createCoordinate(json));
		openWeatherResponse.setWeatherData(createWeatherData(json));
		openWeatherResponse.setWind(createWind(json));
		openWeatherResponse.setWeatherStationName(json.getString("name"));


		return openWeatherResponse;
	}

	private WeatherData createWeatherData(JSONObject json)
	{
		JSONObject main = json.getJSONObject("main");

		return new WeatherData.WeatherDataBuilder(main.getDouble("temp"), main.getDouble("temp_min"),
				main.getDouble("temp_max")).pressure(main.getInt("pressure")).humidity(main.getInt("humidity")).build();
	}

	private Coordinate createCoordinate(JSONObject json)
	{
		JSONObject coord = json.getJSONObject("coord");

		return new Coordinate(coord.getInt("lon"), coord.getInt("lat"));
	}

	private Wind createWind(JSONObject json)
	{
		JSONObject wind = json.getJSONObject("wind");

		return new Wind(wind.getDouble("speed"), wind.getDouble("deg"));
	}
}
