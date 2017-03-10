package com.weather;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Stateless
public class OpenWeatherResponseParser
{
	public OpenWeatherResponse parseResponse(String response)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(OpenWeatherResponse.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (OpenWeatherResponse) jaxbUnmarshaller.unmarshal(new StringReader(response));
		}
		catch(Exception e)
		{
			throw new WeatherRuntimeException(e.getMessage(), e);
		}
	}
}
