package com.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.shop.model.Address;
import com.shop.model.Item;
import com.shop.model.Product;
import com.shop.model.User;
import com.shop.utils.HibernateUtil;
import com.teamdev.jxbrowser.chromium.internal.ipc.message.GetHTMLMessage;

public class ItemService {
	//����id��ȡ������Ʒ��Ϣ
	public static Product forIdGetItemInfo(int id) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM Item t where t.id=?");
						 query.setParameter(0, id);
						 
			List<Item> list=query.list();
			
			int proId=list.get(0).getProductId();//�û�id
			
			//����ͼƬ�����ҵ�ͼƬid
			Query query1 = session
					 .createQuery("select t FROM Product t where t.id=?");
					 query1.setParameter(0, proId);
					List<Product> list1=query1.list();
					 
					 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
		    
			session.getTransaction().commit();
			session.close();
			return list1.get(0);
		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��"+e);
		}
	}
	
	// �����û���emailΪ���û�����ջ���ַ
	public static void addItem(String name,String productName,String status) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//�û�id
			//����ͼƬ�����ҵ�ͼƬid
			Query query1 = session
					 .createQuery("select t FROM Product t where t.photo=?");
					 query1.setParameter(0, productName);
					 List<Product> list1=query1.list();
			int productId=list1.get(0).getId();
			
			
			Item item=new Item();
			item.setProductId(productId);
			item.setUserId(userId);
			item.setTypeStatus(status);
			Date date=new Date();
			String str=date.toString();
			item.setTime(str);
			session.save(item);
			
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��");
		}

	}

	public static List<Product> getItemInfo(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//�û�id
			//����ͼƬ�����ҵ�ͼƬid
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=?");
					 query1.setParameter(0, userId);
					 List<Item> list1=query1.list();
					 
					 int[] index=new int[list1.size()];
					 List<Product> proList=new ArrayList<Product>();
					 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
		    for(int i=0;i<list1.size();i++)
		    {
		    	index[i]=list1.get(i).getProductId();
		    	Query query2 = session
						 .createQuery("select t FROM Product t where t.id=?");
		    	 query2.setParameter(0, index[i]);
		    	Product pro=(Product) query2.list().get(0);
		    	proList.add(pro);
		    	
		    }
			session.getTransaction().commit();
			session.close();
			return proList;
		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��");
		}
	}
	//ɾ�����׳ɹ��Ķ���
	public static void SureItemSuccess(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//�û�id
			//����ͼƬ�����ҵ�ͼƬid
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
					 query1.setParameter(0, userId);
					 query1.setParameter(1, "1");
					 List<Item> list1=query1.list();
					 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
		    for(int i=0;i<list1.size();i++)
		    {
		        Item item=(Item) session.get(Item.class, list1.get(i).getId());
		        
		    	item.setTypeStatus("3");
		    	session.update(item);
		    	
		    }
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��"+e);
		}
	}
	
	
	//�õ����׳ɹ��Ĳ�Ʒ��Ϣ
	public static List<Product> getSuccessItemInfo(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//�û�id
			//�ҵ�ָ���û�id��ָ����Ʒ״̬�Ĳ�Ʒid
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
					 query1.setParameter(0, userId);
					 query1.setParameter(1, "1");
					 List<Item> list1=query1.list();
					 
					 int[] index=new int[list1.size()];
					 List<Product> proList=new ArrayList<Product>();
					 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
		    for(int i=0;i<list1.size();i++)
		    {
		    	index[i]=list1.get(i).getProductId();
		    	Query query2 = session
						 .createQuery("select t FROM Product t where t.id=?");
		    	 query2.setParameter(0, index[i]);
		    	Product pro=(Product) query2.list().get(0);
		    	proList.add(pro);
		    	
		    }
			session.getTransaction().commit();
			session.close();
			return proList;
		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��"+e);
		}
	}
	//�õ�ȷ��Ҫ�ջ��Ĳ�ƽ�Ĳ�Ʒ��Ϣ
		public static List<Product> getSuccessItem(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//�����û������ҵ��û�id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//�û�id
				//�ҵ�ָ���û�id��ָ����Ʒ״̬�Ĳ�Ʒid
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "3");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
			    for(int i=0;i<list1.size();i++)
			    {
			    	index[i]=list1.get(i).getProductId();
			    	Query query2 = session
							 .createQuery("select t FROM Product t where t.id=?");
			    	 query2.setParameter(0, index[i]);
			    	Product pro=(Product) query2.list().get(0);
			    	proList.add(pro);
			    	
			    }
				session.getTransaction().commit();
				session.close();
				return proList;
			} catch (Exception e) {
				throw new RuntimeException("��ӵ�ַʧ��"+e);
			}
		}
	
	//�õ�ȷ���ջ��Ĳ�Ʒ
	//�õ����׳ɹ��Ĳ�Ʒ��Ϣ
		public static List<Product> getSureSuccessItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//�����û������ҵ��û�id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//�û�id
				//�ҵ�ָ���û�id��ָ����Ʒ״̬�Ĳ�Ʒid
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "3");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
			    for(int i=0;i<list1.size();i++)
			    {
			    	index[i]=list1.get(i).getProductId();
			    	Query query2 = session
							 .createQuery("select t FROM Product t where t.id=?");
			    	 query2.setParameter(0, index[i]);
			    	Product pro=(Product) query2.list().get(0);
			    	proList.add(pro);
			    	
			    }
				session.getTransaction().commit();
				session.close();
				return proList;
			} catch (Exception e) {
				throw new RuntimeException("��ӵ�ַʧ��"+e);
			}
		}
	//�õ�����ʧ�ܵĲ�Ʒ
		public static List<Product> getFailItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//�����û������ҵ��û�id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//�û�id
				//�ҵ�ָ���û�id��ָ����Ʒ״̬�Ĳ�Ʒid
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "0");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //���ݲ�Ʒid���Ҳ�Ʒ��Ϣ
			    for(int i=0;i<list1.size();i++)
			    {
			    	index[i]=list1.get(i).getProductId();
			    	Query query2 = session
							 .createQuery("select t FROM Product t where t.id=?");
			    	 query2.setParameter(0, index[i]);
			    	Product pro=(Product) query2.list().get(0);
			    	proList.add(pro);
			    	
			    }
				session.getTransaction().commit();
				session.close();
				return proList;
			} catch (Exception e) {
				throw new RuntimeException("��ӵ�ַʧ��"+e);
			}
		}
	//ɾ��ʧ�ܵĶ�����Ϣ
		public static void deleteFailItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//�����û������ҵ��û�id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//�û�id
				//�ҵ�ָ���û�id��ָ����Ʒ״̬�Ĳ�Ʒid
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "0");
						 List<Item> list1=query1.list();
						 
			    for(int i=0;i<list1.size();i++)
			    {
			    	session.delete(list1.get(i));
			    }
				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {
				throw new RuntimeException("��ӵ�ַʧ��"+e);
			}
		}
		
		
		
		
