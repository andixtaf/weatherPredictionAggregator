package com.weather;

/**
 * Created by andreas on 12.03.17.
 */
public class Wind
{
	private Double speed;
	private Double direction;


	public Wind(Double speed, Double direction)
	{
		this.speed = speed;
		this.direction = direction;
	}

	public Double getSpeed()
	{
		return speed;
	}

	public Double getDirection()
	{
		return direction;
	}
}
