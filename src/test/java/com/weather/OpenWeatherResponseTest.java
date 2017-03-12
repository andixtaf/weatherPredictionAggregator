package com.weather;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 10.03.17
 */
public class OpenWeatherResponseTest
{

	private OpenWeatherResponseParser openWeatherResponseParser = new OpenWeatherResponseParser();

	private String response;

	@Before
	public void setUp() throws Exception
	{
		response = "{\"coord\":{\"lon\":139,\"lat\":35},\n" +
				"\"sys\":{\"country\":\"JP\",\"sunrise\":1369769524,\"sunset\":1369821049},\n" +
				"\"weather\":[{\"id\":804,\"main\":\"clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\n" +
				"\"main\":{\"temp\":289.5,\"humidity\":89,\"pressure\":1013,\"temp_min\":287.04,\"temp_max\":292.04},\n" +
				"\"wind\":{\"speed\":7.31,\"deg\":187.002},\n" +
				"\"rain\":{\"3h\":0},\n" +
				"\"clouds\":{\"all\":92},\n" +
				"\"dt\":1369824698,\n" +
				"\"id\":1851632,\n" +
				"\"name\":\"Shuzenji\",\n" +
				"\"cod\":200}";
	}

	@Test
	public void testResponseMappingCoordinates() throws Exception
	{
		OpenWeatherResponse openWeatherResponse = openWeatherResponseParser.parse(response);

		assertThat(openWeatherResponse.getCoordinate().getLatitude(), is(35));
		assertThat(openWeatherResponse.getCoordinate().getLongitude(), is(139));
	}

	@Test
	public void testResponseMappingWeatherData() throws Exception
	{
		OpenWeatherResponse openWeatherResponse = openWeatherResponseParser.parse(response);

		assertThat(openWeatherResponse.getWeatherData().getTemperature(), is(289.5));
		assertThat(openWeatherResponse.getWeatherData().getTemperatureMin(), is(287.04));
		assertThat(openWeatherResponse.getWeatherData().getTemperatureMax(), is(292.04));
		assertThat(openWeatherResponse.getWeatherData().getPressure(), is(1013));
		assertThat(openWeatherResponse.getWeatherData().getHumidity(), is(89));
	}

	@Test
	public void testResponseMappingWind() throws Exception
	{
		OpenWeatherResponse openWeatherResponse = openWeatherResponseParser.parse(response);

		assertThat(openWeatherResponse.getWind().getSpeed(), is(7.31));
		assertThat(openWeatherResponse.getWind().getDirection(), is(187.002));
	}

	@Test
	public void testResponseMappingWeatherStationName() throws Exception
	{
		OpenWeatherResponse openWeatherResponse = openWeatherResponseParser.parse(response);

		assertThat(openWeatherResponse.getWeatherStationName(), is("Shuzenji"));
	}
}