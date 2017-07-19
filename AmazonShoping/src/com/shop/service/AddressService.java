package com.shop.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.shop.model.Address;
import com.shop.model.Item;
import com.shop.model.User;
import com.shop.utils.HibernateUtil;
import com.teamdev.jxbrowser.chromium.internal.ipc.message.GetHTMLMessage;

public class AddressService {
	// �����û���emailΪ���û�����ջ���ַ
	public static void addUserReceiveAddress(String user_email,String province,String city,String area,
			String telephone,String receive_user,
			
			String minute_address) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			// �õ�ָ�����û�
			User u = (User) session.get(User.class, id);
			Address address = new Address();
			address.setUser(u);
			address.setProvince(province);
			address.setCity(city);
			address.setArea(area);
			address.setMinute_address(minute_address);
			address.setReceive_telephone(telephone);
			address.setReceive_user(receive_user);
			
			session.save(address);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��");
		}

	}

	// ɾ���û��ջ��ַ
	public static void removeUserReceiveAddress(int id) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM Address t where t.id=?");
			query.setParameter(0, id);
			Address address = (Address) query.list().get(0);
			// �õ�ָ�����û�
			session.delete(address);
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��");
		}

	}

	// �����û�email�����û������ջ���ַ
		public static void updateAddress(String address,String user_email,String totalPrice,String typeStatus)
				throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, user_email);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				System.out.println(id);
				// ������user_id��hql�����д��user.id��������������˼��д
				Query query1 = session
						.createQuery("select t FROM Item t where t.userId=? ");
				
				query1.setParameter(0, id);
				List<Item> list = query1.list();
				
				System.out.println(list.size()+"size");
				
				Item item=list.get(list.size()-1);
				System.out.println(item);
				item.setSendCompany(address);
				item.setTotalPrice(totalPrice);
				item.setTypeStatus(typeStatus);
				session.update(item);
				
				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {
				throw new RuntimeException("��ѯ��ַ��Ϣʧ��"+e);
			}

		}
	//���ø���ɹ�״̬
		public static void paySuccess(String address,String user_email,String totalPrice,String typeStatus)
				throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, user_email);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				System.out.println(id);
				// ������user_id��hql�����д��user.id��������������˼��д
				Query query1 = session
						.createQuery("select t FROM Item t where t.userId=?");
				
				query1.setParameter(0, id);
				List<Item> list = query1.list();
				
				for(int i=0;i<list.size();i++)
				{
				list.get(i).setSendCompany(address);
				list.get(i).setTotalPrice(totalPrice);
				list.get(i).setTypeStatus(typeStatus);
				session.update(list.get(i));
				}
				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {
				throw new RuntimeException("��ѯ��ַ��Ϣʧ��"+e);
			}

		}
	
	
	
	// �����û�email�����û������ջ���ַ
	public static List<Address> getAllUserAddress(String user_email)
			throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			Query query = session
					.createQuery("select t FROM User t where t.user_email=?");
			query.setParameter(0, user_email);
			User user = (User) query.list().get(0);
			int id = user.getUser_id();
			// ������user_id��hql�����д��user.id��������������˼��д
			Query query1 = session
					.createQuery("select t FROM Address t where t.user.id=? ");
			query1.setParameter(0, id);
			List<Address> list = query1.list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			throw new RuntimeException("��ѯ��ַ��Ϣʧ��");
		}

	}

}
