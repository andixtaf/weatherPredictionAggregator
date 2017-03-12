package com.weather;

/**
 * Created by andreas on 11.03.17.
 */
public class OpenWeatherResponse
{

	private String weatherStationName;
	private Coordinate coordinate;
	private WeatherData weatherData;
	private Wind wind;

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

	public void setWind(Wind wind)
	{
		this.wind = wind;
	}

	public Wind getWind()
	{
		return wind;
	}

	public void setWeatherStationName(String name)
	{
		weatherStationName = name;
	}

	public String getWeatherStationName()
	{
		return weatherStationName;
	}
}
