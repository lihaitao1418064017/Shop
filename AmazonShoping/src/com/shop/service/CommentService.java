package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.shop.model.Address;
import com.shop.model.Comment;
import com.shop.model.Item;
import com.shop.model.User;
import com.shop.utils.HibernateUtil;

public class CommentService {
	
	// 根据用户的email为该用户添加收货地址
		public static void addComment(String content,String user_email,int i) throws RuntimeException {
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, user_email);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				
				Query query1 = session
						.createQuery("select t FROM Item t where t.userId=? and t.typeStatus=? ");
				query1.setParameter(0, 1);
				query1.setParameter(1, "3");
				
				Item item = (Item) query1.list().get(i);
				System.out.println(item);
				Item ite=(Item) session.get(Item.class, item.getId());
				Comment comment=new Comment();
				comment.setContent(content);
				comment.setItem(ite);
				session.save(comment);
				session.getTransaction().commit();
				session.close();

			} catch (Exception e) {
				throw new RuntimeException("添加地址失败"+e.getMessage());
			}

		}
		//获取评论信息
		public static List<Comment>  getAllCommentInfo(String name)
		{
			try {
				Session session = HibernateUtil.openSession();
				session.beginTransaction();
				Query query = session
						.createQuery("select t FROM User t where t.user_email=?");
				query.setParameter(0, name);
				User user = (User) query.list().get(0);
				int id = user.getUser_id();
				
				
				// 将属性user_id在hql语句中写成user.id，利用面相对象的思想写
				Query query1 = session.createQuery("select t FROM Item t where t.userId=? and t.typeStatus=? ");
				query1.setParameter(0, id);
				query1.setParameter(1, "3");
				List<Item> list = query1.list();
				List<Comment> commentList=new ArrayList<Comment>();
				for(int i=0;i<list.size();i++)
				{
					System.out.println(list.get(i).getId());
					Query query3=session.createQuery("select t FROM Comment t where t.item.id=?");
					
					query3.setParameter(0, list.get(i).getId());		
					Comment comment=(Comment) query3.list().get(0);
					commentList.add(comment);
				}
				session.getTransaction().commit();
				session.close();
				return commentList;
			} catch (Exception e) {
				throw new RuntimeException("查询地址信息失败"+e);
			}
			
			
			
		}

}
