	package com.jsp.Dao;

import java.util.Iterator;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Dto.User;

@Repository
public class UserDao
{

	@Autowired
	EntityManager em;
	
	@Autowired
	EntityTransaction et;
	
	//to store user objects to database
	public void saveUser(User u)
	{
		et.begin();
		em.persist(u);
		et.commit();
	}
	
	
	//to validate login credentials
	public int validateUser(User u)
	{
		String email=u.getEmail();
		String password=u.getPassword();
		
		Query q=em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<User>l=q.getResultList();
		Iterator<User> i=l.iterator();
		if(i.hasNext())
		{
			return 1;
		}
		else
		{
		return 0;
		}
	}
}
