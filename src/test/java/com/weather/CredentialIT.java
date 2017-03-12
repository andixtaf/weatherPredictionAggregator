package com.weather;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by andreas on 12.03.17.
 */
public class CredentialIT
{
	private EntityManager em;
	private EntityTransaction tx;

	@Before
	public void initEm()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("it");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@Test
	public void verifyMappings() throws Exception
	{
		tx.begin();
		em.merge(new Credential("openweather"));
		tx.commit();

		System.out.println("test");
	}

}