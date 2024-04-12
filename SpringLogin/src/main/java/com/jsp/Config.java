package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jsp")
public class Config
{

	@Bean
	public EntityManager getEntityManager()
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("naveen");
		
		return emf.createEntityManager();
	}
	
	@Bean
	public EntityTransaction geEntityTransaction()
	{
		EntityManager em=getEntityManager();
		
		return em.getTransaction();
	}
}
