package com.weather;

/**
 * Created by andreas on 11.03.17.
 */
public class Coordinate
{

	private Integer longitude;
	private Integer latitude;

	public Coordinate(Integer longitude, Integer latitude)
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Integer getLongitude()
	{
		return longitude;
	}

	public Integer getLatitude()
	{
		return latitude;
	}
}
