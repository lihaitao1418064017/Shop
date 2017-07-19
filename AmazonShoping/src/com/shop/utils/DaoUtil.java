package com.shop.utils;

import org.hibernate.Session;

public class DaoUtil
{

	public static void addObject(Object domainObject) throws RuntimeException
	{
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(domainObject);
		session.getTransaction().commit();
	}

	public static void updateObject(Object domainObject) throws RuntimeException
	{
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(domainObject);
		session.getTransaction().commit();
	}

	public static void removeObject(Object domainObject) throws RuntimeException
	{
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.delete(domainObject);
		session.getTransaction().commit();
	}

//	

}
