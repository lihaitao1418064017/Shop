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
	//根据id获取订单产品信息
	public static Product forIdGetItemInfo(int id) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM Item t where t.id=?");
						 query.setParameter(0, id);
						 
			List<Item> list=query.list();
			
			int proId=list.get(0).getProductId();//用户id
			
			//根据图片姓名找到图片id
			Query query1 = session
					 .createQuery("select t FROM Product t where t.id=?");
					 query1.setParameter(0, proId);
					List<Product> list1=query1.list();
					 
					 //根据产品id查找产品信息
		    
			session.getTransaction().commit();
			session.close();
			return list1.get(0);
		} catch (Exception e) {
			throw new RuntimeException("添加地址失败"+e);
		}
	}
	
	// 根据用户的email为该用户添加收货地址
	public static void addItem(String name,String productName,String status) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//用户id
			//根据图片姓名找到图片id
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
			throw new RuntimeException("添加地址失败");
		}

	}

	public static List<Product> getItemInfo(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//用户id
			//根据图片姓名找到图片id
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=?");
					 query1.setParameter(0, userId);
					 List<Item> list1=query1.list();
					 
					 int[] index=new int[list1.size()];
					 List<Product> proList=new ArrayList<Product>();
					 //根据产品id查找产品信息
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
			throw new RuntimeException("添加地址失败");
		}
	}
	//删除交易成功的订单
	public static void SureItemSuccess(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//用户id
			//根据图片姓名找到图片id
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
					 query1.setParameter(0, userId);
					 query1.setParameter(1, "1");
					 List<Item> list1=query1.list();
					 //根据产品id查找产品信息
		    for(int i=0;i<list1.size();i++)
		    {
		        Item item=(Item) session.get(Item.class, list1.get(i).getId());
		        
		    	item.setTypeStatus("3");
		    	session.update(item);
		    	
		    }
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			throw new RuntimeException("添加地址失败"+e);
		}
	}
	
	
	//得到交易成功的产品信息
	public static List<Product> getSuccessItemInfo(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//用户id
			//找到指定用户id和指定产品状态的产品id
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
					 query1.setParameter(0, userId);
					 query1.setParameter(1, "1");
					 List<Item> list1=query1.list();
					 
					 int[] index=new int[list1.size()];
					 List<Product> proList=new ArrayList<Product>();
					 //根据产品id查找产品信息
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
			throw new RuntimeException("添加地址失败"+e);
		}
	}
	//得到确认要收货的产平的产品信息
		public static List<Product> getSuccessItem(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//根据用户姓名找到用户id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//用户id
				//找到指定用户id和指定产品状态的产品id
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "3");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //根据产品id查找产品信息
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
				throw new RuntimeException("添加地址失败"+e);
			}
		}
	
	//得到确认收货的产品
	//得到交易成功的产品信息
		public static List<Product> getSureSuccessItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//根据用户姓名找到用户id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//用户id
				//找到指定用户id和指定产品状态的产品id
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "3");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //根据产品id查找产品信息
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
				throw new RuntimeException("添加地址失败"+e);
			}
		}
	//得到交易失败的产品
		public static List<Product> getFailItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//根据用户姓名找到用户id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//用户id
				//找到指定用户id和指定产品状态的产品id
				Query query1 = session
						 .createQuery("select t FROM Item t where t.userId=? and t.typeStatus=?");
						 query1.setParameter(0, userId);
						 query1.setParameter(1, "0");
						 List<Item> list1=query1.list();
						 
						 int[] index=new int[list1.size()];
						 List<Product> proList=new ArrayList<Product>();
						 //根据产品id查找产品信息
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
				throw new RuntimeException("添加地址失败"+e);
			}
		}
	//删除失败的订单信息
		public static void deleteFailItemInfo(String name) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				//根据用户姓名找到用户id
				 Query query = session
							 .createQuery("select t FROM User t where t.user_email=?");
							 query.setParameter(0, name);
				List<User> list=query.list();
				int userId=list.get(0).getUser_id();//用户id
				//找到指定用户id和指定产品状态的产品id
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
				throw new RuntimeException("添加地址失败"+e);
			}
		}
		
		
		
		
//得到订单信息
	public static List<Item> getItemInfos(String name) throws RuntimeException {
		try {
			Session session = HibernateUtil.openSession();
			session.beginTransaction();
			//根据用户姓名找到用户id
			 Query query = session
						 .createQuery("select t FROM User t where t.user_email=?");
						 query.setParameter(0, name);
			List<User> list=query.list();
			int userId=list.get(0).getUser_id();//用户id
			//根据图片姓名找到图片id
			Query query1 = session
					 .createQuery("select t FROM Item t where t.userId=?");
					 query1.setParameter(0, userId);
					 List<Item> list1=query1.list();
					 
					 
			session.getTransaction().commit();
			session.close();
			return list1;
		} catch (Exception e) {
			throw new RuntimeException("添加地址失败");
		}
	}
	
	// // 删除用户收获地址
	// public static void removeUserReceiveAddress(int id) throws
	// RuntimeException {
	// try {
	// Session session = HibernateUtil.openSession();
	// session.beginTransaction();
	// Query query = session
	// .createQuery("select t FROM Address t where t.id=?");
	// query.setParameter(0, id);
	// Address address = (Address) query.list().get(0);
	// // 得到指定的用户
	// session.delete(address);
	// session.getTransaction().commit();
	// session.close();
	//
	// } catch (Exception e) {
	// throw new RuntimeException("添加地址失败");
	// }
	//
	// }
	//
	// // 根据用户email查找用户所有收货地址
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
	// // 将属性user_id在hql语句中写成user.id，利用面相对象的思想写
	// Query query1 = session
	// .createQuery("select t FROM Address t where t.user.id=? ");
	// query1.setParameter(0, id);
	// List<Address> list = query1.list();
	// session.getTransaction().commit();
	// session.close();
	// return list;
	// } catch (Exception e) {
	// throw new RuntimeException("查询地址信息失败");
	// }
	//
	// }

}