//�õ�������Ϣ
	public static List<Item> getItemInfos(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//�����û������ҵ��û�id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//�û�id
			//����ͼƬ�����ҵ�ͼƬid
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=?");
					 query1.setParameter(0, userId);
					 List<Item> list1=query1.list();
					 
					 
			session.getTransaction().commit();
			session.close();
			return list1;
		} catch (Exception e) {
			throw new RuntimeException("��ӵ�ַʧ��");
		}
	}
	
	// // ɾ���û��ջ��ַ
	// public static void removeUserReceiveAddress(int id) throws
	// RuntimeException {
	// try {
	// Session session = HibernateUtil.openSession();
	// session.beginTransaction();
	// Query query = session
	// .createQuery("select t FROM Address t where t.id=?");
	// query.setParameter(0, id);
	// Address address = (Address) query.list().get(0);
	// // �õ�ָ�����û�
	// session.delete(address);
	// session.getTransaction().commit();
	// session.close();
	//
	// } catch (Exception e) {
	// throw new RuntimeException("��ӵ�ַʧ��");
	// }
	//
	// }
	//
	// // �����û�email�����û������ջ���ַ
	// public static List<Address> getAllUserAddress(String user_email)
	// throws RuntimeException {
	// try {
	// Session session = HibernateUtil.openSession();
	// session.beginTransaction();
	// Query query = session
	// .createQuery("select t FROM User t where t.user_email=?");
	// query.setParameter(0, user_email);
	// User user = (User) query.list().get(0);
	// int id = user.getUser_id();
	// // ������user_id��hql�����д��user.id��������������˼��д
	// Query query1 = session
	// .createQuery("select t FROM Address t where t.user.id=? ");
	// query1.setParameter(0, id);
	// List<Address> list = query1.list();
	// session.getTransaction().commit();
	// session.close();
	// return list;
	// } catch (Exception e) {
	// throw new RuntimeException("��ѯ��ַ��Ϣʧ��");
	// }
	//
	// }

}
