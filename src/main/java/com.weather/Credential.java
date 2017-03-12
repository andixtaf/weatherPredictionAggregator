package com.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by andreas on 12.03.17.
 */
@Entity
public class Credential
{
	@Id
	@GeneratedValue
	private long id;
	private String name;

	public String getName()
	{
		return name;
	}

	private String api_key;

	public Credential(String name)
	{
		this.name = name;
	}

	public Credential()
	{
	}


}
