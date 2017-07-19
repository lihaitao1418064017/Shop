package com.shop.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.shop.model.Product;
import com.shop.utils.HibernateUtil;

public class ProductService {
	
	// ��ȡ��Ʒ��ϸ��Ϣ
		public static Product getProductMinute(String photo)
				throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t from Product t where t.photo=?");
				query.setParameter(0, photo);
				List<Product> list = query.list();
				System.out.println(list);
				session.getTransaction().commit();
				session.close();
				return list.get(0);
			} catch (Exception e) {
				throw new RuntimeException("��ȡ������Ʒʧ��");
			}

		}
		
	//�����Ʒ
	public static void addProduct(String name, String descriptive)
			throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Product product = new Product();
			product.setDescriptive(descriptive);
			product.setName(name);

			session.save(product);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			throw new RuntimeException("�����Ʒʧ��");
		}

	}

	// ��ȡ������Ʒ
	public static List<Product> getHotProduct(String isHot)
			throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t from Product t where t.isHot=?");
			query.setParameter(0, isHot);
			List<Product> list = query.list();

			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException("��ȡ������Ʒʧ��");
		}

	}
	
	
 
	// ��ȡ������Ʒ
		public static List<Product> getActivityProduct(String isHot)
				throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t from Product t where t.isHot=?");
				query.setParameter(0, isHot);
				List<Product> list = query.list();
				session.getTransaction().commit();
				session.close();
				return list;
			} catch (Exception e) {
				throw new RuntimeException("��ȡ���Ʒʧ��"+e);
			}

		}
		
		
		// ��ȡ��ͨ��Ʒ
		public static List<Product> getOrderProduct(String isHot)
				throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t from Product t where t.isHot=?");
				query.setParameter(0, isHot);
				List<Product> list = query.list();
				session.getTransaction().commit();
				session.close();
				return list;
			} catch (Exception e) {
				throw new RuntimeException("��ȡ���Ʒʧ��"+e);
			}

		}
		
}
