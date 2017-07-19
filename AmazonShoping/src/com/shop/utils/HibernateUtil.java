package com.shop.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.shop.model.Address;
import com.shop.model.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
		private static Configuration configuration=new Configuration();
		static{
//		 configuration.configure().addClass(Address.class);
		//默认是hibernate.cfg.xml
		 sessionFactory=configuration.configure().buildSessionFactory();
		 
		}
	
//		sessionFactory = new Configuration()//
//				.configure()//
//				.buildSessionFactory();

	

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSession()
	{
		getSessionFactory().close();
	}
	public static Session openSession() {
		return getSessionFactory().openSession();
	}
	
//	// 初始化整个数据库
//		public static void initDatabase()
//		{
//			SchemaExport export = new SchemaExport(configuration);
//			export.create(true, true);
//		}

}
