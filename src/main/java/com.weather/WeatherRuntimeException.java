package com.weather;

public class WeatherRuntimeException extends RuntimeException
{
	public WeatherRuntimeException(String message)
	{
		super(message);
	}

	public WeatherRuntimeException(String message, Throwable throwable)
	{
		super(message, throwable);
	}

	public WeatherRuntimeException(Throwable throwable)
	{
		super(throwable.getMessage(), throwable);
	}
}
