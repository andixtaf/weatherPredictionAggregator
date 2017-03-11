package com.weather;

/**
 * Created by andreas on 11.03.17.
 */
public class WeatherData
{

	private Double temperature;
	private Double temperatureMin;
	private Double temperatureMax;
	private Integer pressure;
	private Integer humidity;

	private WeatherData(WeatherDataBuilder builder)
	{
		this.temperature = builder.temperature;
		this.temperatureMin = builder.temperatureMin;
		this.temperatureMax = builder.temperatureMax;
		this.pressure = builder.pressure;
		this.humidity = builder.humidity;
	}


	public Double getTemperature()
	{
		return temperature;
	}

	public Double getTemperatureMin()
	{
		return temperatureMin;
	}

	public Double getTemperatureMax()
	{
		return temperatureMax;
	}

	public Integer getPressure()
	{
		return pressure;
	}

	public Integer getHumidity()
	{
		return humidity;
	}

	public static class WeatherDataBuilder
	{
		private Double temperature;
		private Double temperatureMin;
		private Double temperatureMax;
		private Integer pressure;
		private Integer humidity;

		public WeatherDataBuilder(Double temperature, Double temperatureMin, Double temperatureMax)
		{
			this.temperature = temperature;
			this.temperatureMin = temperatureMin;
			this.temperatureMax = temperatureMax;
		}

		public WeatherDataBuilder humidity(Integer humidity)
		{
			this.humidity = humidity;
			return this;
		}

		public WeatherDataBuilder pressure(Integer pressure)
		{
			this.pressure = pressure;
			return this;
		}

		public WeatherData build()
		{
			return new WeatherData(this);
		}
	}

}
