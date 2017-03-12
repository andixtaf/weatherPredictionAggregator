package com.weather;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by andreas on 12.03.17.
 */
public class Client
{
	public String callUrl()
	{
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget myResource = client.target("http://example.com/webapi/read");
		String response = myResource.request(MediaType.TEXT_PLAIN)
				.get(String.class);

		System.out.println("URL response -> " + response);

		return response;
	}
}
