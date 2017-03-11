package com.weather;

/**
 * Created by andreas on 11.03.17.
 */
public class OpenWeatherResponse
{

	private Coordinate coordinate;
	private WeatherData weatherData;

	public void setCoordinate(Coordinate coordinate)
	{
		this.coordinate = coordinate;
	}

	public void setWeatherData(WeatherData weatherData)
	{
		this.weatherData = weatherData;
	}

	public Coordinate getCoordinate()
	{
		return coordinate;
	}

	public WeatherData getWeatherData()
	{
		return weatherData;
	}
}
